package PrettyWoman;

public class PrivateRoom
{
    public double tipsGained(double bonus, Driver driver, double i)
    {
        double percentageBonusTip = 1 + driver.playerStats.getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus + i) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }
    
    public void Match(Driver driver, Regular regular){
        //Boolean method to check if a regular and a player is a match:
        RegularPlayerMatch match = new RegularPlayerMatch();
        match.RegularPlayerMatch(driver, regular);
    }
    
    PrivateRoom(Driver driver, Regular regular){
        
        //If the regular is a minor, a raid might happen
        Chance chance = new Chance();
        if(regular.getAge() < 21){
            //Chance of police raid 50%:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                System.out.println("A police raid just happened and you just got busted dancing for a minor.");
                System.out.println("The police hand you a $500 fine, and you are being held at the police station over night.");
                System.out.println("You gained some experience from the raid, and from your arrest.");
                driver.playerStats.removeMoneySaved(500);
                driver.playerStats.addExperience(0);
            }else{
                //Returned false:
                System.out.println("A police raid just happened, thankfully the police did not notice that you were dancing for a minor.");
                System.out.println("You gained some experience from that raid.");
                driver.playerStats.addExperience(3);
                pRoomTips(250, driver);
            }
        }else{
            //No razzia:
            //No minor:
            Match(driver, regular);
            pRoomTips(0, driver);
            driver.playerStats.addExperience(3);
        }
    }
    public void pRoomTips(int bonus, Driver driver){
        double amount = Math.round((tipsGained(bonus, driver, driver.playerStats.getEnhancements()*6.5+350+bonus))*100.0)/100.0;
        driver.playerStats.addMoneySaved(amount);
        System.out.println("You gained $" + amount + " from dancing.");
    }
}
