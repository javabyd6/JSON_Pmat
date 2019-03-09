package com.sda.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author pmatusiak
 */
public class Main {

    static ObjectMapper mapper = new ObjectMapper();

    public static void readPerson(){
        try {

            Person personRead = mapper.readValue(new File("person.json"), Person.class);        //musieliśmy stworzyć pusty konstruktor w klasie Person
            System.out.println(personRead.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPersonList(){
        try {
            Person[] personArray = mapper.readValue(new File("personList.json"), Person[].class);
            List<Person> personReadList = Arrays.asList(personArray);
            System.out.println(personReadList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStudentList(){
        try {
            Student[] studentArray = mapper.readValue(new File("studentList.json"), Student[].class);
            List<Student> studentReadList = Arrays.asList(studentArray);
            System.out.println(studentReadList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readPerson();
        readPersonList();
        readStudentList();
    }
}
