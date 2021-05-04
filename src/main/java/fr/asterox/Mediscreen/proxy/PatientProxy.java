package fr.asterox.Mediscreen.proxy;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.asterox.Mediscreen.dto.PatientDTO;

@FeignClient(name = "PatientManagement", url = "localhost:8081")
public interface PatientProxy {

	@PostMapping(value = "/rest/patient")
	public PatientDTO addPatient(@RequestBody PatientDTO patient);

	@GetMapping(value = "/rest/patient/{id}")
	public PatientDTO getPatientById(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId);

	@PutMapping(value = "/rest/patient/{id}")
	public PatientDTO updatePatient(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId,
			@RequestBody PatientDTO patient);

	@RequestMapping("/patient/list")
	public String home();

	@GetMapping("/patient/add")
	public String addNewPatient(PatientDTO patient);

	@PostMapping("/patient/validate")
	public String validate(PatientDTO patient);

	@GetMapping("/patient/get/{id}")
	public String getPatient(@PathVariable("id") Long patientId);

	@GetMapping("/patient/update/{id}")
	public String showUpdateForm(@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId);

	@PostMapping("/patient/update/{id}")
	public String updateSelectedPatient(@PathVariable("id") Long patientId, @Valid PatientDTO patient);

	@GetMapping("/patient/delete/{id}")
	public String deletePatient(@PathVariable("id") Long patientId);
}
