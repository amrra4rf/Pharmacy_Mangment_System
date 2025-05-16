package main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pharmacy {
    private Scanner s = new Scanner(System.in);
    public static int item_count_in_pharmacy = 0;
    public static int persons_count_in_pharamcy = 0;
    public static int orders_count_in_pharamcy = 0;
    public static int index = persons_count_in_pharamcy;
    private final static int length = 1000;// constant
    Person[] person = new Person[length * 10]; // max number of persons to be added is 10000
    Item[] items = new Item[length * 10]; // max number of items to be added is 10000
    Order[] orders = new Order[length * 100]; // max number of orders to be made at once is 100000

    // This is an implemnation to a Singleton pattern that makes the pharmacy only
    // instatized once int the whole program
    private static Pharmacy p = new Pharmacy();

    private Pharmacy() {
    } // making constructor private so  one can make an instance of the pharmacy
      // except our pre made one

    public static Pharmacy getInstance() {
        return p;
    }

    // start of getters
    public static int get_length() {
        return length;
    }

    // end of getters

    public void Dr_login() {

        if (Doctor.count_of_doctors <= 0) {
            System.out.println("There are no doctors in the pharmacy currently.");
            return;
        } else {

            while (true) {
                System.out.println("Enter your ID:");
                String temp_id = s.nextLine();
                System.out.println("Enter your password:");
                String temp_pass = s.nextLine();

                for (int i = 0; i < persons_count_in_pharamcy; i++) {
                    if (person[i] instanceof Doctor) {
                        Doctor d = (Doctor) person[i];
                        if (d.get_id().equals(temp_id) && d.check_pass(temp_pass)) {
                            d.main_menu();
                            return;
                        }
                    }
                }

                System.out.println("Invalid Id or Password.");
                System.out.println("Press 1 to try again, or any other key to return to the menu:");

                int choice = 0;
                try {
                    choice = s.nextInt();
                } catch (InputMismatchException e) {
                    s.nextLine(); // clear the buffer
                    break;
                }
                s.nextLine(); // clear leftover newline

                if (choice != 1)
                    break;
            }
        }
       // menu();
    }

    public void customer_login() {
        if (Customer.get_number_of_customers() <= 0) {
            System.out.println("There is No Customers in The Pharmacy currently");
        } else {
            while (true) {

                System.out.println("Enter your name:");
                String temp_name = s.nextLine();
                System.out.println("Enter your password:");
                String temp_pass = s.nextLine();

                for (int i = 0; i < persons_count_in_pharamcy; i++) {
                    if (person[i] instanceof Customer) {
                        Customer customer = (Customer) person[i];
                        if (customer.get_name().equals(temp_name) && customer.check_pass(temp_pass)) {
                            customer.main_menu();
                            return;
                        }

                    }

                }
                System.out.println("Invalid Id or Password.");
                System.out.println("Press 1 to try again, or any other key to return to the menu:");

                int choice = 0;
                try {
                    choice = s.nextInt();
                } catch (InputMismatchException e) {
                    s.nextLine(); // clear the buffer
                    break;
                }
                s.nextLine(); // clear leftover newline

                if (choice != 1)
                    break;
            }
        }
        menu();
    }

    // this function shows the main menu
    public void menu() {
        while (true) {

            System.out.println("                                            Hello To Our Pharmacy");

            System.out.println(" Choose The Action You want to make from below: ");

            System.out.println(" 1) Sign up As A doctor ");

            System.out.println(" 2) Sign in As A doctor ");

            System.out.println(" 3) Sign up As An Customer ");

            System.out.println(" 4) Sign in As An Customer ");

            System.out.println(" 5) Exit ");

            int x = 0;
            try {
                x = s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Invalid input you will be redirected to the main menu");
                continue;
            }

            if (x > 5 || x < 1) {
                System.out.println("Invalid Enter a number between 1-7");
            } else if (x == 1)// sign up doctor
            {
                System.out.println("please enter your name ,age ,salary and password");
                String temp_name = "", temp_pass = "";
                int temp_age = 0;
                double temp_salary = 0;
                try {
                    s.nextLine(); // consume the leftover newline
                    temp_name = s.nextLine();
                    temp_age = s.nextInt();
                    s.nextLine(); // consume the leftover newline
                    temp_salary = s.nextDouble();
                    s.nextLine(); // consume the leftover newline
                    temp_pass = s.nextLine();
                } catch (InputMismatchException e) {
                    s.nextLine();
                    System.out.println("Invalid input you will be redirected to the main menu");
                    continue;
                }
                person[persons_count_in_pharamcy++] = new Doctor(temp_name, temp_age, temp_salary, temp_pass);// made an
                                                                                                              // new
                                                                                                              // Doctor

                // to go for the main menu
                Doctor doc = (Doctor) person[persons_count_in_pharamcy - 1];
                doc.main_menu();
            } else if (x == 2)// sign in doctor
            {
                s.nextLine();
                Dr_login();
            } else if (x == 3) {
                if (persons_count_in_pharamcy >= length * 10)
                    System.out.println("Can't add more person");
                else
                {
                    System.out.println(
                            "Please enter name, age , gender ,balance and finally password ");
                    s.nextLine(); // consume the leftover newline
                    String temp_name = "", g = "", temp_pass = "";
                    int temp_age = 0;
                    double temp_balance = 0;
                    char temp_gender;
                    try {
                        temp_name = s.nextLine();
                        temp_age = s.nextInt(); // Exception handling if non int

                        s.nextLine(); // consume the leftover newline

                        g = s.nextLine();
                        temp_gender = g.charAt(0);// Exception handling if non binary
                        if (!(temp_gender == 'm' || temp_gender == 'M' || temp_gender == 'f' || temp_gender == 'F')) {
                            System.out.println("Invalid gender You will be redirected to main menu");
                            continue;
                        }

                        temp_balance = s.nextDouble();

                        s.nextLine(); // consume the leftover newline

                        temp_pass = s.nextLine();
                    } catch (InputMismatchException e) {
                        s.nextLine();
                        System.out.println("Invalid Input You will be redirected to main menu");
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        s.nextLine();
                        System.out.println("Invalid character Input You will be redirected to main menu");
                        continue;
                    }
                    // make a new customer
                    person[persons_count_in_pharamcy++] = new Customer(temp_name, temp_age, temp_gender,
                            temp_balance, temp_pass);

                    // Go for the main menu
                    Customer customer = (Customer) person[persons_count_in_pharamcy - 1];
                    customer.main_menu();
                }

            } else if (x == 4) {
                s.nextLine(); // consume the leftover newline
                customer_login();
            } else {
                break;
            }
        }
    }

    public void place_order(String order_owner ,int index, int amount_needed) {

        orders[orders_count_in_pharamcy] = new Order(order_owner,items[index], amount_needed, LocalDate.now());
        System.out.println("Order Placed Sucessfully and the Order Number is :"
                + orders[orders_count_in_pharamcy].get_order_number());
        orders_count_in_pharamcy++;
    }

}
