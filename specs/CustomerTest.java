import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class CustomerTest {

     CreditCard card1;
     CreditCard card2;
     Customer customer;
     double totalFunds;
     StockItem stockItem;

     @Before
     public void before(){
          card1 = new CreditCard("Barclays", CardType.VISA_CREDIT);
          card2 = new CreditCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          stockItem = new StockItem("Dancing Bear");
          customer = new Customer("Zippy", 10000.00);
          totalFunds = 0;
          customer.setPaymentOptions(card1, 100.00);
          customer.setPaymentOptions(card2, 200.00);

     }

     @Test
     public void canAddCardToPaymentOptions(){
          HashMap<Payable, Double> currentCards = customer.getPaymentOptions();
          assertEquals(2, currentCards.size());
     }

     @Test
     public void canAddCardFundsToGetTotalFunds(){
          Double totalFunds = customer.getTotalFunds();
          assertEquals(300.00, totalFunds, 0);
     }

     @Test
     public void canChangeFundsOnExistingCard(){
          customer.setPaymentOptions(card1, 150.00);
          Double totalFunds = customer.getTotalFunds();
          assertEquals(350.00, totalFunds, 0);
     }
     @Test
     public void canGetBasketItems(){
          assertEquals(0, customer.getBasket().size());
     }

     @Test
     public void canAddItemsToBasket(){
          customer.addToBasket(stockItem);
          assertEquals(1, customer.getBasket().size());
     }
}