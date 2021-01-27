package com.company.student;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String surname;
    private double dateOfBirth;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(int id, String lastName, String firstName, String surname, double dateOfBirth,
                   String address, String phone, String faculty, int course,
                   String group){
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId(){
        return id;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSurname(){
        return surname;
    }
    public double getDateOfBirth(){
        return dateOfBirth;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public String getFaculty(){
        return faculty;
    }
    public int getCourse(){
        return course;
    }
    public String getGroup(){
        return group;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setDateOfBirth(double dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    public void setCourse(int course){
        this.course = course;
    }
    public void setGroup(String group){
        this.group = group;
    }

    @Override
    public String toString(){
        return "Student{" +
                " id = " + id +
                "; lastName = " + lastName +
                "; firstName = " + firstName +
                "; surname = " + surname +
                "; dateOfBirth = " + dateOfBirth +
                "; address = " + address +
                "; phone = " + phone +
                "; faculty = " + faculty +
                "; course = " + course +
                "; group = " + group + "}";
    }
}
