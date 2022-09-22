package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private  PersonService personService ;






    @PostMapping

    public void addPerson( @Valid @NotNull  @RequestBody Person person){
        this.personService.addPerson(person);

    }
    @GetMapping
    public List<Person> getPerson(){
        return personService.getPerson();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id")  UUID id ){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void  delateById(@RequestBody @PathVariable("id") UUID id){
        personService.delatePerson(id);
    }
    @PutMapping(path="{id}")
    public void updatePersone( @PathVariable("id") UUID id,@NotNull @Valid @RequestBody Person personUpdate){
        personService.updatePerson(id,personUpdate);

    }
}
