package ru.youlola.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.youlola.spring.models.Person;
import ru.youlola.spring.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;
@Autowired
    public PersonValidator(PeopleService peopleService){
    this.peopleService = peopleService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if(peopleService.getPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName","","Это Фио занято");
    }
}
