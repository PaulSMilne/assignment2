package shop;
import java.util.*;

public class Transaction{

     public int id;
     private Customer customer;
     private Shop shop;
     private BankCard card;

     public Transaction(int id, Customer customer, Shop shop){
          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          BankCard useThisCard = findDefaultCard(paymentOptions);
          this.id = id;
          this.customer = customer;
          this.shop = shop;
          this.card = useThisCard;
     }

     public Customer getCustomer(){
          return this.customer;
     }

     public Shop getShop(){
          return this.shop;
     }

     public BankCard getCard(){
          return this.card;
     }

     public void makeTransaction(BankCard card, Double amount, TransactionType transaction){

          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double currentCardFunds = paymentOptions.get(card);

          if (transaction == TransactionType.SALE){

               shop.updateSales(amount);

               Double newCardFunds = currentCardFunds - amount;
               customer.setPaymentOptions(card, newCardFunds);

          } else if (transaction == TransactionType.REFUND) {

               shop.updateRefunds(amount);

               Double newCardFunds = currentCardFunds + amount;
               customer.setPaymentOptions(card, newCardFunds);
          }
          
     }

     public void makeTransaction(Double amount, TransactionType transaction){

          BankCard card = getCard();
          HashMap<BankCard, Double> paymentOptions = customer.getPaymentOptions();
          Double currentCardFunds = paymentOptions.get(card);

          if (transaction == TransactionType.SALE){

               shop.updateSales(amount);

               Double newCardFunds = currentCardFunds - amount;
               customer.setPaymentOptions(card, newCardFunds);

          } else if (transaction == TransactionType.REFUND) {

               shop.updateRefunds(amount);

               Double newCardFunds = currentCardFunds + amount;
               customer.setPaymentOptions(card, newCardFunds);
          }
          
     }
     public BankCard findDefaultCard(HashMap<BankCard, Double> paymentOptions){
          for (Map.Entry<BankCard, Double> entry : paymentOptions.entrySet()){
               BankCard card = entry.getKey();
               if (card.defaultCard == true){
                    return card;
               }
               
          }return null;
     }
  

}