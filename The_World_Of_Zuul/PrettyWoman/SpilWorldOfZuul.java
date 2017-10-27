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

    Regulars reg = new Regulars();
    ArrayList<Regular> regularList = new ArrayList<>();
    ListOfRegulars reglist = new ListOfRegulars(regularList);

    public void createRList()
    {
        reg.createReglist(reglist);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        Regulars reg = new Regulars();
//        ArrayList<Regular> regularList = new ArrayList<>();
//        ListOfRegulars reglist = new ListOfRegulars(regularList);
//        reg.createReglist(reglist);
        SpilWorldOfZuul create = new SpilWorldOfZuul();
        create.createRList();
        Game game = new Game(create.reglist, create.reg);
        game.play();
        System.out.println(game.getName());
    }

}
