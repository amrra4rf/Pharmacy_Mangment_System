package main;

import java.time.LocalDate;

public class Tablet extends Item 
{
    int number_of_capsules;
    Tablet(String name ,int count ,LocalDate expiry,int number_of_capsules,double price)
    {
        super(name, count, expiry,price);
        this.number_of_capsules=number_of_capsules;
    }
}
