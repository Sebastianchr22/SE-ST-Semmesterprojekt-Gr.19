package logic;


public class Lockerroom {

    private acq.ILogic logic;
    private int length = logic.getItemList().size() - 1;
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

    Lockerroom() {
        inv.Inventory = logic.getInventory();
        itemlist.itemList = logic.getItemList();
        player = logic.getPlayer();
        
        if (length >= 1) {
            int random = genRandom();
            System.out.println("");
            Item found = itemlist.get(random);
            if (inv.checkCapacity(found)) {
                System.out.println("You found a(n) " + found.getName());
                inv.addToList(found);
                itemlist.removeFromList(found);
                System.out.println("");
            } else {
                System.out.println("");
                player.addMoves(1);
            }
        } else {
            System.out.println("There is nothing here to steal.");
            player.addMoves(1);
        }
        logic.setInventory(inv);
        logic.setItemList(itemlist);
        logic.setPlayer(player);
    }
}
