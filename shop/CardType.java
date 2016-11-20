package shop;

public enum CardType{
     VISA_DEBIT("debit"),
     VISA_CREDIT("credit"),
     MASTERCARD_DEBIT("debit"),
     MASTERCARD_CREDIT("credit"),
     AMERICAN_EXPRESS_CREDIT("credit"),
     DINERS_CLUB_CREDIT("credit");

     private final String type;

     CardType(String type){
          this.type = type;
     }

     public String getType(){
          return this.type;
     }
}
