package shop;
import java.util.*;

public class Shop{

     private String name;
     private Double sales;
     private Double refunds;
     private Double totalShopFunds;
     //private ArrayList<CardType> acceptedCards;

     public Shop(String name){
          this.name = name;
          this.sales = new Double(0.00);
          this.refunds = new Double(0.00);
          this.totalShopFunds = new Double(0.00);
          //this.acceptedCards = new ArrayList<CardType>();
     }

     public String getName(){
          return this.name;
     }

     public Double getSales(){
          return this.sales;
     }

     public Double getRefunds(){
          return this.refunds;
     }

     public Double getTotalShopFunds(){
          Double currentSales = getSales();
          Double currentRefunds = getRefunds();
          this.totalShopFunds = currentSales - currentRefunds;
          return this.totalShopFunds;
     }

     public Double updateSales(double update){
          Double newSales = new Double(update);
          Double currentSales = getSales();
          this.sales = currentSales + newSales;
          return this.sales;
     }

     public Double updateRefunds(double update){
          Double newRefunds = new Double(update);
          Double currentRefunds = getRefunds();
          this.refunds = currentRefunds + newRefunds;
          return this.refunds;
     }


}    