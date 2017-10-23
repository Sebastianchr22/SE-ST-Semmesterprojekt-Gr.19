package PrettyWoman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Sleaf
 */
public class Home {
    
    public Scanner HomeChoice;
    
    public Home(){
        HomeChoice = new Scanner(System.in);
    }
    
    public boolean GoHome(){
        System.out.println("You are tired and out of moves for today, so you walk home");
        System.out.println("On your way home you have time to do one of the following things:");
        System.out.println("1. Buy food (so that daugther won't starve)");
        System.out.println("2. Buy improvements (to make more money)");
        System.out.println("3. Go back to work");
        System.out.println("Your choice: ");
        int ChoiceInput = HomeChoice.nextInt();
        
        while(true){
            if(ChoiceInput == 1){
                System.out.println("You bought food your your daugther");
            }
            if(ChoiceInput == 2){
                System.out.println("You bought improvements");
            }
            if(ChoiceInput == 3){
                System.out.println("You went back to work");
                break;
            }
            else{                
            }
        }
        return true;
    }
    
    
}
