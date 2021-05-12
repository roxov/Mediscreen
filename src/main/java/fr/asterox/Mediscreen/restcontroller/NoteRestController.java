package fr.asterox.Mediscreen.restcontroller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.Mediscreen.dto.NoteDTO;
import fr.asterox.Mediscreen.proxy.NotesCentralProxy;

@RestController
@RequestMapping("rest/note")

public class NoteRestController {
	@Autowired
	NotesCentralProxy noteCentralProxy;

	private static final Logger LOGGER = LogManager.getLogger(NoteRestController.class);

	@PostMapping
	public NoteDTO addNote(@RequestBody NoteDTO note) {
		LOGGER.info("Adding new note");
		return noteCentralProxy.addNote(note);
	}

	@GetMapping(value = "/{id}")
	public NoteDTO getNoteById(@PathVariable("id") @NotNull(message = "note id is compulsory") Long noteId) {
		LOGGER.info("Getting note identified by id");
		return noteCentralProxy.getNoteById(noteId);
	}

	@GetMapping(value = "/list/patient/{id}")
	public List<NoteDTO> getAllPatientNotes(
			@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Getting all notes for patient identified by id : " + patientId);
		return noteCentralProxy.getAllPatientNotes(patientId);
	}

	@PutMapping(value = "/{id}")
	public NoteDTO updateNote(@PathVariable("id") @NotNull(message = "noteId is compulsory") Long noteId,
			@RequestBody NoteDTO note) {
		LOGGER.info("Updating note");
		return noteCentralProxy.updateNote(noteId, note);
	}

	@DeleteMapping(value = "/{id}")
	public String deleteNoteById(@PathVariable("id") @NotNull(message = "note id is compulsory") Long noteId) {
		LOGGER.info("Getting note identified by id : " + noteId);
		return noteCentralProxy.deleteNoteById(noteId);
	}
}
