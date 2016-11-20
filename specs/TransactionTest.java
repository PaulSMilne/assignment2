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
     Emoney emoney1;

     Transaction transaction;

     @Before
     public void Before(){

          customer = new Customer("Zippy T. Pinhead", 10000.00);
          shop = new Shop("BearsRUrsus");
          bear = new StockItem("Dancing Bear");
          shop.addStock(bear, 2);
          
          card1 = new BankCard("Barclays", CardType.VISA_DEBIT);
          card2 = new BankCard("Bank of Scotland", CardType.MASTERCARD_CREDIT);
          emoney1 = new Emoney("Paypal");
          emoney1.makeDefault();
          
          customer.setPaymentOptions(card1, 10000.00);
          customer.setPaymentOptions(card2, 3000.00);
          customer.setPaymentOptions(emoney1, 10000.00);
          
          transaction = new Transaction(customer, shop);
    }


     @Test
     public void canExtractDefaultOptionFromPaymentOptions(){

          HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
          Payable useThisCard = transaction.findDefaultPaymentMethod(paymentOptions);
          boolean state = useThisCard.getDefaultState();
          assertEquals(true, state);
     }

     @Test
     public void defaultCardDefaultStateIsTrue(){
          Payable useThisCard = transaction.getDefaultPaymentMethod();
          boolean state = useThisCard.getDefaultState();
          assertEquals(true, state);
     }

     @Test
     public void testIfPaypalIsDefault(){
          boolean state = emoney1.getDefaultState();
          assertEquals(true, state);
     }

     @Test
     public void testIfCard1IsNotDefault(){
          boolean state = card1.getDefaultState();
          assertEquals(false, state);
     }

     @Test
     public void makeSaleUseDefaultCard(){

          Payable defaultPayment = transaction.getDefaultPaymentMethod();

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(bear, amount1, TransactionType.SALE);

          HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(defaultPayment);

          assertEquals(9500.01, newFunds, 0);
     }

     @Test
     public void makeSaleUsesOptionalCard(){

          Double amount1 = new Double(499.99);

          transaction.makeTransaction(card2, bear, amount1, TransactionType.SALE);

          HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card2);

          assertEquals(2500.01, newFunds, 0);
     }
          @Test
     public void saleTransfersCustomerFundsFromParticularCardToShop(){

          Double amount1 = new Double(499.99);
          Double amount2 = new Double(1499.99);

          transaction.makeTransaction(bear, amount1, TransactionType.SALE);
          transaction.makeTransaction(card2, bear, amount2, TransactionType.SALE);

          HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
          Double newFunds = paymentOptions.get(card2);
          assertEquals(1500.01, newFunds, 0);

          Double customerNewFunds = customer.getTotalFunds();
          assertEquals(21000.02, customerNewFunds, 0);

          // Double salesFigures = shop.getSales();
          // assertEquals(1999.98, salesFigures, 0);

          // Double shopFunds = shop.getIncomeReport();
          // assertEquals(1999.98, shopFunds, 0);
     }

     // @Test
     // public void refundPutsMoneyOnNominatedCard(){

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

     //      HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
     //      Double card1Funds = paymentOptions.get(card1);

     //      assertEquals(10499.99, card1Funds, 0);
     // }

     // @Test
     // public void refundAddsToShopRefundFigures(){

     //      Double amount1 = new Double(499.99);
     //      Double amount2 = new Double(1499.99);

     //      transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

     //      Double refundFigures = shop.getRefunds();

     //      assertEquals(499.99, refundFigures, 0);
     // }

     // @Test
     // public void refundTakesFromTotalShopFunds(){

     //      Double amount1 = new Double(499.99);
     //      Double amount2 = new Double(1499.99);

     //      transaction.makeTransaction(card1, bear, amount1, TransactionType.SALE);
     //      transaction.makeTransaction(card2, bear, amount2, TransactionType.SALE);

     //      transaction.makeTransaction(card1, bear, amount1, TransactionType.REFUND);

     //      Double shopFunds = shop.getIncomeReport();

     //      assertEquals(1499.99, shopFunds, 0);

     // }

    // @Test
     // public void makeRefundUsesDefaultCard(){

     //      Payable card = transaction.getDefaultCard();

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(bear, amount1, TransactionType.REFUND);

     //      HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
     //      Double newFunds = paymentOptions.get(card);

     //      assertEquals(10499.99, newFunds, 0);
     // }

     // @Test
     // public void makeRefundUsesOptionalCard(){

     //      Double amount1 = new Double(499.99);

     //      transaction.makeTransaction(card2, bear, amount1, TransactionType.REFUND);

     //      HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
     //      Double newFunds = paymentOptions.get(card2);

     //      assertEquals(3499.99, newFunds, 0);
     // }

     // @Test 
     // public void makeSaleReducesStockInStore(){
     //      Double amount1 = new Double(499.99);
     //      transaction.makeTransaction(bear, amount1, TransactionType.SALE);
     //      HashMap<StockItem, Integer> itemsInStock = shop.getStock();
     //      int dancingBearsInStock = itemsInStock.get(bear);
     //      assertEquals(1, dancingBearsInStock);          
     // }

     // @Test
     // public void makeRefundIncreaseStockInStore(){
     //     Double amount1 = new Double(499.99);
     //     transaction.makeTransaction(bear, amount1, TransactionType.REFUND);
     //     HashMap<StockItem, Integer> itemsInStock = shop.getStock();
     //     int dancingBearsInStock = itemsInStock.get(bear);
     //     assertEquals(3, dancingBearsInStock);           
     // }

     // @Test
     // public void makeSaleAddsStockToBasket(){
     //      Double amount1 = new Double(499.99);
     //      transaction.makeTransaction(bear, amount1, TransactionType.SALE);
     //      ArrayList<StockItem> currentBasket = customer.getBasket();
     //      int amountInBasket = currentBasket.size();
     //      assertEquals(1, amountInBasket);
     // }

     // @Test
     // public void makeRefundTakesStockFromBasket(){
     //      Double amount1 = new Double(499.99);
     //      transaction.makeTransaction(bear, amount1, TransactionType.SALE);
     //      transaction.makeTransaction(bear, amount1, TransactionType.REFUND);
     //      ArrayList<StockItem> currentBasket = customer.getBasket();
     //      int amountInBasket = currentBasket.size();
     //      assertEquals(0, amountInBasket);
     // }
}