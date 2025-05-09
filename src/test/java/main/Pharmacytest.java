package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;




public class Pharmacytest
{

        Pharmacy phar;
        Doctor d1;
        private final InputStream systemIn = System.in;
        private ByteArrayInputStream testIn;

    @BeforeEach
    public void input_setup()
    {    phar = Pharmacy.getInstance();
        
        // reset state
        phar.persons_count_in_pharamcy=0;
        phar.item_count_in_pharmacy=0;
        phar.orders_count_in_pharamcy=0;

        // clear array
        Arrays.fill(phar.person, null); 
        
    }
        @AfterEach
        void restoreSystemInput() {
            System.setIn(systemIn);
        }

        void provideInput(String data) {
            testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
        }

    @BeforeEach
    public void setup()
    {
    phar.getInstance();
    d1=new Doctor("amr", 20, 5000, "p123");
    phar.person[Pharmacy.persons_count_in_pharamcy++]=d1;
    }


    @Test
    public void Singletontest()
    {
        Pharmacy p1=Pharmacy.getInstance();
        Pharmacy p2=Pharmacy.getInstance();
        assertEquals(p1,p2,"Refrences must be Equal");
    }

    


   



}