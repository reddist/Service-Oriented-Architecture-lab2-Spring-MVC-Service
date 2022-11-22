package lab.reddist.lab2springmvc.controller;

import lab.reddist.lab2springmvc.controller.exception.InvalidIdException;
import lab.reddist.lab2springmvc.controller.exception.PersonNotFoundException;
import lab.reddist.lab2springmvc.dto.response.HttpOkMessage;
import lab.reddist.lab2springmvc.entity.Person;
import lab.reddist.lab2springmvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id_string}")
    public Person getPersonById(@PathVariable String id_string) throws RuntimeException {
        try {
            int id = Integer.parseInt(id_string);
            Optional<Person> person = personService.getPersonById(id);
            if (person.isPresent()) {
                System.out.println(person.get());
                return person.get();
            } else {
                throw new PersonNotFoundException();
            }
        } catch (NumberFormatException nfe) {
            throw new InvalidIdException();
        }
    }

    @DeleteMapping("/{id_string}")
    public HttpOkMessage deletePersonById(@PathVariable String id_string) throws RuntimeException {
        try {
            int id = Integer.parseInt(id_string);
            personService.deletePersonById(id);
            return new HttpOkMessage("Success");
        } catch (NumberFormatException nfe) {
            throw new InvalidIdException();
        }
    }

    @GetMapping("/new")
    public Person newPerson() {
        return personService.newPersonMock();
    }

}
