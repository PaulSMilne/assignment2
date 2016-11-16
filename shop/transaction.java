package shop;
import java.util.*;

public class Transaction{

     public int id;
     private Customer customer;
     private Shop shop;
     private BankCard card;

     public Transaction(int id, Customer customer, Shop shop){
          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          BankCard defaultCard = findDefaultCard(paymentOptions);
          this.id = id;
          this.customer = customer;
          this.shop = shop;
          this.card = defaultCard;
     }

     // public Customer customer(){
     //      return this.customer;
     // }

     // public Shop getShop(){
     //      return this.shop;
     // }

     public BankCard getDefaultCard(){
          return this.card;
     }

     public void makeTransaction(BankCard card, double amount, TransactionType transaction){

          if (transaction == TransactionType.SALE){

               shop.updateSales(amount);
 
               customer.makePayment(card, amount);

          } 
          // else if (transaction == TransactionType.REFUND) {

          //      shop.updateRefunds(amount);

          //      double newCardFunds = currentCardFunds + amount;
          //      customer.setPaymentOptions(card, newCardFunds);
          // }
          
     }

     public void makeTransaction(double amount, TransactionType transaction){

          BankCard card = getDefaultCard();

          if (transaction == TransactionType.SALE){

               shop.updateSales(amount);

               customer.makePayment(card, amount);

          } 
          // else if (transaction == TransactionType.REFUND) {

          //      shop.updateRefunds(amount);

          //      double newCardFunds = currentCardFunds + amount;
          //      customer.setPaymentOptions(card, newCardFunds);
          // }
          
     }
     public BankCard findDefaultCard(HashMap<BankCard, Double> paymentOptions){
          for (BankCard card : paymentOptions.keySet()){
               if (card.defaultCard == true){
                    return card;
               }
               
          }return null;
     }
  

}