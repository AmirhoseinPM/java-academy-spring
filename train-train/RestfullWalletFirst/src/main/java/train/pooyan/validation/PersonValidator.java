package train.pooyan.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import train.pooyan.model.Person;

@Component
public class PersonValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Person.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Person person = (Person) target;	
		
        if ((person.getGender() != null) &&
        	(person.getGender().equals("MALE")) && 
        	person.getMilitaryStatus() == null) {
        	errors.reject("militaryStatus", "militaryStatus is required for MALEs");
        }
		
	}
	
}
