package Kodlama.io.Devs.kodlamaIoDevs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {
	private LanguageRepository languageRepository;
	
	public void checkIfLanguageNameExists(String name) {
		if(this.languageRepository.existsByName(name)) {
			throw new BusinessException("Language already exists");
		}
	}
}