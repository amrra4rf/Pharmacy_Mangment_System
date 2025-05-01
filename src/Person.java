public abstract class Person 
{
    String name ;
    int age;
    Pharmacy p;
    abstract void display_self();
    Person(String name ,int age)
    {
        this.name=name;
        this.age=age;
    }
}
