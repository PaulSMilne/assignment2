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

     Transaction transaction;

     @Before
     public void Before(){

          customer = new Customer("Zippy T. Pinhead");
          shop = new Shop("BearsRUrsus");
          
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card1.makeDefault();
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          
          customer.setPaymentOptions(card1, 10000.00);
          customer.setPaymentOptions(card2, 3000.00);
          
          transaction = new Transaction(customer, shop);
    }

     // @Test
     // public void canGetShopName(){

     //      Shop thisShop = transaction.getShop();
     //      String shopName = thisShop.getName();

     //      assertEquals("BearsRUrsus", shopName);
     // }
     // @Test
     // public void canGetCustomerName(){

     //      Customer thisCustomer = transaction.getCustomer();
     //      String customerName = thisCustomer.getName();

     //      assertEquals("Zippy", customerName);
     // }
     // @Test
     // public void saleTransfersCustomerFundsFromParticularCardToShop(){

     //      Double amount1 = new Double(499.99);
     //      Double amount2 = new Double(1499.99);

     //      transaction.makeTransaction(card1, amount1, TransactionType.SALE);
     //      transaction.makeTransaction(card2, amount2, TransactionType.SALE);

     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double newFunds = paymentOptions.get(card1);
     //      assertEquals(9500.01, newFunds, 0);

     //      Double customerNewFunds = customer.getTotalFunds();
     //      assertEquals(11000.02, customerNewFunds, 0);

     //      Double salesFigures = shop.getSales();
     //      assertEquals(1999.98, salesFigures, 0);

     //      Double shopFunds = shop.getIncomeReport();
     //      assertEquals(1999.98, shopFunds, 0);
     // }

     // @Test
     // public void refundPutsMoneyOnNominatedCard(){

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(card1, amount1, TransactionType.REFUND);

     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double card1Funds = paymentOptions.get(card1);

     //      assertEquals(10499.99, card1Funds, 0);
     // }

     // @Test
     // public void refundAddsToShopRefundFigures(){

     //      Double amount1 = new Double(499.99);
     //      Double amount2 = new Double(1499.99);

     //      transaction.makeTransaction(card1, amount1, TransactionType.REFUND);

     //      Double refundFigures = shop.getRefunds();

     //      assertEquals(499.99, refundFigures, 0);
     // }

     // @Test
     // public void refundTakesFromTotalShopFunds(){

     //      Double amount1 = new Double(499.99);
     //      Double amount2 = new Double(1499.99);

     //      transaction.makeTransaction(card1, amount1, TransactionType.SALE);
     //      transaction.makeTransaction(card2, amount2, TransactionType.SALE);

     //      transaction.makeTransaction(card1, amount1, TransactionType.REFUND);

     //      Double shopFunds = shop.getIncomeReport();

     //      assertEquals(1499.99, shopFunds, 0);

     // }

     // @Test
     // public void testIfCard1IsDefault(){
     //      assertEquals(true, card1.defaultCard);
     // }

     // @Test
     // public void testIfCard2IsNotDefault(){
     //      assertEquals(false, card2.defaultCard);
     // }

     // @Test
     // public void canExtractDefaultCardFromPaymentOptions(){

     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      BankCard useThisCard = transaction.findDefaultCard(paymentOptions);

     //      assertEquals(useThisCard.defaultCard, true);
     // }

     // @Test
     // public void cardInstanceVariableIsTrue(){
     //      BankCard useThisCard = transaction.getDefaultCard();
     //      assertEquals(true, useThisCard.defaultCard);
     // }

     // @Test
     // public void makeTransactionUsesDefaultCard(){

     //      BankCard card = transaction.getDefaultCard();

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(amount1, TransactionType.SALE);

     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double newFunds = paymentOptions.get(card);

     //      assertEquals(9500.01, newFunds, 0);
     // }

     // @Test
     // public void makeTransactionUsesOptionalCard(){

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(card2, amount1, TransactionType.SALE);

     //      HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
     //      Double newFunds = paymentOptions.get(card2);

     //      assertEquals(2500.01, newFunds, 0);
     // }
     @Test
     public void makeTransactionUsesDefaultCard(){

          BankCard card = transaction.getDefaultCard();

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(amount1, TransactionType.REFUND);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card);

          assertEquals(10499.99, newFunds, 0);
     }

     @Test
     public void makeTransactionUsesOptionalCard(){

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(card2, amount1, TransactionType.REFUND);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card2);

          assertEquals(3499.99, newFunds, 0);
     }
}