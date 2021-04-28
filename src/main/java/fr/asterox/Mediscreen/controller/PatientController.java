package fr.asterox.Mediscreen.controller;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.asterox.Mediscreen.dto.PatientDTO;
import fr.asterox.Mediscreen.proxy.PatientProxy;

@RestController
@RequestMapping("patient")
public class PatientController {
	@Autowired
	PatientProxy patientProxy;

	private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

	@GetMapping(value = "/get")
	public Optional<PatientDTO> getPatientById(
			@RequestParam @NotNull(message = "patientId is compulsory") Long patientId) {
		LOGGER.info("Getting patient identified by id");
		return patientProxy.getPatientById(patientId);
	}
}
