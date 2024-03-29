package Kodlama.io.Devs.kodlamaIoDevs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.business.abstracts.LanguageService;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.CreateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.requests.language.UpdateLanguageRequest;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.language.GetAllLanguagesResponse;
import Kodlama.io.Devs.kodlamaIoDevs.business.responses.language.GetByIdLanguageResponse;
import Kodlama.io.Devs.kodlamaIoDevs.business.rules.LanguageBusinessRules;
import Kodlama.io.Devs.kodlamaIoDevs.core.utilities.mappers.ModelMapperService;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {
	
	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	private LanguageBusinessRules languageBusinessRules;
	
	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
//		List<GetAllLanguagesResponse> languageResponse = new ArrayList<GetAllLanguagesResponse>();
//		
//		for (Language language : languages) {
//			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
//			responseItem.setId(language.getId());
//			responseItem.setName(language.getName());
//			responseItem.setTechnologies(language.getTechnologies());
//			
//			languageResponse.add(responseItem);
//		}
		
		List<GetAllLanguagesResponse> languageResponse = languages.stream()
				.map(language -> this.modelMapperService.forResponse()
						.map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
		
		return languageResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		
		Language language = this.languageRepository.findById(id).orElseThrow();
		
		GetByIdLanguageResponse response = this.modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
		return response;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		
		this.languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
		
		Language addedLanguage = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
		
		this.languageRepository.save(addedLanguage);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateRequest) {
		Language updatedLanguage = this.modelMapperService.forRequest().map(updateRequest, Language.class);
		
		this.languageRepository.save(updatedLanguage);
		
		
	}

	@Override
	public void delete(int id) {
		this.languageRepository.deleteById(id);
		
	}


}
