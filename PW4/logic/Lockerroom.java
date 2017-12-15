package logic;

import acq.ILogic;

public class Lockerroom {

    private static ILogic logic;
    private int length;
    private Inventory inv;
    private ItemList itemlist;
    private Player player;

    /**
     * Returns a random number between 1, and the lenght of the list (itemList).
     * This means that we will get the item at the specific index.
     * @return int : random
     */
    public int genRandom() {
        if (length > 1) {
            return (int) Math.round(1 + Math.random() * length);
        } else {
            return 0;
        }
    }

    /**
     * The method will find an item, at a random index in the itemlist.
     * And return feedback to the player, about which item the player found.
     * No moves are removed from the player, when this is called.
     * Also it is checked if the player can carry the given item, according to the capacity of the inventory.
     * @param inventory : gotten from logic facade
     * @param itemlists : gotten from logic facade
     * @return feedback : String
     */
    public String Lockerroom(Inventory inventory, ItemList itemlists) {
        logic = LogicFacade.getInstance();
        inv = inventory;

        length = logic.getItemList().size() - 1;
        itemlist = itemlists;
        player = logic.getPlayer();

        if (length >= 1) {
            int random = genRandom();
            System.out.println("");
            Item found = itemlist.get(random);
            
            if (inv.checkCapacity(found) && found != null) {
                inv.addToList(found);
                itemlist.removeFromList(found);
                System.out.println("");
                return "You found a(n) " + found.getName();

            } else {
                System.out.println("");
                player.addMoves(1);
            }
        } else {
            player.addMoves(1);
            return "There is nothing here to steal.";

        }
        logic.setInventory(inv);
        logic.setItemList(itemlist);
        logic.setPlayer(player);
        return "You cannot carry anymore";
    }
}
