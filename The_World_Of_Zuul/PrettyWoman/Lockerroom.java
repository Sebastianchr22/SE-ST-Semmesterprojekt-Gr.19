package PrettyWoman;
public class Lockerroom {
    public int genRandom(Driver driver){
        return (int) Math.round(0+Math.random()*driver.itemlist.countItems());
    }
    Lockerroom(Driver driver){
        int random = genRandom(driver);
        System.out.println("");
        System.out.println("You found a "+driver.itemlist.get(random).getName());
        driver.inv.addToInventory(driver.itemlist.get(random));
        System.out.println("");
        driver.itemlist.removeItem(driver.itemlist.get(random));
        System.out.println("");
        driver.itemlist.showItemList();
    }
}
