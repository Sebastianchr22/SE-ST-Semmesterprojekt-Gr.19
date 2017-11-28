package logic;

import acq.ILogic;

public class BuyFromHome {

    private ILogic logic;
    int enhancementPrice = 150;
    int foodPrice = 100;
    private Player player;

    public void printOptions() {
        System.out.println("You can now buy:");
        System.out.println("1x 'Enhancements' to make more money for $" + enhancementPrice + ", and also increases days left before retirement" +".");
        System.out.println("10x 'Food' for your daughter for $" + foodPrice + ".");
    }
    BuyFromHome(Player playerStats){
        printOptions();
    }
    BuyFromHome(Command command) {  
        player = logic.getPlayer();
        if (command.hasSecondWord()) {
            String option = command.getSecondWord();
            switch (option) {
                case "enhancements":
                    if (player.getMoneySaved() >= enhancementPrice) {
                        player.addEnhancements(1);
                        player.addDaysLeft(1);
                        player.removeMoney(enhancementPrice);
                        System.out.println("You bought an enhancement.");
                    } else {
                        System.out.println("You do not have enough money.");
                    }
                    break;
                case "food":
                    if (player.getMoneySaved() >= foodPrice) {
                        if(player.getHunger() <= 100){
                            player.addHunger(10);
                            player.removeMoney(foodPrice);
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
        logic.setPlayer(player);
    }
}
