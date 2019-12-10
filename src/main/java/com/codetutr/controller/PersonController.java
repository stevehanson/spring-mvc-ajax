package com.codetutr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codetutr.domain.Person;
import com.codetutr.service.PersonService;

@Controller
@RequestMapping("api")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("person/random")
    @ResponseBody
    public String randomPerson() {
        Person person = personService.getRandom();
        System.out.println("RANDOM PERSON " + person.toString());
        return person.getName() + ", age = " + person.getAge();
    }

    @RequestMapping("person/{id}")
    @ResponseBody
    public String getById(@PathVariable Long id) {
        Person person = personService.getById(id);
        System.out.println("ID PERSON " + person.toString());
        return person.getName() + ", age = "  + person.getAge();
    }

    /* same as above method, but is mapped to
     * /api/person?id= rather than /api/person/{id}
     */
    @RequestMapping(value = "person", params = "id")
    @ResponseBody
    public String getByIdFromParam(@RequestParam("id") Long id) {
        Person person = personService.getById(id);
        System.out.println("GET PERSON BY ID " + person.toString());
        return person.getName() + ", age = "  + person.getAge();
    }

    /**
     * Saves new person. Spring automatically binds the name
     * and age parameters in the request to the person argument
     *
     * @param person
     * @return String indicating success or failure of save
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public String savePerson(Person person) {
        System.out.println("SAVE PERSON");
        personService.save(person);
        return "Saved person: " + person.getName() + ", age = "  + person.getAge();
    }
}
