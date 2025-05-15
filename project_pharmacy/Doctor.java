package project_pharmacy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import static project_pharmacy.Pharmacy.persons_count_in_pharamcy;

public class Doctor extends Person implements Capabilities {
    private String password;
    private Scanner s;
    private String id;
    public static int count_of_doctors = 0;
    private double salary;
   
    

    Doctor(String name, int age, double salary, String password) {
        super(name, age);// pass the name and age to the person class to intialize them
        id = (++count_of_doctors) + "D";// make the doctor id as his number + 'D' letter
        this.salary = salary;
        this.password = password;
        s = new Scanner(System.in);
    }
     

    // geters
    public String get_id() {
        return id;
    }
   
    // end of getters

    // checks if the password given is the doctor's pass
    public boolean check_pass(String p) {
        return password.equals(p);
    }
//public static TextArea l = new TextArea();
   void display_self() {
        System.out.println("-----------------------------------------------");
        System.out.println("Name: Dr/" + this.get_name());
        System.out.println("Id:" + this.id);
        System.out.println("Age:" + this.get_age());
        System.out.println("Salary:" + this.salary + "$");
        System.out.println("-----------------------------------------------");
        
        //TextArea l = new TextArea();
        l.setEditable(false);
        l.appendText("-----------------------------------------------\n");
        l.appendText("Name: Dr/" + this.get_name()+"\n");
        
        l.appendText("Id:" + this.id+"\n") ;
        l.appendText ("Age:" + this.get_age()+"\n");
        l.appendText  ("Salary: " + this.salary + "$\n");
        l.appendText("-----------------------------------------------\n");
    }
   public class notFoundException extends Exception{
       public notFoundException(String message){
           super(message);
       }
   }

    public void find_person_by_name(String n) throws notFoundException// this function display all of the persons with the given intials
    {
       
        boolean found=false;
        for (int i = 0; i < (Pharmacy.persons_count_in_pharamcy); i++) // p.person.length returns the number of persons
                                                                       // assigned in the pharmacy
        {

            try {
                
                    if (p.person[i].get_name().substring(0, n.length()).toLowerCase().equals(n.toLowerCase())
                        && (!(this.get_name().equals(p.person[i].get_name()))))// you find persons except yourslef
                {
                        p.person[i].display_self();
                      
                    found=true;
                    
                
                }
            
            } catch (IndexOutOfBoundsException e) {
                // when the n.length is larger than the p.person[i].get_name()
               
                continue;
                
            }
            

        }
        if(!found){throw new notFoundException("No such person was found!");}
    }

    public void add_item(String n, int count, LocalDate expiry, double price) {
        if (Pharmacy.item_count_in_pharmacy < Pharmacy.get_length() * 10) { // checks if there is a place for items in
                                                                            // the
            // pharmacy
            p.items[Pharmacy.item_count_in_pharmacy++] = new Item(n, count, expiry, price);
            System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
        } else {
            System.out.println("Error: Pharmacy item capacity reached");
            return;
        }

    }

    // Overwrite method in case u know the item type tablet or liquid
    public void add_item(String n, int count, LocalDate expiry, double price, char type) {

        if (Pharmacy.item_count_in_pharmacy < Pharmacy.get_length() * 10) {
            // if item is liquid or tablet
            if (type == 'l' || type == 'L') {
                System.out.println("Please Enter The Volume Of The liquid in mg");
                double vol = 0;// intilaization
                

                p.items[Pharmacy.item_count_in_pharmacy++] = new Liquid(n, count, expiry, vol, price);// polymorphism
                                                                                                      // applied :)
                System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
            } else if (type == 't' || type == 'T') {
                System.out.println("Please Enter The Number Of Capusles in The Tabelt");
                int number = 0;
                // input mismatch exception handling
                

                p.items[Pharmacy.item_count_in_pharmacy++] = new Tablet(n, count, expiry, number, price);// polymorphism
                                                                                                         // applied :)
                System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
            }
        } else {
            System.out.println("Error: Pharmacy item capacity reached");
            return;
        }
    }
//    public void add_item_waleed(String n, int count, LocalDate expiry, double price, char type){}
    
    
    
    
    
    public static TextArea sb = new TextArea();
     public void Display_Persons() {
         
        
        for (int i = 0; i < Pharmacy.persons_count_in_pharamcy; i++) {
            //p.person[i].display_self();
            if(p.person[i] instanceof Doctor){
                Doctor doc = (Doctor)p.person[i];
            sb.appendText("-------"+"Doctor------\n");
            sb.appendText("Name: "+doc.get_name()+"\n");
            sb.appendText("ID: "+doc.id+"\n");
            sb.appendText("Age: "+doc.get_age()+"\n");
            sb.appendText("Salary: "+doc.salary+"\n");
            sb.appendText("\n");}
            else if(p.person[i] instanceof Customer){
                Customer c = (Customer)p.person[i];
                if(c.get_gender() == 'm' || c.get_gender() == 'M'){
                sb.appendText("-------Customer-------\n");
                sb.appendText("Name: "+c.get_name()+"\n");
                sb.appendText("Age: "+c.get_age()+"\n");
                sb.appendText("Gender: Male \n");
                sb.appendText("Balance: "+c.get_balance()+"\n");
                sb.appendText("\n");
                }
                if(c.get_gender() == 'f' || c.get_gender() == 'F'){
                sb.appendText("-------Customer-------\n");
                sb.appendText("Name: "+c.get_name()+"\n");
                sb.appendText("Age: "+c.get_age()+"\n");
                sb.appendText("Gender: Female \n");
                sb.appendText("Balance: "+c.get_balance()+"\n");
                sb.appendText("\n");
                }
                
                
            
            }
        }
        
        sb.appendText("Total number of users: "+persons_count_in_pharamcy);
    }

        
    // this function ensures when the count of some items is 0 to be removed from
    // the array
    private void remove_from_arr(int index) {
        if (index < 0 || index >= Pharmacy.item_count_in_pharmacy) {
            System.out.println("Error: Invalid index for removal");
            return;
        }

        for (int i = index; i < Pharmacy.item_count_in_pharmacy - 1; i++) {
            p.items[i] = p.items[i + 1];
        }
        p.items[Pharmacy.item_count_in_pharmacy - 1] = null;
        Pharmacy.item_count_in_pharmacy--;
    }

    public void remove_item(Item removed_item, int count_to_be_removed) {
        if (removed_item == null) {
            System.out.println("Error: Item cannot be null");
            return;
        }
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            
                if (p.items[i].equals(removed_item) && p.items[i] != null) {
                    // Exception if (count_to_be_removed >count) will be added
                    if (count_to_be_removed > p.items[i].get_count()) {
                        System.out.println(
                                "The count you want to remove is more than what's avilable please enter a valid number");

                        while (true) {
                            try {
                                count_to_be_removed = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer amount to be removed");
                                s.nextLine();
                            }
                        }

                    } else {
                        System.out.println(
                                count_to_be_removed + " " + p.items[i].get_name() + " Has been removed Sucessfully");
                        p.items[i].set_subtract_count(count_to_be_removed);// removed an amount of the item from the
                                                                           // Pharmacy
                        if (p.items[i].get_count() == 0)
                            remove_from_arr(i);
                        break;
                    }
                }
            
        }

    }

    // remove a certain amount of the item by giving the item name
    public void remove_item_by_name(String n, int count_to_be_removed) throws removeException
    {
for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {

            if (p.items[i].get_name().equals(n)) {
                 if (count_to_be_removed > p.items[i].get_count()){
                 
                 System.out.println( "The count you want to remove is more than what's avilable there is only" + p.items[i].get_count() + " so,please enter a valid number");
                 throw new removeException("not enought items");
                 }
                 
                
                
            
                else if (count_to_be_removed < 0){ 
                    System.out.println("Error can't remove negative values please enter a postive value");  
                    throw new removeException("Invalid input");
                    } 
            else {
                        System.out.println(
                                count_to_be_removed + " of " + p.items[i].get_count() + " Items Has been removed Sucessfully from "+p.items[i].get_name());
                        p.items[i].set_subtract_count(count_to_be_removed);// removed an amount of the item from the
                                                                           // Pharmacy
                        if (p.items[i].get_count() == 0)
                            remove_from_arr(i);
                        return;
                    }
                
                
                
            
        }

        
}
       

    }
    
    /*
    public void remove_item_by_name(String n, int count_to_be_removed) throw errorException
    {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {

            if (p.items[i].get_name().equals(n)) {
                System.out.println( "The count you want to remove is more than what's avilable there is only" + p.items[i].get_count() + " so,please enter a valid number");
            }
                else if (count_to_be_removed < 0){ 
                    System.out.println("Error can't remove negative values please enter a postive value");  
                    } 
            else {
                        System.out.println(
                                count_to_be_removed + " of " + p.items[i].get_count() + " Items Has been removed Sucessfully from "+p.items[i].get_name());
                        p.items[i].set_subtract_count(count_to_be_removed);// removed an amount of the item from the
                                                                           // Pharmacy
                        if (p.items[i].get_count() == 0)
                            remove_from_arr(i);
                        return;
                    }
                
                
                
            
        }
    
    
    }
    */

    // remove a certain amount of the item by giving the item id
    public void remove_item_by_id(String id, int count_to_be_removed) {

        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {

            if (p.items[i].get_id().equals(id)) {
                while (true) {
                    if (count_to_be_removed > p.items[i].get_count()) {
                        System.out.println(
                                "The count you want to remove is more than what's avilable there is only"
                                        + p.items[i].get_count() + " so,please enter a valid number");
                        while (true) {
                            try {
                                count_to_be_removed = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an integer number to be removed");
                                s.nextLine();
                            }
                        }

                    } else if (count_to_be_removed < 0) {
                        System.out.println("Error can't remove negative values please enter a postive value");
                        while (true) {
                            try {
                                count_to_be_removed = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a integer amount to be removed");
                                s.nextLine();
                            }
                        }
                    } else {
                        System.out.println(
                                count_to_be_removed + " " + p.items[i].get_name() + " Has been removed Sucessfully");
                        p.items[i].set_subtract_count(count_to_be_removed);
                        ;// removed an amount of the item from the Pharmacy
                        if (p.items[i].get_count() == 0)
                            remove_from_arr(i);
                        break;
                    }
                }
            }
        }
        System.out.println("No such item with the Id: " + id);
    }

    @Override
     public Item find_item_by_name(String name) throws itemNotFoundException
    {
        boolean found=false;
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i] != null && p.items[i].get_name() != null && p.items[i].get_name().equals(name)) {
                found=true;
                p.items[i].Displayinfo();
                return p.items[i];
                
            }

        }
        // if no item with this name found
        if(!found){throw new itemNotFoundException("No such item was found");}
        return null;
        

    }

    public Item find_item_by_id(String id) {
        
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i] != null && p.items[i].get_id() != null && p.items[i].get_id().equals(id)) {
                
                p.items[i].Displayinfo();
                return p.items[i];
            }

        }

        return null;
    }

    public void increase_amount_of_item(Item increased_item, int amount_to_be_added) {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].equals(increased_item)) {
                p.items[i].set_add_count(amount_to_be_added);
                return;
            }
        }
    }

    // Method to add a new amount to an existing item by item name
    public void increase_amount_of_item_by_name(String name, int amount_to_be_added) {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_name().equals(name)) {
                p.items[i].set_add_count(amount_to_be_added);
                ;
                return;
            }
        }
        System.out.println("No Such Item with this name");
    }

    // Method to add a new amount to an existing item by item id
    public void increase_amount_of_item_by_id(String id, int amount_to_be_added) {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_id().equals(id)) {
                p.items[i].set_add_count(amount_to_be_added);
                break;
            }
        }
        System.out.println("No such items with this id");
    }
    

    public void ship_item() throws noItemsToShip
    {

        if (Pharmacy.orders_count_in_pharamcy <= 0 || p.orders == null){
            System.out.println("No Items Ordered");
        throw new noItemsToShip("No oreders yet!");}
        else {
            for(int i=0;i<Pharmacy.orders_count_in_pharamcy;i++){
                if(!p.orders[i].get_order_shipped())
                p.orders[i].display_order_info();
            
            
            }

        }
    }

    public void main_menu() {

        while (true) {
            boolean repeat = true;
            while (repeat) {
                System.out.println("-----------------------------------------------");

                System.out.println("Welcome Dr/" + get_name() + "To the main menu");

                System.out.println("Please enter the Number u Want to do ");

                System.out.println("1)Display_self");

                System.out.println("2)Display_Persons");

                System.out.println("3)Find_person_by_name");

                System.out.println("4)Find_item_by_name");

                System.out.println("5)Find_item_by_id");

                System.out.println("6)Add specfic item");

                System.out.println("7)Add_item");

                System.out.println("8)Remove_item_by_name");

                System.out.println("9)Remove_item_by_id");

                System.out.println("10)display_items");
                ;

                System.out.println("11)Display_items_sorted");


                System.out.println("12)Ship order");
                System.out.println("13)Log out");

                System.out.println("-----------------------------------------------");

                int x = 0;
                while (true) {
                    try {
                        x = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input please neter an integer");
                        s.nextLine();
                    }
                }
                if (x > 13 || x < 1) {
                    System.out.println("Please Enter a Valid Number");
                    repeat = true; // this line is usless but just to make sure
                } else {
                    if (x == 1)
                        this.display_self();
                    else if (x == 2)
                        this.Display_Persons();
                    else if (x == 3) {
                        s.nextLine(); // consume the leftover newline

                        System.out.println("Please Enter The name u want to find or an intial of his first name ");

                        String temp_name = s.nextLine();
                        try {
                            this.find_person_by_name(temp_name);
                        } catch (NullPointerException e) {
                            System.out.println("No such Item found ");
                        }
                        catch(notFoundException e){} //added by meeeeeeee
                    } else if (x == 4) {
                        System.out.println("Please Enter The Item name u want to find ");
                        s.nextLine();
                        String temp_name = s.nextLine();
                        try{Item f = find_item_by_name(temp_name);}
                        catch(itemNotFoundException e)
                        { System.out.println("exception added by waleeeed");}
                        Item f=null;
                        if (f != null) {
                            System.out.println("-----------------------------------------------");
                            System.out.println(
                                    "Please Choose and Action to do with this item (Otherwise u will go back to main menu) ");
                            System.out.println("1)Remove Item ");
                            System.out.println("2)increase_amount_of_item");
                            System.out.println("3)Dispaly info ");
                            System.out.println("-----------------------------------------------");
                            int decsion = 0;
                            while (true) {
                                try {
                                    decsion = s.nextInt();
                                    break;
                                } catch (InputMismatchException ee) {
                                    System.out.println("Please enter an integer from 1 to 3");
                                    s.nextLine();
                                }
                            }
                            if (decsion == 1) {
                                System.out.println("Plz enter the amount you want to remove ");
                                while (true) {
                                    try {
                                        decsion = s.nextInt();
                                        break;
                                    } catch (InputMismatchException e2) {
                                        System.out.println("Please enter an integer amount to be removed");
                                        s.nextLine();
                                    }
                                }
                                remove_item(f, decsion);
                            } else if (decsion == 2) {
                                System.out.println("Plz enter the amount you want to add");
                                while (true) {
                                    try {
                                        decsion = s.nextInt();
                                        break;
                                    } catch (InputMismatchException e4) {
                                        System.out.println("Please enter an integer to be added");
                                        s.nextLine();
                                    }
                                }
                                increase_amount_of_item(f, decsion);

                            } else if (decsion == 3) {
                                f.Displayinfo();
                            } else {
                                System.out.println("Invalid Input You will Be Directed To The Main Menu");

                            }
                        } else {
                            System.out.println("Item Not Found ");
                        }

                    } else if (x == 5) {
                        System.out.println("Please Enter The Item id u want to find ");

                        s.nextLine(); // consume the leftover newline
                        String identfication = s.nextLine();

                        Item f = find_item_by_id(identfication);
                            
                        if (f != null) {
                            System.out.println(
                                    "Please Choose and Action to do with this item (Otherwise u will go back to main menu) ");
                            System.out.println("1)Remove Item ");
                            System.out.println("2)increase_amount_of_item");
                            System.out.println("3)Dispaly info");
                            int decsion = 0;
                            while (true) {
                                try {
                                    decsion = s.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Please enter an integer from 1 to 3");
                                    s.nextLine();
                                }
                            }
                            if (decsion == 1) {
                                System.out.println("Plz enter the amount you want to remove ");
                                while (true) {
                                    try {
                                        decsion = s.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Please enter an integer from 1 to 3");
                                        s.nextLine();
                                    }
                                }
                                remove_item(f, decsion);
                            } else if (decsion == 2) {
                                System.out.println("Plz enter the amount you want to add");
                                while (true) {
                                    try {
                                        decsion = s.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Please enter an integer from 1 to 3");
                                        s.nextLine();
                                    }
                                }
                                increase_amount_of_item(f, decsion);

                            } else if (decsion == 3) {
                                f.Displayinfo();
                            }
                        } else
                            System.out.println("Item not found");
                    } else if (x == 6) {
                        System.out.println(
                                "Please enter the name, count , price, type of the item(l for liquid and T for Tablet ) and the number of avilabilty years Respectivly   ");
                        s.nextLine(); // consume the leftover newline
                        String temp_name = s.nextLine();
                        int temp_count = 0;
                        while (true) {
                            try {
                                temp_count = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer value of count");
                                s.nextLine();
                            }

                        }

                        double temp_price = 0;
                        while (true) {
                            try {
                                temp_price = s.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an double value of price");
                                s.nextLine();
                            }

                        }

                        s.nextLine(); // consume the leftover newline
                        String temp = s.nextLine();
                        char temp_type = temp.charAt(0);
                        while (true) {
                        if(temp_type=='l'|| temp_type=='L'||temp_type=='t'||temp_type=='T')
                        {
                            System.out.println("Please enter the number of avilabltiy years");
                            break;
                        }
                        System.out.println("Invalid Input please enter l for liquid and t for tablet");
                        temp=s.nextLine();
                        temp_type=temp.charAt(0);
                    }
                        
                        int temp_years = 0;
                        while (true) {
                            try {
                                temp_years = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer value of years");
                                s.nextLine();
                            }

                        }
                        s.nextLine(); // consume the leftover newline
                        add_item(temp_name, temp_count, LocalDate.now().plusYears(temp_years), temp_price, temp_type);

                    } else if (x == 7) {
                        System.out.println(
                                "Please enter the name, count, the number of avilabilty years and price aRespectivly   ");
                        s.nextLine(); // consume the leftover newline
                        String temp_name = s.nextLine();
                        int temp_count = 0;
                        while (true) {
                            try {
                                temp_count = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer value of count");
                                s.nextLine();
                            }

                        }
                        int temp_years = 0;
                        while (true) {
                            try {
                                temp_years = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer value of years");
                                s.nextLine();
                            }

                        }
                        double temp_price = 0;
                        while (true) {
                            try {
                                temp_price = s.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Double value of price");
                                s.nextLine();

                            }

                        }
                        
                        System.out.println("-----------------------------------------------");
                        add_item(temp_name, temp_count, LocalDate.now().plusYears(temp_years), temp_price);
                    } else if (x == 8) {
                        
                        System.out.println(
                                "Plz enter the item name u want to remove and the amount to be removed respectivly ");
                        s.nextLine(); // consume the leftover newline
                        String temp_name = s.nextLine();

                        int temp_amount = 0;
                        while (true) {
                            try {
                                temp_amount = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out
                                        .println("Invalid input please enter an Integer value of amount to be removed");
                                        s.nextLine();
                            }

                        }
try{                        remove_item_by_name(temp_name, temp_amount);}
catch(removeException e){}//added by me to remove errors
                        // item removed sucesfully message will be added in the function itself

                    } else if (x == 9) {
                        System.out.println(
                                "Plz enter the item id u want to remove and the amount to be removed respectivly ");
                        s.nextLine(); // consume the leftover newline
                        String temp_id = s.nextLine();

                        int temp_amount = 0;
                        while (true) {
                            try {
                                temp_amount = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input please enter an Integer value of amount");
                                s.nextLine();
                            }

                        }
                        remove_item_by_id(temp_id, temp_amount);
                    } else if (x == 10) {
                        display_items();
                    }

                    else if (x == 11) {
                        if (Pharmacy.item_count_in_pharmacy < 1)
                            System.out.println("There is No item in The Pharmacy right now");
                        else {
                            Item[] temp = new Item[Pharmacy.item_count_in_pharmacy]; // deep copy
                            for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
                                temp[i] = new Item(p.items[i].get_name(), p.items[i].get_count(),
                                        p.items[i].get_expiry_date(), p.items[i].get_price());
                                        temp[i].set_id(p.items[i].get_id());
                            }
                            Arrays.sort(temp);
                            for (Item i : temp) {
                                i.Displayinfo();
                            }
                        }
                    }
                     
                    else if(x==12)
                    {
                        Boolean found=false;
                        if(Pharmacy.orders_count_in_pharamcy==0)
                        {
                            System.out.println("No items to be shipped");
                        }
                        else{
                        for(int i=0;i<Pharmacy.orders_count_in_pharamcy;i++)
                        {
                            p.orders[i].display_order_info();
                        }
                        System.out.println("Please choose the order number u want to ship");
                        s.nextLine();
                        String order_number=s.nextLine();
                        for(int i=0;i<Pharmacy.orders_count_in_pharamcy;i++)
                        {
                            if(p.orders[i].get_order_number().equals(order_number))
                            {
                                p.orders[i].ship_order();
                                System.out.println("Order Number "+p.orders[i].get_order_number()+" is Shipped Sucessfully");
                                found=true;
                            }
                        }
                        if(!found)
                        System.out.println("No Such Order with this Number");
                    }

                    }
                    else if (x == 13) {
                        // go to the Pharmacy main menu
                        p.menu();

                    }
                    System.out.println("-----------------------------------------------");

                }

            }
        }

    }
        //public static TextArea m = new TextArea();
        

    void display_items() {
        if (Pharmacy.item_count_in_pharmacy == 0) {
            System.out.println("No items to be displayed ");
            m.appendText("no items added");
            return;
        }

        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i] == null)
                continue;
            if (p.items[i] instanceof Tablet) {
                Tablet t = (Tablet) p.items[i];
                //t.Displayinfo();
                m.appendText("----Tablet--------\n");
                m.appendText("Name:"+t.get_name()+"\n");
                m.appendText("Count: "+t.get_count()+"\n");
                m.appendText("Expires after: "+t.get_expiry_date()+"\n");
                m.appendText("Number of capsules: "+t.get_number_capsules()+"\n");
                m.appendText("Price: "+t.get_price()+"\n");
                m.appendText("---------------------");
               
            } else if (p.items[i] instanceof Liquid) {
                Liquid l = (Liquid) p.items[i];
                //l.Displayinfo();
                m.appendText("----Liquid---------------\n");
                m.appendText("Name:"+l.get_name()+"\n");
                m.appendText("Count: "+l.get_count()+"\n");
                m.appendText("Expires after: "+l.get_expiry_date()+"\n");
                m.appendText("Volume: "+l.get_volume()+"\n");
                m.appendText("Price: "+l.get_price()+"\n");
                m.appendText("-----------------------------------");
            } else {
                p.items[i].Displayinfo();
            }
            System.out.println("-----------------------------------------------");
        }

    }

    private void closeResources() {
        if (s != null) {
            s.close();
        }
    }

}
