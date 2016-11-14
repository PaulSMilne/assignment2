package shop;
import java.util.*;

public class Customer{

     private String name;
     private double cardFunds;
     private BankCard card;
     private HashMap<BankCard, Double> paymentOptions;

     public Customer(String name){
          this.name = name;
          this.paymentOptions = new HashMap<BankCard, Double>();
     }

     public void setPaymentOptions(BankCard card, double cardFunds){
          Double availableFunds = new Double(cardFunds);
          paymentOptions.put(card, availableFunds);
     }

     public HashMap getPaymentOptions(){
          return this.paymentOptions;
     }








}











//Payables have a total spend variable set to 0. This is the variable that will be moved up and down by spending and refunding. 

//As per Bobby, have the paymentType be a Payable with limit. Limit - total spend will give the funds available per card. Sum of these will give total funds available to the customer.
