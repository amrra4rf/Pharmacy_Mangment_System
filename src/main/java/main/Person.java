
package main;
import javafx.scene.control.TextArea;

public abstract class Person {
    private String name;
    private int age;
    static private TextArea l = new TextArea();
    static private TextArea m = new TextArea();

    Pharmacy p;//doesn't need to be private since there is only 1 pharmacy and it can get acessed easily form the pharamacy class
    
    abstract void display_self();
    abstract boolean check_pass(String password);
    Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
        p = Pharmacy.getInstance();
    }

    public static  TextArea get_TextArea()
    {
        return l;
    }
    public static TextArea getTextArea_m()
    {
        return m;
    }

    public String get_name ()
    {
        return name;
    }
     
    public int get_age()
    {
        return age;
    }


}
