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
public class Player {
    String name;
    private Field field;
    
    public Player(String name, Field field){
        this.name = name;
        this.field = field;
        System.out.println(name + "starter på felt: " + field);
    }
    
    public void move(Dice dice){
        boolean rollAgain = true;
        while(rollAgain){
            int steps = dice.throwDice();
            int currentPos = (field.getPos() - 1 + steps) % Matador.board.length;
            field = Matador.board[currentPos];
            System.out.println(name + " rolled " + steps + " and landed on " + field);
            rollAgain = dice.isEqual();    
        }
        
    }
    
}
