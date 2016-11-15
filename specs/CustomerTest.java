import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class CustomerTest {

     BankCard card1;
     BankCard card2;
     Customer customer;
     double totalFunds;

     @Before
     public void before(){
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          customer = new Customer("Zippy");
          totalFunds = 0;
          customer.setPaymentOptions(card1, 100.00);
          customer.setPaymentOptions(card2, 200.00);
     }

     @Test
     public void canAddCardToPaymentOptions(){
          HashMap<BankCard, Double> currentCards = customer.getPaymentOptions();
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
}