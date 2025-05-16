package main;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

 class JFXInitializer {
    // Call this once before running tests that use JavaFX
    public static void init() {
        // JFXPanel initializes JavaFX runtime (Toolkit)
        new JFXPanel(); 
    }
}
public class Customertest {

    Pharmacy phar;
    Customer c;

    @BeforeEach
    public void input_setup() {
        JFXInitializer.init();
        phar =Pharmacy.getInstance();
        c = new Customer("Amr", 20, 'm', 5000, "p123");
    }

    //testing if the singleton pattern works well
    @Test
    public void Singletontest()
    {
        Pharmacy p1 = Pharmacy.getInstance();
        Pharmacy p2 = Pharmacy.getInstance();
        assertEquals(p1, p2, "Refrences must be Equal");
    }
    @Test 
    public void check_pass_test_true()
    {
        assertTrue(c.check_pass("p123"));
    }

    @Test
    public void check_pass_test_false()
    {
         assertFalse(c.check_pass("p123 ")); //putting a space after  p123 
    }

    
    @Test
    public void get_balance_test()
    {
        assertNotEquals(50000,c.get_balance());//50000 instead of 5000
        assertEquals(5000, c.get_balance());
    }


}