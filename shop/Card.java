package shop;

public abstract class Card implements Payable {
     public CardType cardType;
     public boolean defaultState;

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