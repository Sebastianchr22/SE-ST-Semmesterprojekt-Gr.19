/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebas
 */
import java.util.Scanner;
import worldofzuul.Game;

public class SpilWorldOfZuul
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random risk = new Random();
        Game game = new Game();
        game.play();
    }

}
