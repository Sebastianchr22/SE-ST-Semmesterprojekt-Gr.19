/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matador;

/**
 *
 * @author Abdi
 */
public class Dice {
    
    private Die die1;
    private Die die2;
    private int roll1;
    private int roll2;
    
    
    Dice(){
        die1 = new Die(6);
        die2 = new Die(6);
    }
    
    public int throwDice(){
        roll1 = die1.throwDice();
        roll2 = die2.throwDice();
       return roll1 + roll2;
    }
    public boolean isEqual(){
        return roll1 == roll2;
    }
    
    
    public static void main(String[] args){
        Dice dice = new Dice();
        for (int i = 0; i < 5; i++) {
            System.out.print("roll: " + dice.throwDice());
            System.out.println(" " + dice.isEqual());
        }
    }

}
