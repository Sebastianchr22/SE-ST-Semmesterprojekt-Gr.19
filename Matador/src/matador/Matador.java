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
import java.util.Arrays;

public class Matador {
    public static Field[] board = new Field[40];
    
    private Dice dice = new Dice();
    
    public void fillBoard(){
        for (int i = 0; i < board.length; i++) {
            board[i] = new Field("Field" + (i + 1), i + 1);
        }
        System.out.println("Board: " + Arrays.toString(board));
    }
    
    public void play(){
        Player p1 = new Player("Mig ", board[0]);
        Player p2 = new Player("Dig ", board[0]);
        
        for (int i = 0; i < 20; i++) {
            p1.move(dice);
            p2.move(dice);
        }
    }


    public static void main(String[] args) {
        Matador driver = new Matador();
        driver.fillBoard();
        driver.play();
        
       
    }
    
}
