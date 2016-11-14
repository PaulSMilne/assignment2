import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class TransactionTest {
     Customer customer;
     Shop shop;
     Double amount;

     @Before
     public void Before(){

          customer = new Customer("Zippy");

          shop = new Shop("BearsRUrsus");

          amount = new Double(500.00);
     }
}