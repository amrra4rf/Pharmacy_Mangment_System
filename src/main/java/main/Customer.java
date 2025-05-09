package main;

import java.util.Scanner;

public class Customer extends Person {
    private Scanner s = new Scanner(System.in);
    private Double Balance;
    private char gender;
    private String password;
    public static int number_of_customers = 0;

    Customer(String name, int age, char gender, double Balance, String password) {
        super(name, age);
        this.gender = gender;
        this.Balance = Balance;
        this.password = password;
        Customer.number_of_customers++;
    }

    public boolean check_pass(String password) {
        return this.password.equals(password);
    }

    @Override
    void display_self() {
        System.out.println("-----------------------------------------------");
        System.out.println("Name :" + get_name());
        System.out.println("Age :" + get_age());
        if (gender == 'm' || gender == 'M')
            System.out.println("Gender : Male");
        else if (gender == 'f' || gender == 'F')
            System.out.println("Gender: Female");
        else
            throw new IllegalArgumentException("Must be Male or Female");
        System.out.println("Balance  :" + Balance + "$");
        System.out.println("-----------------------------------------------");
    }

    public void make_order(String name, int amount_needed) throws IllegalArgumentException {
        System.out.println("-----------------------------------------------");
        for (int index = 0; index < Pharmacy.item_count_in_pharmacy; index++) {
            if (p.items[index].get_name().equals(name))// item found
            {
                if (p.items[index].get_count() >= amount_needed) {
                    if (p.items[index].get_price() * amount_needed > Balance) {
                        System.out.println("Insfuccient Funds to Complete Process");
                    } else {
                        // order place and items count decreased
                        p.items[index].set_subtract_count(amount_needed);
                        ;
                        p.place_order(index, amount_needed);
                        Balance -= p.items[index].get_price() * amount_needed;
                    }
                } else {
                    System.out.println("Insuffcient Amount Of This Item, There are only " + p.items[index].get_count() +
                            " Of It Left, So Please Ask for Diffrent Amount If >=0 you will exit");
                    int amount = s.nextInt();

                    if (amount > 0) {
                        make_order(name, amount);
                    }

                }
                System.out.println("-----------------------------------------------");
                return;
            } else {
                System.out.println("No Such Item Found");
                System.out.println("-----------------------------------------------");
            }
        }

    }

    public void main_menu() {
        while (true) 
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Hello Mr/ " + this.get_name() + "  please choose a number from below");
            System.out.println("1)Display Self Data");
            System.out.println("2)Make An Order");
            System.out.println("3)Track An Order");
            System.out.println("4)Display All Items");
            System.out.println("5)Logout");
            System.out.println("-----------------------------------------------");
            int Decsion = s.nextInt();
            if (Decsion == 1) {
                this.display_self();
            } else if (Decsion == 2) {
                System.out.println("Please enter the name of the order and the amount needed");
                s.nextLine();
                String temp_name = s.nextLine();
                int temp_amount_needed = s.nextInt();
                System.out.println("-----------------------------------------------");
                this.make_order(temp_name, temp_amount_needed);
            }

            // tracking order
            else if (Decsion == 3) {
                s.nextLine();
                System.out.println("Please enter the order number ");
                String temp_order_number = s.nextLine();
                for (int i = 0; i < Pharmacy.orders_count_in_pharamcy; i++) {
                    if (temp_order_number.equals(p.orders[i].get_order_number())) {
                        System.out.println("-----------------------------------------------");
                        p.orders[i].display_order_info();
                        break;
                    }
                }
            }

            // display items info
            else if (Decsion == 4) {
                if (Pharmacy.item_count_in_pharmacy < 1)
                    System.out.println("No Items currently in the array");
                else {
                    for (int i = 0; i < Pharmacy.item_count_in_pharmacy; i++) {
                        p.items[i].Displayinfo();
                    }
                }
            } else if (Decsion == 5) {
                break;
            }
        }
    }

}
