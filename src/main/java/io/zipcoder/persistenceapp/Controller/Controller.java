package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.DTO.Person;
import io.zipcoder.persistenceapp.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PersonService personService;


@PostMapping("/people")
    public Boolean addPerson(@RequestBody Person person){
        return personService.insert(person);

    }


}
