import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class CustomerTest {

     BankCard card;
     Customer customer;
     HashMap<BankCard, Double> paymentOptions;

     @Before
     public void before(){
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          customer = new Customer("Zippy");
          // paymentOptions = new HashMap<BankCard, Double>();
     }

     @Test
     public void canAddCardToPaymentOptions(){
          customer.setPaymentOptions(card1, 100.00);
          customer.setPaymentOptions(card2, 200.00);
          HashMap currentCards = customer.getPaymentOptions;
          assertEquals(2, currentCards.size());
     }
}