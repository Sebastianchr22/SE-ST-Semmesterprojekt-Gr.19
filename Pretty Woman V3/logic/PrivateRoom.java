package logic;

import acq.ILogic;

public class PrivateRoom
{
    private ILogic logic;
    public double tipsGained(double bonus, double i)
    {
        double percentageBonusTip = 1 + logic.getPlayer().getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus + i) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }
    
    public void Match(Regular regular){
        //Boolean method to check if a regular and a player is a match:
        RegularPlayerMatch match = new RegularPlayerMatch(regular);
        
    }
    
    PrivateRoom(Regular regular){
        logic.setInPRoom(true);
        //If the regular is a minor, a raid might happen
        Chance chance = new Chance();
        if(regular.getAge() < 21){
            //Chance of police raid 50%:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                System.out.println("A police raid just happened and you just got busted dancing for a minor.");
                System.out.println("The police hand you a $500 fine, and you are being held at the police station over night.");
                System.out.println("You gained some experience from the raid, and from your arrest.");
                logic.getPlayer().removeMoney(500);
                logic.getPlayer().addExperience(0);
            }else{
                //Returned false:
                System.out.println("A police raid just happened, thankfully the police did not notice that you were dancing for a minor.");
                System.out.println("You gained some experience from that raid.");
                logic.getPlayer().addExperience(3);
                pRoomTips(250);
            }
            logic.setInPRoom(false);
        }else{
            //No razzia:
            //No minor:
            pRoomTips(100);
            Match(regular);
            logic.getPlayer().addExperience(3);
        }
    }
    public void pRoomTips(int bonus){
        double amount = Math.round((tipsGained(bonus, logic.getPlayer().getEnhancements()*6.5+350+bonus))*100.0)/100.0;
        logic.getPlayer().addMoney(amount);
        System.out.println("You gained $" + amount + " from dancing.");
    }
}
