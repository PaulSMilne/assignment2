import static org.junit.Assert.*;
import org.junit.*;
import shop.*;
//import behaviours.*;


public class CreditCardTest {

     CreditCard card;

     @Before
     public void before(){
          card = new CreditCard("Barclays", CardType.VISA_CREDIT);
     }

     @Test
     public void canGetNameOfLender(){

          String lenderName = card.getLender();

          assertEquals("Barclays", lenderName);
     }

     @Test
     public void canGetCardType(){

          CardType type = card.getCardType();

          assertEquals(CardType.VISA_CREDIT, type);
     }


     @Test
     public void canChangeDefaultState(){
          card.makeDefault();
          assertEquals(true, card.defaultState);
     }
}
