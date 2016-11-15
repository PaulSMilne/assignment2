package shop;

public enum CardType{
     VISA_DEBIT("Visa Debit Card"),
     VISA_CREDIT("Visa Credit Card"),
     MASTERCARD_DEBIT("Mastercard Debit Card"),
     MASTERCARD_CREDIT("Mastercard Credit Card"),
     CREDIT("Credit Card"),
     DEBIT("Debit Card");

     public String textType;

     CardType(String textType){
          this.textType = textType;
     }
}