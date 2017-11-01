package PrettyWoman;

public class Lockerroom {

    public int genRandom(Driver driver) {
        int lenght = driver.itemlist.countItems() - 1;
        if (lenght > 1) {
            return (int) Math.round(1 + Math.random() * lenght);
        } else {
            return 0;
        }
    }

    Lockerroom(Driver driver) {
        if (driver.itemlist.countItems() >= 1) {
            int random = genRandom(driver);
            System.out.println("");
            if (driver.inv.checkCapacity(driver.itemlist.get(random))) {
                System.out.println("You found a(n) " + driver.itemlist.get(random).getName());
                driver.inv.addToInventory(driver.itemlist.get(random));
                driver.itemlist.removeItem(driver.itemlist.get(random));
                System.out.println("");
            } else {
                System.out.println("");
                driver.playerStats.addMoves(1);
            }
        } else {
            System.out.println("There is nothing here to steal.");
            driver.playerStats.addMoves(1);
        }
    }
}
