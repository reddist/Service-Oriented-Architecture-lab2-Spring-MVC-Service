package lab.reddist.lab2springmvc.service;

import lab.reddist.lab2springmvc.controller.exception.PersonNotFoundException;
import lab.reddist.lab2springmvc.entity.*;
import lab.reddist.lab2springmvc.repository.CoordinatesRepository;
import lab.reddist.lab2springmvc.repository.LocationRepository;
import lab.reddist.lab2springmvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final CoordinatesRepository coordinatesRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public PersonService (
        PersonRepository personRepository,
        CoordinatesRepository coordinatesRepository,
        LocationRepository locationRepository
    ) {
        this.personRepository = personRepository;
        this.coordinatesRepository = coordinatesRepository;
        this.locationRepository = locationRepository;
    }

    public Person newPersonMock () {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(1L);
        coordinates.setY(2L);

        Location location = new Location();
        location.setX(1L);
        location.setY(2);
        location.setZ(3);

        Person person = new Person();
        person.setName("Rafael Nadal");
        person.setCoordinates(coordinatesRepository.save(coordinates));
        person.setHeight(180.0);
        person.setEyeColor(Color.BLUE);
        person.setNationality(Country.THAILAND);
        person.setPassportID("4093202034");
        person.setLocation(locationRepository.save(location));
        person.setCreationDate(ZonedDateTime.now());

        return personRepository.save(person);
    }

    public Optional<Person> getPersonById (Integer id) {
        return personRepository.findById(id);
    }

    public void deletePersonById (Integer id) throws PersonNotFoundException {
        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException();
        }
        personRepository.deleteById(id);
    }
}