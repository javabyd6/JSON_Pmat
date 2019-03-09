package com.sda.savejson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pmatusiak
 */
public class Main {

    static ObjectMapper mapper = new ObjectMapper();

    public static void savePersons(){
        Person person1 = new Person("Paweł", "Matusiak", 28);

        try {
            //Zapisujemy instancję person1 jako JSON
            mapper.writeValue(new File("person.json"), person1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createPersonsList(){
        Person person1 = new Person("Paweł", "Matusiak", 28);
        Person person2 = new Person("Remi", "Jakiśtam", 25);
        Person person3 = new Person("BCD", "C", 10);
        Person person4 = new Person("ABC", "B", 20);

        //tworzymy listę Person
        List<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        try {
            mapper.writeValue(new File("personList.json"), personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createStudentList(){
        List<Student> studentList = new ArrayList<Student>();
        Student student1 = new Student("A", "Z", new Address("Bydgoszcz", "Gdańska"));
        Student student2 = new Student("B", "Z", new Address("Bydgoszcz", "Długa"));
        Student student3 = new Student("C", "Z", new Address("Bydgoszcz", "Dworcowa"));
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        try {
            //zapisujemy listę do JSONa
            mapper.writeValue(new File("studentList.json"), studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        savePersons();
        createPersonsList();
        createStudentList();
    }
}
