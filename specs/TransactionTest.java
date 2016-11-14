import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class TransactionTest {
     Customer customer;
     Shop shop;
     Double amount;
     Transaction transaction;

     @Before
     public void Before(){

          customer = new Customer("Zippy");
          shop = new Shop("BearsRUrsus");
          amount = new Double(500.00);
          transaction = new Transaction(1, customer, shop, amount);
     }

     @Test
     public void canGetShopName(){
          Shop thisShop = transaction.getShop();
          String shopName = thisShop.getName();
          assertEquals("BearsRUrsus", shopName);
     }
}