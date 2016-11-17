package shop;
import java.util.*;

public class Shop{

     private String name;
     private Double sales;
     private Double refunds;
     private HashMap<StockItem, Integer> stock;

     public Shop(String name){
          this.name = name;
          this.sales = new Double(0.00);
          this.refunds = new Double(0.00);
          this.stock = new HashMap<StockItem, Integer>();
     }

     public String getName() { return this.name; }

     public Double getSales() { return this.sales; }

     public Double getRefunds() { return this.refunds; }

     public HashMap<StockItem, Integer> getStock() {return this.stock; }

     public void addStock(StockItem item, int stockLevel){
          Integer currentStockLevel = new Integer(stockLevel);
          stock.put(item, currentStockLevel);
     }

     public void updateStock(StockItem item, int number){
          HashMap<StockItem, Integer> currentStock = getStock();
          int currentStockLevelOfItem = currentStock.get(item);
          currentStockLevelOfItem += number;
          addStock(item, currentStockLevelOfItem);
     }

     public String sellItem(StockItem item){
          if (stock.get(item) == 0) {
               return "This item is out of stock.";
          }
          int currentStockLevel = stock.get(item);
          currentStockLevel -= 1;
          addStock(item, currentStockLevel);
          return "This item is in stock";
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

     public Double getIncomeReport(){
          Double currentSales = getSales();
          Double currentRefunds = getRefunds();
          Double totalIncome = currentSales - currentRefunds;
          return totalIncome;
     }
}    
