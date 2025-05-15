
package main;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends Person {
    private Scanner s = new Scanner(System.in);
    private Double Balance;
    private char gender;
    private String password;
    private static int number_of_customers = 0;

    Customer(String name, int age, char gender, double Balance, String password) {
        super(name, age);
        this.gender = gender;
        this.Balance = Balance;
        this.password = password;
        Customer.number_of_customers++;
    }

    public static int get_number_of_customers()
    {
        return number_of_customers;
    }

    public boolean check_pass(String password) {
        return this.password.equals(password);
    }
    
    public Double get_balance(){return this.Balance;}
    
    char get_gender(){return this.gender;}

    @Override
    void display_self() {
       
        Person.get_TextArea().appendText("-----------------------------------------------\n");
        Person.get_TextArea().appendText("Name:" + this.get_name()+"\n");
        Person.get_TextArea().appendText ("Age:" + this.get_age()+"\n");
       Person.get_TextArea().appendText  ("Balance: " + this.Balance + "$\n");
        if (gender == 'm' || gender == 'M')
        { Person.get_TextArea().appendText  ("Gender: Male\n");
         Person.get_TextArea().appendText("-----------------------------------------------\n");}
        else if (gender == 'f' || gender == 'F'){
           Person.get_TextArea().appendText  ("Gender: Female\n");
            Person.get_TextArea().appendText("-----------------------------------------------\n");}
        else
            throw new IllegalArgumentException("Must be Male or Female");
        
        
      
        
        
        
       
       
        
    }
    public class itemBuyError extends Exception{
        public itemBuyError(String message){
            super(message);
        }
    }

    public void make_order(String order_owner, String name, int amount_needed) throws IllegalArgumentException, itemBuyError {
        boolean found = false;
        System.out.println("-----------------------------------------------");
        for (int index = 0; index < Pharmacy.item_count_in_pharmacy; index++) {
            if (p.items[index].get_name().equals(name))// item found
            {
                if (p.items[index].get_count() >= amount_needed) {
                    if (p.items[index].get_price() * amount_needed > Balance) {
                        System.out.println("Insfuccient Funds to Complete Process");
                        throw new itemBuyError("Insfuccient Funds to Complete Process");
                    } else {
                        // order place and items count decreased
                        found = true;
                        p.items[index].set_subtract_count(amount_needed);

                        p.place_order(order_owner, index, amount_needed);
                        Balance -= p.items[index].get_price() * amount_needed;
                    }
                } else {
                    System.out.println("Insuffcient Amount Of This Item, There are only " + p.items[index].get_count() +
                            " Of It Left, So Please Ask for Diffrent Amount If ->=0 you will exit");
                    throw new itemBuyError("Insuffcient Amount Of This Item");
                    
                    

                   
                }
                System.out.println("-----------------------------------------------");
                return;
            }
        }
        if (!found) {
            System.out.println("No Such Item Found");
            throw new itemBuyError("No Such Item Found");
           // System.out.println("-----------------------------------------------");
        }
    }

    public void main_menu() {
        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("Hello Mr/ " + this.get_name() + "  please choose a number from below");
            System.out.println("1)Display Self Data");
            System.out.println("2)Make An Order");
            System.out.println("3)Track An Order");
            System.out.println("4)Display All Items");
            System.out.println("5)Display My orders");

            System.out.println("6)Logout");
            System.out.println("-----------------------------------------------");
            int Decsion = 0;
            while (true) {
                try {
                    Decsion = s.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an integer input");
                    s.nextLine();
                }
            }
            if (Decsion == 1) {
                this.display_self();
            } else if (Decsion == 2) {
                System.out.println("Please enter the name of the order and the amount needed");
                s.nextLine();
                String temp_name = s.nextLine();
                int temp_amount_needed = 0;
                while (true) {
                    try {
                        temp_amount_needed = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter an Integer value for");
                        s.nextLine();
                    }
                }
                System.out.println("-----------------------------------------------");
              //  this.make_order(get_name(), temp_name, temp_amount_needed);
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
                for (int i = 0; i < Pharmacy.orders_count_in_pharamcy; i++) {
                    if (p.orders[i].get_order_owner().equals(this.get_name())) {
                        p.orders[i].display_order_info();
                    }
                }
            } else if (Decsion == 6) {
                {
                    while (true) {
                        System.out.println("Please enter a number to add to your balance ");
                        double number = 0;
                        while (true) {
                            try {
                                number = s.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a Double value ");
                                s.nextLine();
                            }

                        }
                        if (number > 0) {
                            Balance += number;
                            break;
                        } else {
                            System.out.println("Invalid input you can't add negative value to the balanace");
                        }
                    }
                }

            } else if (Decsion == 7) {
                break;
            }
        }
    }

}
