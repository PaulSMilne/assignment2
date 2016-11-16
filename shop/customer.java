package shop;
import java.util.*;

public class Customer{

     private String name;
     private HashMap<BankCard, Double> paymentOptions;
     private ArrayList<StockItem> basket;

     public Customer(String name){
          this.name = name;
          this.paymentOptions = new HashMap<BankCard, Double>();
          this.basket = new ArrayList<StockItem>();
     }

     public String getName() {return this.name;}

     public HashMap<BankCard, Double> getPaymentOptions() {return this.paymentOptions;}

     public ArrayList<StockItem> getBasket() { return this.basket; }

     public void setPaymentOptions(BankCard card, double cardFunds){
          Double availableFunds = new Double(cardFunds);
          paymentOptions.put(card, availableFunds);
     }

     public Double getTotalFunds(){
          HashMap<BankCard, Double> currentCards = getPaymentOptions();
          Double sum = new Double(0.00);
          for ( Double cardSum : currentCards.values() ) { sum += cardSum; }
          return sum;
     }

     public Double getCurrentCardFunds(BankCard card){
          HashMap<BankCard, Double> paymentOptions = getPaymentOptions();
          Double currentCardFunds = paymentOptions.get(card);
          return currentCardFunds;
     }

     public void makePayment(BankCard card, double amount){
          Double currentCardFunds = getCurrentCardFunds(card);
          currentCardFunds -= amount;
          setPaymentOptions(card, currentCardFunds);
     }

     public void receiveRefund(BankCard card, double amount){
          Double currentCardFunds = getCurrentCardFunds(card);
          currentCardFunds += amount;
          setPaymentOptions(card, currentCardFunds);
     }
}
