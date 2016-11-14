package shop;
import java.util.*;

public class BankCard {
     
     private String bank;
     private CardType cardType;
     private String textType;

     public BankCard(String bank, CardType cardType){
          this.bank = bank;
          this.cardType = cardType;
          this.textType = cardType.textType;
     }

     public String getBank(){
          return this.bank;
     }

     public CardType getCardType(){
          return this.cardType;
     }

     public String getTextType(){
          return this.textType;
     }

     public String getCardName(){
          String cardName = this.bank + " " + getTextType();
          return cardName;
     }



}
