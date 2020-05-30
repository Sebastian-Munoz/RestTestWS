/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.testws.services;

import co.edu.unipiloto.testws.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author usuario
 */

@Path("service")
public class Service {
 
    private static Map<Integer,Person> persons = new HashMap<Integer, Person>();
    
    static{
        for(int i = 0; i<10 ; i++){
            Person person = new Person();
            int id = i+1;
            person.setId(id);
            person.setFullName("My Wonderfull Person " + id);
            person.setAge(new Random().nextInt(40)+1);
            person.setSalario((person.getAge()*980000)/3);
            persons.put(id, person);
        } 
    }
    
    
    
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsInXML/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("/getAllPersonsInJson/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson(){
        return new ArrayList<Person>(persons.values());
    }
    
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person){
        persons.put(new Integer(person.getId()), person);
        return person;
    }
   
    
    
    @GET
    @Path("/getSalarioPromedio/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalarioPromedio(){
        
        int x2= 0;
        for(int i = 1; i <= persons.size() ; i++ ){
            int x = persons.get(i).getSalario();
            x2 = x2 + x;    
        }
        String x3 = (x2/persons.size())+"";
        return x3;
    }
    
    @GET
    @Path("/getSumaSalarios/")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumaSalario(){
        
        int x2= 0;
        for(int i = 1; i <= persons.size() ; i++ ){
            int x = persons.get(i).getSalario();
            x2 = x2 + x;
            
        }
        String x3 = x2+"";
        return x3;
    }
    
    
}
