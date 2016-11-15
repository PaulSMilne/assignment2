import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class ShopTest {

     Shop shop;
     Double sales;
     Double refunds;
    // Double totalShopFunds;

     @Before
     public void Before(){
          shop = new Shop("BearsRUrsus");
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


}