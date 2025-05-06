package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Doctortest {
    @Test
    public void test()
    {
        Doctor d=new Doctor("AMR", 20, 4000, "p123");
        assertEquals(4000, d.getsalry()); 
    }
    
}
