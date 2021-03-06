package com.example.demo.object;

public class Person {
    private String name;
    private String age;
    private String location;
    public Person(String name, String age, String location) {
        super();
        this.name = name;
        this.age = age;
        this.location = location;
    }
    public Person()
    {
        super();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
