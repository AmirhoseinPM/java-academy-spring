package train.pooyan.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ValidationException;
import train.pooyan.model.Person;
import train.pooyan.model.Wallet;
import train.pooyan.services.PersonService;
import train.pooyan.validation.PersonValidator;

@RestController
@RequestMapping("/person")
public class PersonController {


	@Autowired
	PersonService personService;
	
	@Autowired
	PersonValidator personValidator;

	@GetMapping(value = "/",
			produces = "application/json")
	public List<Person> getAllPersons() {
		return personService.getAll();
	}
	

	@PostMapping(value = "/", 
			consumes = "application/json", 
			produces = "application/json"
			)
	public ResponseEntity<Object> createUpdate(
			@Valid @RequestBody Person person, BindingResult result) {
		personValidator.validate(person, result);
		
		if (!result.hasErrors()) 
			return ResponseEntity.ok(personService.createUpdate(person));
		else {
			List<String> errors = result.getAllErrors().stream()
				.map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());		
			errors.forEach(System.out::println);
			return ResponseEntity.ok(new ErrorResponse("404", "validation faild", errors));
		}
	}
	
	
	@GetMapping("/{id}")
	public Person getPerson(
			@PathVariable Long id) {
		return personService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(
			@PathVariable Long id) {
		personService.deleteById(id);
	}
	
	
}
