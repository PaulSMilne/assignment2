import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class TransactionTest {
     Customer customer;
     Shop shop;
     BankCard card1;
     BankCard card2;
     //Double amount;
     HashMap<BankCard, Double> paymentOptions;
     Transaction transaction;

     @Before
     public void Before(){

          shop = new Shop("BearsRUrsus");
          customer = new Customer("Zippy");
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          customer.setPaymentOptions(card1, 10000.00);
          customer.setPaymentOptions(card2, 3000.00);
          Double amount = new Double(500.00);
          transaction = new Transaction(1, customer, shop);
    }

     @Test
     public void canGetShopName(){
          Shop thisShop = transaction.getShop();
          String shopName = thisShop.getName();
          assertEquals("BearsRUrsus", shopName);
     }
     @Test
     public void canGetCustomerName(){
          Customer thisCustomer = transaction.getCustomer();
          String customerName = thisCustomer.getName();
          assertEquals("Zippy", customerName);
     }
     @Test
     public void saleTakesCustomerFundsFromParticularCard(){
          transaction.makeSale(card1, amount);
          Double newFunds = paymentOptions.get(card1);
          assertEquals(500.00, newFunds, 0);


     }
}