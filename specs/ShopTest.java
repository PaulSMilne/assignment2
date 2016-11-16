import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class ShopTest {

     Shop shop;
     Double sales;
     Double refunds;
     StockItem inStock1;
     StockItem inStock2;
     HashMap<StockItem, Integer> stock;

     @Before
     public void Before(){
          shop = new Shop("BearsRUrsus");
          inStock1 = new StockItem("Dancing Bear");
          inStock2 = new StockItem("Fortune Telling Bear");

     }

     @Test
     public void canGetName(){

          String name = shop.getName();
          assertEquals("BearsRUrsus", name);
     }

     @Test
     public void canGetSales(){
          assertEquals(0.00, shop.getSales(), 0);
     }

     @Test
     public void canGetRefunds(){
          assertEquals(0.00, shop.getRefunds(), 0);
     }

     @Test
     public void canUpdateSales(){

          Double newSales = shop.updateSales(500.00);
          assertEquals(500.00, newSales, 0);
     }

     @Test
     public void canUpdateRefunds(){

          Double newRefunds = shop.updateRefunds(350.00);
          assertEquals(350.00, newRefunds, 0);
     }
 
     @Test
     public void canGetTotalShopFunds(){

          shop.updateSales(500.00);
          shop.updateRefunds(350.00);
          assertEquals(150.00, shop.getIncomeReport(), 0);
     }

     @Test
     public void canGetStockItems(){
          HashMap<StockItem, Integer> stock = shop.getStock();
          assertEquals(0, stock.size());

     }

     @Test
     public void canAddStockItems(){
          shop.addStock(inStock1, 3);
          shop.addStock(inStock2, 2);
          HashMap<StockItem, Integer> stock = shop.getStock();
          assertEquals(2, stock.size());
     }

     @Test
     public void canRemoveAnItemOfStock(){
          shop.addStock(inStock1, 3);
          shop.sellItem(inStock1);
          HashMap<StockItem, Integer> itemsInStock = shop.getStock();
          int dancingBearsInStock = itemsInStock.get(inStock1);
          assertEquals(2, dancingBearsInStock);
     }

     @Test
     public void returnsStringIfNoStockLeft(){
          shop.addStock(inStock1, 1);
          String message1 = shop.sellItem(inStock1);
          assertEquals("This item is in stock", message1);

          HashMap<StockItem, Integer> itemsInStock = shop.getStock();
          int dancingBearsInStock = itemsInStock.get(inStock1);
          assertEquals(0, dancingBearsInStock);

          String message2 = shop.sellItem(inStock1);
          HashMap<StockItem, Integer> currentItemsInStock = shop.getStock();
          int currentDancingBearsInStock = currentItemsInStock.get(inStock1);
          assertEquals("This item is out of stock.", message2);
          assertEquals(0, currentDancingBearsInStock);
      }
}