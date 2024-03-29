package com.project.javaeecrud.model;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String position;

    public User(int id, String firstName, String lastName, int age, String email, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.position=position;
    }

    public User(String firstName, String lastName, int age, String email, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.position=position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return
                "id " + id +
                ", firstName " + firstName +
                ", lastName " + lastName +
                ", age " + age +
                ", email " + email +
                ", position " + position
                ;
    }

}
