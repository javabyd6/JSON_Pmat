package com.sda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pmatusiak
 */
public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Paweł", "Matusiak", 28);
        Person person2 = new Person("Remi", "Jakiśtam", 25);
        Person person3 = new Person("B", "C", 10);
        Person person4 = new Person("A", "B", 20);
        //tworzymy obiekt klasy ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //Zapisujemy instancję person1 jako JSON
        try {
//            String personStr = mapper.writeValueAsString(person1);
//            System.out.println(personStr);
//            Files.write(Paths.get("person.json"), personStr.getBytes());
            mapper.writeValue(new File("person.json"), person1);
            //odczytujemy
            Person personRead = mapper.readValue(new File("person.json"), Person.class);        //musieliśmy stworzyć pusty konstruktor w klasie Person
            System.out.println(personRead.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tworzymy listę Person
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        try {
            //zapisujemy listę do JSONa
            mapper.writeValue(new File("personList.json"), personList);
            //odczytujemy z JSONa
            Person[] personArray = mapper.readValue(new File("personList.json"), Person[].class);
            List<Person> personReadList = Arrays.asList(personArray);
            System.out.println(personReadList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("A", "Z", new Address("Bydgoszcz", "Gdańska"));
        Student student2 = new Student("B", "Z", new Address("Bydgoszcz", "Długa"));
        Student student3 = new Student("C", "Z", new Address("Bydgoszcz", "Dworcowa"));
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        try {
            //zapisujemy listę do JSONa
            mapper.writeValue(new File("studentList.json"), studentList);
            //odczytujemy z JSONa
            Student[] studentArray = mapper.readValue(new File("studentList.json"), Student[].class);
            List<Student> studentReadList = Arrays.asList(studentArray);
            System.out.println(studentReadList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
