package Kodlama.io.Devs.kodlamaIoDevs.business.rules;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.kodlamaIoDevs.core.utilities.exceptions.BusinessException;
import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyBusinessRules {
	private TechnologyRepository technologyRepository;
	
	public void checkIfTechnologyNameExists(String name) {
		if(this.technologyRepository.existsByName(name)) {
			throw new BusinessException("Technology already exists");
		}
	}
}
