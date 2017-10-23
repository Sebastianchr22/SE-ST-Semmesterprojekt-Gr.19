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

public class SpilWorldOfZuul {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
       Inventory inv = new Inventory();
       Item item = new Item();
       createItems items = new createItems();
       item.createInventory();
       //Item goldring = new Item(0, "Gold Ring", "A nice gold ring", "Gold");
       //inv.addToIventory(goldring);
       item.createStartInv();
       inv.showInventory();
       
       Game game = new Game();
       game.play();
    }
}
