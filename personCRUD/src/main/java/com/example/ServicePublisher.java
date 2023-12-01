package com.example;

import com.example.service.PersoneServiceImp;

import jakarta.xml.ws.Endpoint;

public class ServicePublisher {

    public static void main(String[] args) {
        System.setProperty("javax.xml.bind.JAXBContextFactory", "com.sun.xml.bind.v2.ContextFactory");
       
        String url = "http://localhost:8080/personService";
        Endpoint.publish(url, new PersoneServiceImp());

        System.out.println("Service web CRUD publié avec succès à l'adresse : " + url);
    }
}
