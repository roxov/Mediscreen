package fr.asterox.Mediscreen.proxy;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.asterox.Mediscreen.dto.NoteDTO;

@FeignClient(name = "NotesCentral", url = "localhost:8082")
public interface NotesCentralProxy {

	@PostMapping(value = "/rest/note")
	public NoteDTO addNote(@RequestBody NoteDTO note);

	@GetMapping(value = "/rest/note/{id}")
	public NoteDTO getNoteById(@PathVariable("id") @NotNull(message = "note id is compulsory") Long noteId);

	@GetMapping(value = "rest/note/list/patient/{id}")
	public List<NoteDTO> getAllPatientNotes(
			@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId);

	@PutMapping(value = "rest/note/{id}")
	public NoteDTO updateNote(@PathVariable("id") @NotNull(message = "noteId is compulsory") Long noteId,
			@RequestBody NoteDTO note);

	@DeleteMapping(value = "rest/note/{id}")
	public String deleteNoteById(@PathVariable("id") @NotNull(message = "note id is compulsory") Long noteId);

	@RequestMapping("/note/list/patient/{id}")
	public String home(@PathVariable("id") @NotNull(message = "noteId is compulsory") Long patientId);

	@GetMapping("/note/add")
	public String addNewNote(NoteDTO note);

	@PostMapping("/note/validate")
	public ResponseEntity<Void> validate(@Valid NoteDTO note);

	@GetMapping("/note/get/{id}")
	public String getNote(@PathVariable("id") Long noteId);

	@GetMapping("/note/update/{id}")
	public String showUpdateForm(@PathVariable("id") @NotNull(message = "noteId is compulsory") Long noteId);

	@PostMapping("/note/update/{id}")
	public ResponseEntity<Void> updateSelectedNote(@PathVariable("id") Long noteId, @Valid NoteDTO note);

	@GetMapping("/note/delete/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable("id") Long noteId);
}
