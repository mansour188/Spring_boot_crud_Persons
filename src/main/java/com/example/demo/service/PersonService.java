package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
     private final PersonDao personDao;
     @Autowired

    public PersonService(@Qualifier("postgres")  PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson( Person person){
        return personDao.insertPerson(person);

    }
    public List<Person> getPerson(){
         return personDao.getPerson();
    }

   public Optional<Person> getPersonById(UUID id){
         return this.personDao.selectPersonById(id);
   }

   public int delatePerson(UUID id ){
         return personDao.delatePersoneById(id);
   }
   public int updatePerson(UUID id , Person newPerson){
         return personDao.updatePersonById(id,newPerson);
   }

}
