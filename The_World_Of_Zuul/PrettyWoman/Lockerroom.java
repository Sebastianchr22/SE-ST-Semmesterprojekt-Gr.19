package PrettyWoman;

public class Lockerroom {

    public int genRandom(Driver driver) {
        int lenght = driver.itemlist.countItems() - 1;
        System.out.println("List lenght: " + lenght);
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
            System.out.println("You found a " + driver.itemlist.get(random).getName());
            if (driver.inv.checkCapacity(driver.itemlist.get(random))) {
                driver.inv.addToInventory(driver.itemlist.get(random));
                driver.itemlist.removeItem(driver.itemlist.get(random));
                System.out.println("");
            } else {
                System.out.println("");
            }
        } else {
            System.out.println("There is nothing here to steal.");
        }
    }
}
