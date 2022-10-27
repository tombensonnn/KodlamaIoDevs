package Kodlama.io.Devs.kodlamaIoDevs.webApi.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getbyid")
	public Language getById(@RequestParam int id) {
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(Language language) throws Exception {
		languageService.add(language);
	}
	
	@PutMapping("/update")
	public void update(@RequestParam int id , @RequestBody Language language) {
		languageService.update(id, language);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam int id) {
		languageService.delete(id);
	}
	
	
	
	
}
