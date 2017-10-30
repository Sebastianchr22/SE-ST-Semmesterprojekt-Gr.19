package PrettyWoman;

public class BuyFromHome {

    int enhancementPrice = 150;
    int foodPrice = 100;

    public void printOptions() {
        System.out.println("You can now buy:");
        System.out.println("1x 'Enhancements' to make more money for $" + enhancementPrice + ".");
        System.out.println("10x 'Food' for your daughter for $" + foodPrice + ".");
    }
    BuyFromHome(PlayerStats playerStats){
        printOptions();
    }
    BuyFromHome(Driver driver, Command command) {
        if (command.hasSecondWord()) {
            String option = command.getSecondWord();
            switch (option) {
                case "enhancements":
                    if (driver.playerStats.getMoneySaved() >= enhancementPrice) {
                        driver.playerStats.addEnhancements(1);
                        driver.playerStats.removeMoneySaved(enhancementPrice);
                        System.out.println("You bought an enhancement.");
                    } else {
                        System.out.println("You do not have enough money.");
                    }
                    break;
                case "food":
                    if (driver.playerStats.getMoneySaved() >= foodPrice) {
                        if(driver.playerStats.addHunger(10)){
                            driver.playerStats.removeMoneySaved(foodPrice);
                            System.out.println("You bought some food.");
                        }else{
                            System.out.println("Your is not hungry.");
                        }
                    } else {
                        System.out.println("You do not have enought money.");
                    }
                    break;
                default:
                    System.out.println("Not a known option.");
                    break;
            }
        }else{
            System.out.println("Buy what?");
        }
    }
}
