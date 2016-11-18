package shop;
import java.util.*;

public class Transaction{

     private Customer customer;
     private Shop shop;
     private Payable paymentMethod;

     public Transaction(Customer customer, Shop shop){
          HashMap<Payable, Double> paymentOptions = customer.getPaymentOptions();
          Payable defaultPaymentMethod = findDefaultPaymentMethod(paymentOptions);
          this.customer = customer;
          this.shop = shop;
          this.paymentMethod = defaultPaymentMethod;
     }

     public Payable findDefaultPaymentMethod(HashMap<Payable, Double> paymentOptions){
          for (Payable paymentMethod : paymentOptions.keySet()){
               boolean defaultState = paymentMethod.getDefaultState();
               if (defaultState == true){
                    return paymentMethod;
               } 
          } return null;
     }

     public Payable getDefaultPaymentMethod() { return this.paymentMethod; }

// OVERLOAD makeTransaction method to take a payment method or 
// to use the default payment method if no payment method is passed in 
// the method signature.

     public void makeTransaction(StockItem purchase, double amount, TransactionType transaction){
          Payable paymentMethod = getDefaultPaymentMethod();

          if (transaction == TransactionType.SALE){
               shop.updateSales(amount);
               shop.sellItem(purchase);
               customer.makePayment(paymentMethod, amount);
               customer.addToBasket(purchase);

          } else if (transaction == TransactionType.REFUND) {
               shop.updateRefunds(amount);
               shop.updateStock(purchase, 1);
               customer.receiveRefund(paymentMethod, amount);
               customer.removeFromBasket(purchase);
          }
     }

     public void makeTransaction(Payable paymentMethod, StockItem purchase, double amount, TransactionType transaction){

          if (transaction == TransactionType.SALE){
               shop.updateSales(amount);
               shop.sellItem(purchase);
               customer.makePayment(paymentMethod, amount);
               customer.addToBasket(purchase);

          } else if (transaction == TransactionType.REFUND) {
               shop.updateRefunds(amount);
               shop.updateStock(purchase, 1);
               customer.receiveRefund(paymentMethod, amount);
               customer.removeFromBasket(purchase);
          }
     }

}
