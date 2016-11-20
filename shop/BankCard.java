package shop;
//import java.util.*;

public class BankCard extends Card{
     
     private String bank;
     private CardType cardType;
     public boolean defaultState;

     public BankCard(String bank, CardType cardType){
          this.bank = bank;
          this.cardType = cardType;
          this.defaultState = false;
     }

     public String getBank(){
          return this.bank;
     }

     public CardType getCardType(){
          return this.cardType;
     }

     public boolean getDefaultState(){
          return this.defaultState;
     }

     public void makeDefault(){
          this.defaultState = true;
     }




}
