package shop;
//import java.util.*;

public class DebitCard extends Card{
     
     private String bank;
     //private CardType cardType;
     //public boolean defaultState;

     public DebitCard(String bank, CardType cardType){
          this.bank = bank;
          this.cardType = cardType;
          this.defaultState = false;
     }

}
