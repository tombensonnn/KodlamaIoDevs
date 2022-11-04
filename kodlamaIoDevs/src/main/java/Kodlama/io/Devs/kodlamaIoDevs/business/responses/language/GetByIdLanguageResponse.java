package Kodlama.io.Devs.kodlamaIoDevs.business.responses.language;

import java.util.Set;

import Kodlama.io.Devs.kodlamaIoDevs.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageResponse {
	private int id;
	private String name;
	private Set<Technology> technologies;
}
