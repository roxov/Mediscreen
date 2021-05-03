package fr.asterox.Mediscreen.restcontroller;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.Mediscreen.dto.PatientDTO;
import fr.asterox.Mediscreen.proxy.PatientProxy;

@RestController
@RequestMapping("rest/patient")
public class PatientRestController {
	@Autowired
	PatientProxy patientProxy;

	private static final Logger LOGGER = LogManager.getLogger(PatientRestController.class);

	@PostMapping(value = "/rest/patient")
	public PatientDTO addPatient(@RequestBody PatientDTO patient) {
		LOGGER.info("Adding new user");
		return patientProxy.addPatient(patient);
	}

	@GetMapping(value = "/rest/patient/{id}")
	public PatientDTO getPatientById(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Getting patient identified by id");
		return patientProxy.getPatientById(patientId);
	}

	@PutMapping(value = "/rest/patient/{id}")
	public PatientDTO updatePatient(@RequestBody PatientDTO patient) {
		LOGGER.info("Updating patient");
		return patientProxy.updatePatient(patient);
	}
}
