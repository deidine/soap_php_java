package com.example.service;

import java.util.List;

import com.example.dao.PersonneDao;
import com.example.model.Personne;
 
public class PersoneServiceImp implements PersonService {
    PersonneDao pdo = new PersonneDao();

    @Override
    public void addPerson(String nom, int nni) {

        pdo.save(nom,nni);
    }

    @Override
    public Personne getPerson(int var1) {
        return pdo.getById(var1);
    }

    @Override
    public List<Personne> getAllPersons() {
        return pdo.getAll();
    }

    @Override
    public void updatePerson(Personne var1) {
        pdo.update(var1, null);
    }

    @Override
    public void deletePerson(int var1) {
        pdo.delete(var1);
    }

}
