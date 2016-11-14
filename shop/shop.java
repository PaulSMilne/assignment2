package shop;
import java.util.*;

public class Shop{

     private String name;
     private double sales;
     private double refunds;
     private double totalShopFunds;
     //private ArrayList<CardType> acceptedCards;

     public Shop(String name){
          this.name = name;
          this.sales = 0.00;
          this.refunds = 0.00;
          this.totalShopFunds = 0.00;
          //this.acceptedCards = new ArrayList<CardType>();
     }

     public String getName(){
          return this.name;
     }

     public double getSales(){
          return this.sales;
     }

     public double getRefunds(){
          return this.refunds;
     }

     public double getTotalShopFunds(){
          return this.totalShopFunds;
     }


}    