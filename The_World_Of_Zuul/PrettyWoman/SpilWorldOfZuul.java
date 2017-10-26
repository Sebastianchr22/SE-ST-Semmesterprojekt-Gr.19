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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Regulars reg =new Regulars();
        ArrayList<Regular> regularList = new ArrayList<>();
        ListOfRegulars list = new ListOfRegulars(regularList);
        
        //reg.createReglist(list);
        Game game = new Game();
        game.play();
        System.out.println(game.getName());
    }

}
