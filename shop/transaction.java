package shop;
import java.util.*;

public class Transaction{

     private int id;
     private Customer customer;
     private Shop shop;
     private BankCard card;

     public Transaction(int id, Customer customer, Shop shop){
          this.id = id;
          this.customer = customer;
          this.shop = shop;
     }

     public Customer getCustomer(){
          return this.customer;
     }

     public Shop getShop(){
          return this.shop;
     }

     public void makeTransaction(BankCard card, Double amount, TransactionType transaction){
          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double currentCardFunds = paymentOptions.get(card);
          if (transaction == TransactionType.SALE){
               shop.updateSales(amount);
               Double newCardFunds = currentCardFunds - amount;}
          else if (transaction == TransactionType.REFUND){
               shop.updateRefunds(amount);
               Double newCardFunds = currentCardFunds + amount;}
          }
          customer.setPaymentOptions(card, newCardFunds);
     }

     // public void makeSale(BankCard card, Double amount){
     //      shop.updateSales(amount);
     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double currentCardFunds = paymentOptions.get(card);
     //      Double newCardFunds = currentCardFunds - amount;
     //      customer.setPaymentOptions(card, newCardFunds);
     // }

     // public void issueRefund(BankCard card, Double amount){
     //      shop.updateRefunds(amount);
     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double currentCardFunds = paymentOptions.get(card);
     //      Double newCardFunds = currentCardFunds + amount;
     //      customer.setPaymentOptions(card, newCardFunds); 
     // }
}