package shop;
//import java.util.*;

public class BankCard {
     
     private String bank;
     private CardType cardType;
     public boolean defaultCard;

     public BankCard(String bank, CardType cardType){
          this.bank = bank;
          this.cardType = cardType;
          this.defaultCard = false;
     }

     public String getBank(){
          return this.bank;
     }

     public CardType getCardType(){
          return this.cardType;
     }

     public void makeDefault(){
          this.defaultCard = true;
     }



}
