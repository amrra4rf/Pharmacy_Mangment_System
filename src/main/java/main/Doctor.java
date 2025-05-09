package main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import javax.naming.NameNotFoundException;

public class Doctor extends Person implements Capabilities {
    private String password;
    private Scanner s = new Scanner(System.in);
    private String id;
    public static int count_of_doctors = 0;
    private double salary;


    
    Doctor(String name, int age, double salary, String password) {
        super(name, age);// pass the name and age to the person class to intialize them
        id = (++count_of_doctors) + "D";// make the doctor id as his number + 'D' letter
        this.salary = salary;
        this.password = password;
    }

    //geters
    public  String get_id()
    {
        return id;
    }

    


    //end of getters

    //checks if the password given is the doctor's pass
    public boolean check_pass(String p) {
        return password.equals(p);
    }

    void display_self() {
        System.out.println("-----------------------------------------------");
        System.out.println("Name: Dr/" + this.get_name());
        System.out.println("Id:" + this.id);
        System.out.println("Age:" + this.get_age());
        System.out.println("Salary:" + this.salary + "$");
        System.out.println("-----------------------------------------------");
    }

    public void find_person_by_name(String n)// this function display all of the persons with the given intials
    {

        for (int i = 0; i < (Pharmacy.persons_count_in_pharamcy); i++) // p.person.length returns the number of persons
                                                                       // assigned in the pharmacy
        {

            if (p.person[i].get_name().substring(0, n.length()).toLowerCase().equals(n.toLowerCase())
                    && (!(this.get_name().equals(p.person[i].get_name()))))// you find persons except yourslef
            {
                p.person[i].display_self();
            }
        }
    }

    public void add_item(String n, int count, LocalDate expiry, double price) {
        if (Pharmacy.item_count_in_pharmacy < Pharmacy.get_length() * 10) { // checks if there is a place for items in the
                                                                      // pharmacy
            p.items[Pharmacy.item_count_in_pharmacy++] = new Item(n, count, expiry, price);
            System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
        }

    }

    // Overwrite method in case u know the item type tablet or liquid
    public void add_item(String n, int count, LocalDate expiry, double price, char type) {

        if (Pharmacy.item_count_in_pharmacy < Pharmacy.get_length() * 10) {
            // if item is liquid or tablet
            if (type == 'l' || type == 'L') {
                System.out.println("Please Enter The Volume Of The liquid in mg");
                double vol = s.nextDouble();

                p.items[Pharmacy.item_count_in_pharmacy++] = new Liquid(n, count, expiry, vol, price);// polymorphism
                                                                                                      // applied :)
                System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
            } else if (type == 't' || type == 'T') {
                System.out.println("Please Enter The Number Of Capusles in The Tabelt");
                int number = s.nextInt();

                p.items[Pharmacy.item_count_in_pharmacy++] = new Tablet(n, count, expiry, number, price);// polymorphism
                                                                                                         // applied :)
                System.out.println(count + " Items of " + n + " Has Been Added Sucessfully To The Pharmacy ");
            }
        }
    }

    public void Display_Persons() {
        for (int i = 0; i < Pharmacy.persons_count_in_pharamcy; i++) {
            p.person[i].display_self();
        }
    }

    private void remove_from_arr(int index) {
        for (int i = index; i < Pharmacy.item_count_in_pharmacy - 1; i++) {
            p.items[i] = p.items[i + 1];

        }
        p.items[Pharmacy.item_count_in_pharmacy - 1] = null;
        Pharmacy.item_count_in_pharmacy--;
    }

    public void remove_item(Item removed_item, int count_to_be_removed) {

        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].equals(removed_item)) {
                // Exception if (count_to_be_removed >count) will be added
                if (count_to_be_removed > p.items[i].get_count()) {
                    System.out.println(
                            "The count you want to remove is more than what's avilable please enter a valid number");
                    int remove = s.nextInt();
                    remove_item_by_name(get_name(), remove);
                } else {
                    System.out.println(count_to_be_removed + " " + p.items[i].get_name() + " Has been removed Sucessfully");
                    p.items[i].set_subtract_count( count_to_be_removed);// removed an amount of the item from the Pharmacy
                    if (p.items[i].get_count() == 0)
                        remove_from_arr(i);
                    return;
                }
            }
        }

    }

    // remove a certain amount of the item by giving the item name
    public void remove_item_by_name(String name, int count_to_be_removed) {

        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_name().equals(name)) {
                // Exception if (count_to_be_removed >count) will be added
                if (count_to_be_removed > p.items[i].get_count()) {
                    System.out.println(
                            "The count you want to remove is more than what's avilable please enter a valid number");
                    int remove = s.nextInt();
                    remove_item_by_name(name, remove);
                } else {
                    System.out.println(count_to_be_removed + " " + p.items[i].get_count() + " Has been removed Sucessfully");
                    p.items[i].set_subtract_count(count_to_be_removed);// removed an amount of the item from the Pharmacy
                    if (p.items[i].get_count() == 0)
                        remove_from_arr(i);
                    return;
                }
            }

        }
        System.out.println("No such item with the name: " + name);

    }

    // remove a certain amount of the item by giving the item id
    public void remove_item_by_id(String id, int count_to_be_removed) {

        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {

            if (p.items[i].get_id().equals(id)) {
                // Exception if (count_to_be_removed >count) will be added
                if (count_to_be_removed > p.items[i].get_count()) {
                    System.out.println(
                            "The count you want to remove is more than what's avilable please enter a valid number");
                    int remove = s.nextInt();
                    remove_item_by_name(get_name(), remove);
                } else {
                    System.out.println(count_to_be_removed + " " + p.items[i].get_name() + " Has been removed Sucessfully");
                    p.items[i].set_subtract_count(count_to_be_removed);;// removed an amount of the item from the Pharmacy
                    if (p.items[i].get_count() == 0)
                        remove_from_arr(i);
                    break;
                }
            }
        }
    }

    public Item find_item_by_name(String name) {
        // this is a ref of type item that will refer to the wanted item and will be
        // returned
        Item temp = null;
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_name().equals(name)) {
                temp = p.items[i];
                return temp;
            }

        }
        // if no item with this name found
        return temp;

    }

    public Item find_item_by_id(String id) {
        Item temp = null;
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_id().equals(id)) {
                temp = p.items[i];
                return temp;
            }

        }
        // This throws a custom exception called IdNotFoundException which will be added
        // later
        return temp;
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
    public void increase_amount_of_item_by_name(String name, int amount_to_be_added) throws NameNotFoundException {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_name().equals(name)) {
                p.items[i].set_add_count(amount_to_be_added);;
                return;
            }
        }
        throw new NameNotFoundException("No Item With This Name Was Found");

    }

    // Method to add a new amount to an existing item by item id
    public void increase_amount_of_item_by_id(String id, int amount_to_be_added) {
        for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
            if (p.items[i].get_id().equals(id)) {
                p.items[i].set_add_count(amount_to_be_added);;
                break;
            }
            // custom made exception of IdNotFound will be added here
        }

    }

    public void ship_item() {

        if (Pharmacy.orders_count_in_pharamcy == 0)
            System.out.println("No Items Ordered");
        else {
            for (int i = 0; i < Pharmacy.orders_count_in_pharamcy; i++) {
                p.orders[i].display_order_info();
            }
            if (Pharmacy.orders_count_in_pharamcy < 2)// if there is only 1 item ordered
            {
                System.out.println("Are u sure u want to Sell " + (p.orders[0].get_amount_ordered()) + " of "
                        + (p.orders[0].get_item().get_name()) + "Click 1 if yes and otherwise if  No");
                String c = s.nextLine();
                char click = c.charAt(0);
                if (click == '1') {
                    p.orders[0].ship_order();
                    System.out.println("Item Shipped Sucessfully");
                } else {
                    System.out.println("Item Shipping Cancelled");
                }
                this.main_menu();
            }

        }
    }

    public void main_menu() {

        boolean repeat = true;
        while (repeat) {
            System.out.println("-----------------------------------------------");

            System.out.println("Welcome Dr/" + get_name() + "To the main menu");

            System.out.println("Please enter the Number u Want to add ");

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

            System.out.println("12)Log out");

            System.out.println("-----------------------------------------------");

            int x = s.nextInt();
            if (x > 12 || x < 1) {
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
                    this.find_person_by_name(temp_name);
                } else if (x == 4) {
                    System.out.println("Please Enter The Item name u want to find ");
                    s.nextLine();
                    String temp_name = s.nextLine();
                    Item f = find_item_by_name(temp_name);
                    if (f != null) {
                        System.out.println("-----------------------------------------------");
                        System.out.println(
                                "Please Choose and Action to do with this item (Otherwise u will go back to main menu) ");
                        System.out.println("1)Remove Item ");
                        System.out.println("2)increase_amount_of_item");
                        System.out.println("3)Dispaly info ");
                        System.out.println("-----------------------------------------------");

                        int decsion = s.nextInt();
                        if (decsion == 1) {
                            System.out.println("Plz enter the amount you want to remove ");

                            decsion = s.nextInt();
                            remove_item(f, decsion);
                        } else if (decsion == 2) {
                            System.out.println("Plz enter the amount you want to add");
                            decsion = s.nextInt();
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
                        int decsion = s.nextInt();
                        if (decsion == 1) {
                            System.out.println("Plz enter the amount you want to remove ");
                            decsion = s.nextInt();
                            remove_item(f, decsion);
                        } else if (decsion == 2) {
                            System.out.println("Plz enter the amount you want to add");
                            decsion = s.nextInt();
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
                    int temp_count = s.nextInt();
                    double temp_price = s.nextDouble();
                    s.nextLine(); // consume the leftover newline
                    String temp = s.nextLine();
                    char temp_type = temp.charAt(0);
                    int temp_years = s.nextInt();
                    s.nextLine(); // consume the leftover newline
                    add_item(temp_name, temp_count, LocalDate.now().plusYears(temp_years), temp_price, temp_type);

                } else if (x == 7) {
                    System.out.println(
                            "Please enter the name, count, the number of avilabilty years and price aRespectivly   ");
                    s.nextLine(); // consume the leftover newline
                    String temp_name = s.nextLine();
                    int temp_count = s.nextInt();
                    int temp_years = s.nextInt();
                    double temp_price = s.nextDouble();

                    System.out.println("-----------------------------------------------");
                    add_item(temp_name, temp_count, LocalDate.now().plusYears(temp_years), temp_price);
                } else if (x == 8) {
                    System.out.println(
                            "Plz enter the item name u want to remove and the amount to be removed respectivly ");
                    s.nextLine(); // consume the leftover newline
                    String temp_name = s.nextLine();
                    int temp_amount = s.nextInt();
                    remove_item_by_name(temp_name, temp_amount);
                    // item removed sucesfully will be added in the function itself

                } else if (x == 9) {
                    System.out.println(
                            "Plz enter the item id u want to remove and the amount to be removed respectivly ");
                    s.nextLine(); // consume the leftover newline
                    String temp_id = s.nextLine();
                    int temp_amount = s.nextInt();
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
                            temp[i] = new Item(p.items[i].get_name(), p.items[i].get_count(), p.items[i].get_expiry_date(), p.items[i].get_price());
                        }
                        Arrays.sort(temp);
                        for (Item i : temp) {
                            i.Displayinfo();
                        }
                    }
                }

                else if (x == 12) {
                    // go to the Pharmacy main menu
                    p.menu();
                }
                System.out.println("-----------------------------------------------");

            }

        }

    }

    void display_items() {
        if (Pharmacy.item_count_in_pharmacy == 0)
            System.out.println("No items to be displayed ");
        else {
            for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
                if (p.items[i] instanceof Tablet) {
                    Tablet t = (Tablet) p.items[i];
                    t.Displayinfo();
                } else if (p.items[i] instanceof Liquid) {
                    Liquid l = (Liquid) p.items[i];
                    l.Displayinfo();
                } else {
                    p.items[i].Displayinfo();
                }
                System.out.println("-----------------------------------------------");
            }
        }

    }

}
