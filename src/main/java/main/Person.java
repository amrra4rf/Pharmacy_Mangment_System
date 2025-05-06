package main;

public abstract class Person 
{
    String name ;
    int age;
    String password;
    Pharmacy p;
    abstract void display_self();
    Person(String name ,int age,String password)
    {
        this.name=name;
        this.age=age;
        this.password=password;
        p=Pharmacy.getInstance();
    }
}
