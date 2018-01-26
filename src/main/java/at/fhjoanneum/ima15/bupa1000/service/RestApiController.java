package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Map;


@ResponseBody
@RestController
public class RestApiController {

    @Autowired
    ValueRepository valueRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    MRRepository mrRepository;

    @Autowired
    DimensionRepository dimensionRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Person_PersonRepository person_personRepository;

    @Autowired
    BreastfeedingRepository breastfeedingRepository;

    @Autowired
    UzerRepository uzerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/updateValue", method = RequestMethod.PUT)
    void updateValue(@RequestParam(value = "value") Long valueId, @RequestParam(value = "state") Long stateId, @RequestParam(value = "dimension") Long dimensionId,
                     @RequestParam(value = "person") Long personId, @RequestParam(value = "mr") Long mrId, @RequestParam(value = "source") Long sourceId) {

        Value value = valueRepository.findOne(valueId);
        value.setState(stateRepository.findOne(stateId));
        value.setSource(sourceRepository.findOne(sourceId));
        value.setMr(mrRepository.findOne(mrId));
        value.setDimension(dimensionRepository.findOne(dimensionId));
        value.setPerson(personRepository.findOne(personId));
        valueRepository.save(value);


    }

    @RequestMapping(value = "/createValue", method = RequestMethod.POST)
    void createValue(@RequestParam(value = "value") BigDecimal valueValue, @RequestParam(value = "state") Long stateId, @RequestParam(value = "dimension") Long dimensionId,
                     @RequestParam(value = "person") Long personId, @RequestParam(value = "mr") Long mrId, @RequestParam(value = "source") Long sourceId) {

        Value value = new Value();
        value.setValue(valueValue);
        value.setState(stateRepository.findOne(stateId));
        value.setSource(sourceRepository.findOne(sourceId));
        value.setMr(mrRepository.findOne(mrId));
        value.setDimension(dimensionRepository.findOne(dimensionId));
        value.setPerson(personRepository.findOne(personId));
        valueRepository.save(value);


    }

    @RequestMapping(value = "/updatePerson_Person", method = RequestMethod.PUT)
    void updatePerson_Person(@RequestParam(value = "person_person") Long person_personId, @RequestParam(value = "baby") Long babyId, @RequestParam(value = "mother") Long motherId,
                             @RequestParam(value = "breastfeeding") Long breastfeedingId) {

        Person_Person person_person = person_personRepository.findOne(person_personId);
        person_person.setMother(personRepository.findOne(motherId));

        person_person.setBaby(personRepository.findOne(babyId));
        person_person.setBreastfeeding(breastfeedingRepository.findOne(breastfeedingId));
        person_personRepository.save(person_person);


    }

    @RequestMapping(value = "/createPerson_Person", method = RequestMethod.POST)
    void createPerson_Person(@RequestParam(value = "baby") Long babyId, @RequestParam(value = "mother") Long motherId,
                             @RequestParam(value = "breastfeeding") Long breastfeedingId) {

        Person_Person person_person2 = new Person_Person(breastfeedingRepository.findOne(breastfeedingId), personRepository.findOne(motherId), personRepository.findOne(babyId));
        person_personRepository.save(person_person2);


    }

    @RequestMapping(value = "/saveUzerWithRole", method = RequestMethod.POST)
    public void saveUzerWithRole(@RequestParam("username") String username, @RequestParam("password") String password) {
        Uzer uzer = new Uzer();
        uzer.setUsername(username);
        uzer.setPassword(password);
        uzerRepository.save(uzer);
        uzer.setRoles(roleRepository.findAll());
        uzerRepository.save(uzer);


    }

    @RequestMapping(value = "/createUzer", method = RequestMethod.POST)
    public void createUzer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        Uzer uzer = new Uzer(username, password, roleRepository.findAll());
        uzerRepository.save(uzer);
    }

    /*@RequestMapping(value = "/createDimension", method = RequestMethod.POST)
    public void createDimension(@RequestParam(value = "name") String name, @RequestParam(value = "dimension") String dimension, @RequestParam(value = "description") String description, @RequestParam(value = "category") Long categoryId) {
        Dimension dimension1 = new Dimension(name, dimension, description, categoryRepository.findOne(categoryId));
        dimensionRepository.save(dimension1);
    }*/

    @RequestMapping(value = "/updateDimension", method = RequestMethod.PUT)
    public ResponseEntity<Dimension> updateDimension(UriComponentsBuilder ucBuilder, @RequestParam(value = "id") Long dimensionId, @RequestParam(value = "name") String name, @RequestParam(value = "dimension") String dimension, @RequestParam(value = "description") String description, @RequestParam(value = "category") Long categoryId) {
        Dimension dimension1 = dimensionRepository.findOne(dimensionId);
        /*if (description == "null" || description == "undefined")
        {dimension1.setDescription(null);}
        else
        {dimension1.setDescription(description);}
        dimension1.setName(name);
        dimension1.setDimension(dimension);
        dimensionRepository.save(dimension1);*/
        dimension1.setCategory(categoryRepository.findOne(categoryId));
        dimensionRepository.save(dimension1);

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(ucBuilder.path("/dimensions/{id}").buildAndExpand(dimension1.getId()).toUri());
        return new ResponseEntity<Dimension>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/createDimension", method = RequestMethod.POST)
    // ----------------------------------------------------------------------------
    public ResponseEntity<Dimension> createDimension(@RequestBody Dimension dimension, UriComponentsBuilder ucBuilder, @RequestParam(value = "category") Long categoryId) {
        dimension.setCategory(categoryRepository.findOne(categoryId));
        dimensionRepository.save(dimension);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/dimensions/{id}").buildAndExpand(dimension.getId()).toUri());
        return new ResponseEntity<Dimension>(headers, HttpStatus.CREATED);
    }


}
