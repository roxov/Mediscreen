package fr.asterox.Mediscreen.proxy;

import javax.validation.constraints.NotNull;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ReportGenerator", url = "localhost:8083")
public interface ReportGeneratorProxy {
	@GetMapping(value = "rest/assess/{id}")
	public String getPatientAssessment(
			@PathVariable("id") @NotNull(message = "patientId is compulsory") Long patientId);

	@GetMapping("/assess/{id}")
	public String getPatientReport(@PathVariable("id") Long patientId);
}
