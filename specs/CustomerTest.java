import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shop.*;
//import behaviours.*;


public class CustomerTest {

     BankCard card1;
     BankCard card2;
     Customer customer;
     HashMap<BankCard, Double> paymentOptions;
     double totalFunds;

     @Before
     public void before(){
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          customer = new Customer("Zippy");
          //paymentOptions = new HashMap<BankCard, Double>();
          totalFunds = 0;
     }

     @Test
     public void canAddCardToPaymentOptions(){
          customer.setPaymentOptions(card1, 100.00);
          customer.setPaymentOptions(card2, 200.00);
          HashMap<BankCard, Double> currentCards = customer.getPaymentOptions();
          assertEquals(2, currentCards.size());
     }

     @Test
     public void canAddCardFundsToGetTotalFunds(){
          customer.setPaymentOptions(card1, 100.00);
          customer.setPaymentOptions(card2, 200.00);
          HashMap<BankCard, Double> currentCards = customer.getPaymentOptions();
          Double totalFunds = customer.getTotalFunds(currentCards);
          assertEquals(300.00, totalFunds, 0);
     }
}