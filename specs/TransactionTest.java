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
     StockItem bear;

     Transaction transaction;

     @Before
     public void Before(){

          customer = new Customer("Zippy T. Pinhead");
          shop = new Shop("BearsRUrsus");
          bear = new StockItem("Dancing Bear");
          shop.addStock(bear, 2);
          
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card1.makeDefault();
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          
          customer.setPaymentOptions(card1, 10000.00);
          customer.setPaymentOptions(card2, 3000.00);
          
          transaction = new Transaction(customer, shop);
    }


     @Test
     public void saleTransfersCustomerFundsFromParticularCardToShop(){

          Double amount1 = new Double(499.99);
          Double amount2 = new Double(1499.99);

          transaction.makeTransaction(card1, bear, amount1, TransactionType.SALE);
          transaction.makeTransaction(card2, bear, amount2, TransactionType.SALE);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card1);
          assertEquals(9500.01, newFunds, 0);

          Double customerNewFunds = customer.getTotalFunds();
          assertEquals(11000.02, customerNewFunds, 0);

          Double salesFigures = shop.getSales();
          assertEquals(1999.98, salesFigures, 0);

          Double shopFunds = shop.getIncomeReport();
          assertEquals(1999.98, shopFunds, 0);
     }

     @Test
     public void refundPutsMoneyOnNominatedCard(){

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double card1Funds = paymentOptions.get(card1);

          assertEquals(10499.99, card1Funds, 0);
     }

     @Test
     public void refundAddsToShopRefundFigures(){

          Double amount1 = new Double(499.99);
          Double amount2 = new Double(1499.99);

          transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

          Double refundFigures = shop.getRefunds();

          assertEquals(499.99, refundFigures, 0);
     }

     @Test
     public void refundTakesFromTotalShopFunds(){

          Double amount1 = new Double(499.99);
          Double amount2 = new Double(1499.99);

          transaction.makeTransaction(card1, bear, amount1, TransactionType.SALE);
          transaction.makeTransaction(card2, bear, amount2, TransactionType.SALE);

          transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

          Double shopFunds = shop.getIncomeReport();

          assertEquals(1499.99, shopFunds, 0);

     }

     @Test
     public void testIfCard1IsDefault(){
          assertEquals(true, card1.defaultCard);
     }

     @Test
     public void testIfCard2IsNotDefault(){
          assertEquals(false, card2.defaultCard);
     }

     @Test
     public void canExtractDefaultCardFromPaymentOptions(){

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          BankCard useThisCard = transaction.findDefaultCard(paymentOptions);

          assertEquals(useThisCard.defaultCard, true);
     }

     @Test
     public void cardInstanceVariableIsTrue(){
          BankCard useThisCard = transaction.getDefaultCard();
          assertEquals(true, useThisCard.defaultCard);
     }

     @Test
     public void makeSaleUsesDefaultCard(){

          BankCard card = transaction.getDefaultCard();

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(bear, amount1, TransactionType.SALE);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card);

          assertEquals(9500.01, newFunds, 0);
     }

     @Test
     public void makeSaleUsesOptionalCard(){

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(card2, bear, amount1, TransactionType.SALE);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card2);

          assertEquals(2500.01, newFunds, 0);
     }
     @Test
     public void makeRefundUsesDefaultCard(){

          BankCard card = transaction.getDefaultCard();

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(bear, amount1, TransactionType.REFUND);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card);

          assertEquals(10499.99, newFunds, 0);
     }

     @Test
     public void makeRefundUsesOptionalCard(){

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(card2, bear, amount1, TransactionType.REFUND);

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card2);

          assertEquals(3499.99, newFunds, 0);
     }

     @Test 
     public void makeSaleReducesStockInStore(){
          Double amount1 = new Double(499.99);
          transaction.makeTransaction(bear, amount1, TransactionType.SALE);
          HashMap<StockItem, Integer> itemsInStock = shop.getStock();
          int dancingBearsInStock = itemsInStock.get(bear);
          assertEquals(1, dancingBearsInStock);          
     }

     @Test
     public void makeRefundIncreaseStockInStore(){
         Double amount1 = new Double(499.99);
         transaction.makeTransaction(bear, amount1, TransactionType.REFUND);
         HashMap<StockItem, Integer> itemsInStock = shop.getStock();
         int dancingBearsInStock = itemsInStock.get(bear);
         assertEquals(3, dancingBearsInStock);           
     }

     @Test
     public void makeSaleAddsStockToBasket(){
          Double amount1 = new Double(499.99);
          transaction.makeTransaction(bear, amount1, TransactionType.SALE);
          ArrayList<StockItem> currentBasket = customer.getBasket();
          int amountInBasket = currentBasket.size();
          assertEquals(1, amountInBasket);
     }
}