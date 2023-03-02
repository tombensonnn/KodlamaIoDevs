package Kodlama.io.Devs.kodlamaIoDevs.webApi.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.CreateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology.UpdateTechnologyRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.technology.GetAllTechnologiesResponse;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.technology.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/technologies")
public class TechnologyController {
	private TechnologyService technologyService;
	
	
	@GetMapping()
	public List<GetAllTechnologiesResponse> getAll() throws Exception {
		return this.technologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdTechnologyResponse getById(@PathVariable int id) {
		return this.technologyService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	
	@PutMapping
	public void update(@RequestBody @Valid() UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		technologyService.delete(id);
	}
	
	
}
