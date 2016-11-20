package shop;
import java.util.*;

public class Customer{

     private String name;
     private HashMap<Payable, Double> paymentOptions;
     //private double acct;
     private ArrayList<StockItem> basket;

     public Customer(String name){
          this.name = name;
          this.paymentOptions = new HashMap<Payable, Double>();
          this.basket = new ArrayList<StockItem>();
          //this.acct = acct;
     }

     public String getName() {return this.name;}

     //public double getAcct() {return this.acct;}

     //public void setAcct(double amount) {this.acct = amount;}

     public HashMap<Payable, Double> getPaymentOptions() {return this.paymentOptions;}

     public ArrayList<StockItem> getBasket() { return this.basket; }

     public void addToBasket(StockItem item){
          basket.add(item);
     }

     public void removeFromBasket(StockItem item){
          int itemIndex = basket.indexOf(item);
          basket.remove(itemIndex);
     }


     public void setPaymentOptions(Payable paymentMethod, double cardFunds){
          Double availableFunds = new Double(cardFunds);
          paymentOptions.put(paymentMethod, availableFunds);
     }

     public Double getTotalFunds(){
          HashMap<Payable, Double> currentCards = getPaymentOptions();
          Double sum = new Double(0.00);
          for ( Double cardSum : currentCards.values() ) { sum += cardSum; }
          return sum;
     }

     public Double getCurrentCardFunds(Payable paymentMethod){
          HashMap<Payable, Double> paymentOptions = getPaymentOptions();
          Double currentCardFunds = paymentOptions.get(paymentMethod);
          return currentCardFunds;
     }

     public void makePayment(Payable paymentMethod, double amount){
          Double currentCardFunds = getCurrentCardFunds(paymentMethod);
          currentCardFunds -= amount;
          setPaymentOptions(paymentMethod, currentCardFunds);
     }

     public void receiveRefund(Payable paymentMethod, double amount){
          Double currentCardFunds = getCurrentCardFunds(paymentMethod);
          currentCardFunds += amount;
          setPaymentOptions(paymentMethod, currentCardFunds);
     }
}
