package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }


  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    for (Rental each : rentals) {
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.amount()) + "\n";
    }
    //add footer lines result
    result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
    result += "You earned " + String.valueOf(getFrequentRenterPoints())
        + " frequent renter points";
    return result;
  }


  public String htmlStatement() {
    String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>\n";

    for (Rental each : rentals) {
      result += "<span>" + each.getMovie().getTitle() + "</span>" +
              String.valueOf(each.amount()) + "<br/>\n";
    }

    //add footer lines result
    result += "Amount owed is <b>" + String.valueOf(getTotalAmount()) + "</b><br/>\n";
    result += "You earned <b>" + String.valueOf(getFrequentRenterPoints())
            + "</b> frequent renter points<br/>\n";
    return result ;
  }


  private int getFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints);
    }
    return frequentRenterPoints;
  }

  private double getTotalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.amount();
    }
    return totalAmount;
  }

}

