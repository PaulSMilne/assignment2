package shop;
import java.util.*;

public class Transaction{

     private int id;
     private Customer customer;
     private Shop shop;
     private Double amount;

     public Transaction(int id, Customer customer, Shop shop, double amount){
          this.id = id;
          this.customer = customer;
          this.shop = shop;
          this.amount = amount;
     }

     public Customer getCustomer(){
          return this.customer;
     }

     public Shop getShop(){
          return this.shop;
     }

     public Double getAmount(){
          return this.amount;
     }
}