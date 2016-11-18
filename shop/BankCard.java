package shop;
//import java.util.*;

public class BankCard implements Payable{
     
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
