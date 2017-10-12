package PrettyWoman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebas
 */
public class SpilWorldOfZuul
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {   
        Regular sebastian = new Regular(0, "Sebastian", 22, "Swaggy", "boobs", 10, "ass", 10);
        System.out.println(sebastian.getPreferences());
        Game game = new Game();
        game.play();
        System.out.println(game.getName());
    }

}
