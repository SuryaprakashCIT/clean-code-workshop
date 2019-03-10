package com.thoughtworks.movierental;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void test(){}

    @Test
    public void characterTest2(){
        Customer testCustomer = new Customer("Test");
        testCustomer.addRental(new Rental(new Movie("Star Trek",2), 10));
        testCustomer.addRental(new Rental(new Movie("The Mummy Returns",0), 15));
        testCustomer.addRental(new Rental(new Movie("Avengers",1), 9));
        assertEquals("Rental Record for Test\n" +
                "\tStar Trek\t12.0\n" +
                "\tThe Mummy Returns\t21.5\n" +
                "\tAvengers\t27.0\n" +
                "Amount owed is 60.5\n" +
                "You earned 4 frequent renter points",testCustomer.statement());

    }

    @Test
    public void characterTest1(){
        Customer testCustomer = new Customer("Test");
        testCustomer.addRental(new Rental(new Movie("Star Trek",2), 29));
        testCustomer.addRental(new Rental(new Movie("The Mummy Returns",2), 2));
        testCustomer.addRental(new Rental(new Movie("Avengers",1), 8));
        assertEquals("Rental Record for Test\n" +
                "\tStar Trek\t40.5\n" +
                "\tThe Mummy Returns\t1.5\n" +
                "\tAvengers\t24.0\n" +
                "Amount owed is 66.0\n" +
                "You earned 4 frequent renter points",testCustomer.statement());

    }
    @Test
    public void characterTest3(){
        Customer testCustomer = new Customer("Test");
        testCustomer.addRental(new Rental(new Movie("Star Trek",0), 10));
        testCustomer.addRental(new Rental(new Movie("The Mummy Returns",0), 44));
        testCustomer.addRental(new Rental(new Movie("Avengers",0), 45));
        assertEquals("Rental Record for Test\n" +
                "\tStar Trek\t14.0\n" +
                "\tThe Mummy Returns\t65.0\n" +
                "\tAvengers\t66.5\n" +
                "Amount owed is 145.5\n" +
                "You earned 3 frequent renter points",testCustomer.statement());

    }
    @Test
    public void characterTest4(){
        Customer testCustomer = new Customer("Test");
        testCustomer.addRental(new Rental(new Movie("Star Trek",1), 10));
        testCustomer.addRental(new Rental(new Movie("The Mummy Returns",1), 15));
        testCustomer.addRental(new Rental(new Movie("Avengers",1), 30));
        assertEquals("Rental Record for Test\n" +
                "\tStar Trek\t30.0\n" +
                "\tThe Mummy Returns\t45.0\n" +
                "\tAvengers\t90.0\n" +
                "Amount owed is 165.0\n" +
                "You earned 6 frequent renter points",testCustomer.statement());

    }


    @Test
    public void htmlStatement1(){
        Customer testCustomer = new Customer("Test");
        testCustomer.addRental(new Rental(new Movie("Star Trek",1), 10));
        testCustomer.addRental(new Rental(new Movie("The Mummy Returns",1), 15));
        testCustomer.addRental(new Rental(new Movie("Avengers",1), 30));
        assertEquals("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Rental Record</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "<h1>Rental Record for <b>Test</b></h1><br/>\n" +
                "<span>Star Trek</span>30.0<br/>\n" +
                "<span>The Mummy Returns</span>45.0<br/>\n" +
                "<span>Avengers</span>90.0<br/>\n" +
                "Amount owed is <b>165.0</b><br/>\n" +
                "You earned <b>6</b> frequent renter points<br/>\n" +
                "</body>\n" +
                "</html>",testCustomer.htmlStatement());

    }

}