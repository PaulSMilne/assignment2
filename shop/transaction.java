package shop;
import java.util.*;

public class Transaction{

     private Customer customer;
     private Shop shop;
     private BankCard card;

     public Transaction(Customer customer, Shop shop){
          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          BankCard defaultCard = findDefaultCard(paymentOptions);
          this.customer = customer;
          this.shop = shop;
          this.card = defaultCard;
     }

     public BankCard findDefaultCard(HashMap<BankCard, Double> paymentOptions){
          for (BankCard card : paymentOptions.keySet()){
               if (card.defaultCard == true){
                    return card;
               } 
          } return null;
     }

     public BankCard getDefaultCard() { return this.card; }

// OVERLOAD makeTransaction method to take a bank card or 
// to use the default card if no card is passed in 
// the method signature.

     public void makeTransaction(StockItem purchase, double amount, TransactionType transaction){
          BankCard card = getDefaultCard();

          if (transaction == TransactionType.SALE){
               shop.updateSales(amount);
               shop.sellItem(purchase);
               customer.makePayment(card, amount);
               customer.addToBasket(purchase);

          } else if (transaction == TransactionType.REFUND) {
               shop.updateRefunds(amount);
               shop.updateStock(purchase, 1);
               customer.receiveRefund(card, amount);
               customer.removeFromBasket(purchase);
          }
     }

     public void makeTransaction(BankCard card, StockItem purchase, double amount, TransactionType transaction){

          if (transaction == TransactionType.SALE){
               shop.updateSales(amount);
               shop.sellItem(purchase);
               customer.makePayment(card, amount);
               customer.addToBasket(purchase);

          } else if (transaction == TransactionType.REFUND) {
               shop.updateRefunds(amount);
               shop.updateStock(purchase, 1);
               customer.receiveRefund(card, amount);
               customer.removeFromBasket(purchase);
          }
     }

}