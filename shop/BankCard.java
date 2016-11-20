package shop;
//import java.util.*;

public class BankCard extends Card{
     
     private String lender;
     //private CardType cardType;
     //public boolean defaultState;

     public BankCard(String lender, CardType cardType){
          this.lender = lender;
          this.cardType = cardType;
          this.defaultState = false;
     }

     public String getLender(){
          return this.lender;
     }






}
