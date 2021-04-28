package fr.asterox.Mediscreen.proxy;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.asterox.Mediscreen.dto.PatientDTO;

@FeignClient(name = "PatientManagement", url = "localhost:8081")
public interface PatientProxy {

	@GetMapping(value = "/patient/get")
	public Optional<PatientDTO> getPatientById(
			@RequestParam @NotNull(message = "patientId is compulsory") Long patientId);

}
