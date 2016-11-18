import static org.junit.Assert.*;
import org.junit.*;
import shop.*;
//import behaviours.*;


public class BankCardTest {

     BankCard bankCard;

     @Before
     public void before(){
          bankCard = new BankCard("Barclays", CardType.VISA_DEBIT);
     }

     @Test
     public void canGetNameOfBank(){

          String bankName = bankCard.getBank();

          assertEquals("Barclays", bankName);
     }

     @Test
     public void canGetCardType(){

          CardType type = bankCard.getCardType();

          assertEquals(CardType.VISA_DEBIT, type);
     }


     @Test
     public void canChangeDefaultState(){
          bankCard.makeDefault();
          assertEquals(true, bankCard.defaultState);
     }
}
