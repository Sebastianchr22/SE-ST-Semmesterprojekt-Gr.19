package logic;

import acq.ILogic;

public class Lockerroom {

    private static ILogic logic;
    private int length;
    private Inventory inv;
    private ItemList itemlist;
    private Player player;

    public int genRandom() {
        if (length > 1) {
            return (int) Math.round(1 + Math.random() * length);
        } else {
            return 0;
        }
    }

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
            if (inv.checkCapacity(found)) {
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
        return "error";
    }
}
