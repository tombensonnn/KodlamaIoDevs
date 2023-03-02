package Kodlama.io.Devs.kodlamaIoDevs.business.requests.technology;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateTechnologyRequest {
	@NotNull
	@Size(min = 2, max = 20, message = "Name size must be between 2 and 20")
	private String name;
	@NotNull
	private int languageId;
}
