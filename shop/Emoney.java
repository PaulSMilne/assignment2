package shop;
//import java.util.*;

public class Emoney implements Payable{
     private String name;
     public boolean defaultState;

     public Emoney(String name){
     this.name = name;
     this.defaultState = false;
     }

     public String getName(){
          return this.name;
     }

     public boolean getDefaultState(){
          return this.defaultState;
     }

     public void makeDefault(){
          this.defaultState = true;
     }
}