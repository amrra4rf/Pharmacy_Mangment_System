package main;
import java.time.LocalDate;
import java.util.Scanner;

public class Pharmacy 
{
    Scanner s=new Scanner(System.in);
    final static int length=1000; 
    public static int item_count_in_pharmacy=0;
    public static int persons_count_in_pharamcy=0;
    public static int orders_count_in_pharamcy=0;

    Person[]person=new Person[length*10];       // max number of persons to be added is 10000 
    Item[] items=new Item[length*10];           // max number of items to be added is 10000
    Order[] orders=new Order[length*100];       // max number of orders to be made at once is 100000


    // This is an implemnation to a Singleton pattern that makes the pharmacy only instatized once int the whole program
    private static Pharmacy p = new Pharmacy();
    private Pharmacy() {}     //making constructor private so no one can make an instance of the pharmacy except our pre made one
    public static Pharmacy getInstance() {
        return p;
    }



    public void  Dr_login(String id ,String pass) throws NullPointerException
    {
       
        for (int i=0;i<persons_count_in_pharamcy;i++)
        {
            if(person[i] instanceof Doctor)
            {
                Doctor d=(Doctor)person[i];
                if(d.password.equals(pass)&&d.id.equals(id))
                d.main_menu();
                
                
            }
        }
       
        System.out.println("The id or The password is incorrect  press 1 to try again and otherwise to go back to the menu");
        int decide =s.nextInt();
        if(decide==1)
        {
            System.out.println("Please enter the id and passwrod ");
            String temp_id=s.nextLine();
            String temp_pass=s.nextLine();
            Dr_login(temp_id, temp_pass);
        }
        else 
        //go back to pharmacy menu
        menu();

        
    }


    public void customer_login(String name ,String password)
    {
        
        for (int i=0;i<persons_count_in_pharamcy;i++)
        {
            if(person[i] instanceof Customer)
            {
                Customer customer=(Customer)person[i];
                if(customer.name.equals(name)&&customer.password.equals(password))
                customer.main_menu();

            }
        }
        System.out.println("The name  or The password is incorrect  press 1 to try again and otherwise to go back to the menu");
        int decide =s.nextInt();
        if(decide==1)
        {
            System.out.println("Please enter the name and passwrod ");
            String temp_name=s.nextLine();
            String temp_password=s.nextLine();
            customer_login(temp_name, temp_password);
        }
        else 
        //go back to pharmacy menu
        menu();
    }

    //this function shows the main menu
    public void menu()
    {
        System.out.println("                                            Hello To Our Pharmacy");

        System.out.println(" Choose The Action You want to make from below: ");

        

        System.out.println(" 1) Sign up As A doctor ");

        System.out.println(" 2) Sign in As A doctor ");

        System.out.println(" 3) Sign up As An Employee ");

        System.out.println(" 4) Sign in As An Employee ");

        System.out.println(" 5) Sign up As An Customer ");

        System.out.println(" 6) Sign in As An Customer ");

        System.out.println(" 7) Exit ");

        Boolean repeat=true;
        while (repeat) 
        {
            int x=s.nextInt();
            if(x>7||x<1)
            {
                System.out.println("Invalid Enter a number between 1-7");
            }
            else if(x==1)//sign up doctor 
            {
                System.out.println("please enter your name ,age ,salary and password");
                s.nextLine();  // consume the leftover newline
                String temp_name =s.nextLine();
                int temp_age =s.nextInt();
                s.nextLine();  // consume the leftover newline
                double temp_salary =s.nextDouble();
                s.nextLine();  // consume the leftover newline
                String temp_pass =s.nextLine();
                person[persons_count_in_pharamcy++]=new Doctor(temp_name, temp_age, temp_salary, temp_pass);//made an new Doctor 

                //to go for the main menu
                Doctor doc=(Doctor)person[persons_count_in_pharamcy-1];
                doc.main_menu();
            }
            else if(x==2)//sign in doctor 
            {
                s.nextLine();
                System.out.println("Hello Doctor Please enter Your id and password");
                String temp_id=s.nextLine();
                String temp_password=s.nextLine();
                Dr_login(temp_id,temp_password);
            }
            else if (x==3 )
            {
                //employee under construction
            }
            else if (x==4 )
            {
                //employee under construction
            }
            else if (x==5 )
            {
                System.out.println("Please enter name, age , gender , 1 if you have a prescription or 0 otherwise ,balance and finally password ");
                s.nextLine();  // consume the leftover newline


                String temp_name =s.nextLine();
                int temp_age =s.nextInt(); //Exception handling if non int

                s.nextLine();  // consume the leftover newline

                String g=s.nextLine();
                char temp_gender=g.charAt(0);//Exception handling if non binary
                boolean temp_prescription=false;
                int prescription=s.nextInt();//Exception handling if non int

                s.nextLine();  // consume the leftover newline

                if(prescription==1)temp_prescription=true;
                double temp_balance =s.nextDouble();

                s.nextLine();  // consume the leftover newline

                String temp_pass =s.nextLine();


                //make a new customer 
                person[persons_count_in_pharamcy++]=new Customer(temp_name, temp_age, temp_gender, temp_prescription, temp_balance, temp_pass);
                

                //Go for the main menu
                Customer customer=(Customer)person[persons_count_in_pharamcy-1];
                customer.main_menu();





            }
            else if (x==6)
            {
                System.out.println("Please enter your name and password sir ");
                String temp_name =s.nextLine();
                String temp_password=s.nextLine();
                customer_login(temp_name ,temp_password);
            }
            else if(x==7)
            {
                repeat=false;
            }
        }
    }


    public void place_order(int index,int amount_needed)
    {
        orders[orders_count_in_pharamcy] =new Order(items[index],amount_needed,LocalDate.now());
        orders_count_in_pharamcy++;
    }

    
}
