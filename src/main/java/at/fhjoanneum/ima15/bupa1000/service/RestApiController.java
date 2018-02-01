package at.fhjoanneum.ima15.bupa1000.service;

import at.fhjoanneum.ima15.bupa1000.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    BiomarkerRepository biomarkerRepository;

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

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value = "/updateValue", method = RequestMethod.PUT)
    void updateValue(/*@RequestParam(value = "value") Long valueId, @RequestParam(value = "state") Long stateId, @RequestParam(value = "biomarker") Long biomarkerId,
                     @RequestParam(value = "person") Long personId, @RequestParam(value = "mr") Long mrId, @RequestParam(value = "source") Long sourceId*/ @RequestBody Value value) {

        /*Value value = valueRepository.findOne(valueId);
        value.setState(stateRepository.findOne(stateId));
        value.setSource(sourceRepository.findOne(sourceId));
        value.setMr(mrRepository.findOne(mrId));
        value.setBiomarker(biomarkerRepository.findOne(biomarkerId));
        value.setPerson(personRepository.findOne(personId));*/

        commentRepository.save(value.getComment());
        valueRepository.save(value);


    }

    @RequestMapping(value = "/createValue", method = RequestMethod.POST)
    void createValue(@RequestBody Value value) {


        commentRepository.save(value.getComment());
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

    /*@RequestMapping(value = "/createBiomarker", method = RequestMethod.POST)
    public void createBiomarker(@RequestParam(value = "name") String name, @RequestParam(value = "biomarker") String biomarker, @RequestParam(value = "description") String description, @RequestParam(value = "category") Long categoryId) {
        Biomarker biomarker1 = new Biomarker(name, biomarker, description, categoryRepository.findOne(categoryId));
        biomarkerRepository.save(biomarker1);
    }*/

    @RequestMapping(value = "/updateBiomarker", method = RequestMethod.PUT)
    public ResponseEntity<Biomarker> updateBiomarker(UriComponentsBuilder ucBuilder, @RequestParam(value = "id") Long biomarkerId, @RequestParam(value = "name") String name, @RequestParam(value = "biomarker") String biomarker, @RequestParam(value = "description") String description, @RequestParam(value = "category") Long categoryId) {
        Biomarker biomarker1 = biomarkerRepository.findOne(biomarkerId);
        /*if (description == "null" || description == "undefined")
        {biomarker1.setDescription(null);}
        else
        {biomarker1.setDescription(description);}
        biomarker1.setName(name);
        biomarker1.setBiomarker(biomarker);
        biomarkerRepository.save(biomarker1);*/
        biomarker1.setCategory(categoryRepository.findOne(categoryId));
        biomarkerRepository.save(biomarker1);

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(ucBuilder.path("/biomarkers/{id}").buildAndExpand(biomarker1.getId()).toUri());
        return new ResponseEntity<Biomarker>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/createBiomarker", method = RequestMethod.POST)
    // ----------------------------------------------------------------------------
    public ResponseEntity<Biomarker> createBiomarker(@RequestBody Biomarker biomarker, UriComponentsBuilder ucBuilder, @RequestParam(value = "category") Long categoryId) {
        biomarker.setCategory(categoryRepository.findOne(categoryId));
        biomarkerRepository.save(biomarker);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/biomarkers/{id}").buildAndExpand(biomarker.getId()).toUri());
        return new ResponseEntity<Biomarker>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/createPerson", method = RequestMethod.POST)
    // ----------------------------------------------------------------------------
    public ResponseEntity<Person> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder, @RequestParam(value = "type") Long typeId) {
        person.setType(typeRepository.findOne(typeId));
        personRepository.save(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/persons/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Person>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updatePerson", method = RequestMethod.PUT)
    // ----------------------------------------------------------------------------
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, UriComponentsBuilder ucBuilder, @RequestParam(value = "type") Long typeId) {
        personRepository.save(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/persons/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Person>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/createValueFlow", method = RequestMethod.POST)
    void createValueFlow(@RequestParam(value = "value") BigDecimal valueValue, @RequestParam(value = "state") Long stateId, @RequestParam(value = "biomarker") Long biomarkerId,
                         @RequestParam(value = "prefix") String prefix, @RequestParam(value = "suffix") String suffix, @RequestParam(value = "mr") Long mrId, @RequestParam(value = "source") Long sourceId) {

        Value value = new Value();
        value.setValue(valueValue);
        value.setState(stateRepository.findOne(stateId));
        value.setSource(sourceRepository.findOne(sourceId));
        value.setMr(mrRepository.findOne(mrId));
        value.setBiomarker(biomarkerRepository.findOne(biomarkerId));
        value.setPerson(personRepository.findByPrefixAndSuffix(prefix, suffix));
        valueRepository.save(value);


    }

    @RequestMapping(value = "/createValueFlow2", method = RequestMethod.POST)
    void createValueFlow(@RequestBody Value value, @Param("prefix") String prefix, @Param("suffix") String suffix) {

        value.setPerson(personRepository.findByPrefixAndSuffix(prefix, suffix));

        if(value.getComment() == null)
        {
            commentRepository.save(new Comment());
        }
        else
        {
            commentRepository.save(value.getComment());

        }
        valueRepository.save(value);


    }


}
