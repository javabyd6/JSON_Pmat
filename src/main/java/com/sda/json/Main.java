package com.sda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

        List<Person> list = new ArrayList<>();


        ObjectMapper mapper = new ObjectMapper();
        try {
            String personStr = mapper.writeValueAsString(person1);
            System.out.println(personStr);
            //do pliku person.json zapisac wynikowego stringa
            Files.write(Paths.get("person.json"), personStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        try {
            String personLst = mapper.writeValueAsString(list);
            Files.write(Paths.get("personList.json"), personLst.getBytes());
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
            String studentLst = mapper.writeValueAsString(studentList);
            Files.write(Paths.get("studentList.json"), studentLst.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
