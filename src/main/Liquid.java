package main;

import java.time.LocalDate;

public class Liquid extends Item 
{
    double volume;
    Liquid(String name ,int count ,LocalDate expiry,double volume,double price)
    {
        super(name, count, expiry,price);
        this.volume=volume;
    }
}
