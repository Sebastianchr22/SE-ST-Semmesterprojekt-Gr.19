package PrettyWoman;

import java.util.ArrayList;

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
    public static void main(String[] args)
    {
        Driver driver = new Driver();
        Game game = new Game(driver);
        game.play(driver);
        System.out.println(game.getName());
    }

}
