package Kodlama.io.Devs.kodlamaIoDevs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.kodlamaIoDevs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
	
	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
	}
	
	
	public InMemoryLanguageRepository(List<Language> languages) {
		this.languages = languages;
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		
		return null;
		
	}

	@Override
	public void add(Language language) {
		languages.add(language);
		
	}

	@Override
	public void update(int id, Language language) {
		
		for (Language lang : languages) {
			if(lang.getId() == id) {
				lang.setName(language.getName());
			}
		}
		
	}

	@Override
	public void delete(int id) {
		languages.remove(id);
		
	}

}
