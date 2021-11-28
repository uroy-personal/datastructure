package practice.streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    private String gender;
    private List<Person> siblings;

    public Person(String name, int age, String gender, List<Person> siblings) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.siblings = siblings;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getSiblings() {
        return siblings;
    }
    /*
     * Given a list of Persons, give me the names of everyone who is older than 18.
     */
    private void forLoop(List<Person> persons) {
        List<String> result = new ArrayList<String>();
        for(Person p : persons){
            if(p.getAge() > 18){
                result.add(p.getName());
            }
        }
    }
    private void streaming(List<Person> persons) {
        List<String> result = persons.stream()
                .filter(p -> p.getAge() > 18)
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }
    
    /*
     * Given a list of Persons, give me the names of everyone who is between 19 and 65 
     * whose name is not null 
     * and starts with a 'B'
     */
    private void forLoop2(List<Person> persons) {
        List<String> result = new ArrayList<String>();
        for(Person p : persons){
            if(p.getAge() > 18 && p.getAge()<65 && p.getName()!=null && p.getName().startsWith("B")){
                result.add(p.getName());
            }
        }
    }
    private void streaming2(List<Person> persons) {
    List<String> result = persons.stream()
            .filter(p -> p.getAge() > 18)
            .filter(p -> p.getAge() < 65)
            .filter(p -> p.getName().startsWith("B"))
            .map(p -> p.getName())
            .collect(Collectors.toList());
    }
}