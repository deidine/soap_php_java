package com.example.service;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import com.example.model.Personne;

@WebService
public interface PersonService {
 

   @WebMethod(operationName="ajouterPersonne")
   void addPerson(@WebParam(name = "nom")String nom,@WebParam(name = "nni") int nni);

   @WebMethod
   Personne getPerson(int var1);

   @WebMethod
   List<Personne> getAllPersons();

   @WebMethod
   void updatePerson(Personne var1);

   @WebMethod
   void deletePerson(int var1);
}

