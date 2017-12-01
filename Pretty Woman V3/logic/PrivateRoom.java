package logic;

import acq.ILogic;
import acq.IRegular;

public class PrivateRoom
{
    private ILogic logic;
    public double tipsGained(double bonus, double i)
    {
        double percentageBonusTip = 1 + logic.getPlayer().getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus + i) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }
    
    public String Match(IRegular regular){
        //Boolean method to check if a regular and a player is a match:
        RegularPlayerMatch match = new RegularPlayerMatch();
        return match.RegularPlayerMatch(regular);
    }
    
    public String PrivateRoom(){
        String val = "";
        logic = LogicFacade.getInstance();
        logic.setInPRoom(true);
        //If the regular is a minor, a raid might happen
        Chance chance = new Chance();
        if(logic.getRegularInRoom().getAge() < 21){
            //Chance of police raid 50%:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                val+="A police raid just happened and you just got busted dancing for a minor.";
                val+="The police hand you a $500 fine, and you are being held at the police station over night.";
                val+="You gained some experience from the raid, and from your arrest.";
                logic.getPlayer().removeMoney(500);
                logic.getPlayer().addExperience(0);
                logic.setRegularInRoom(null);
                logic.setPrivateRoomCommand(null);
                logic.setPRoomInvite(false);
            }else{
                //Returned false:
                val+="A police raid just happened, thankfully the police did not notice that you were dancing for a minor.";
                val+="You gained some experience from that raid.";
                logic.getPlayer().addExperience(3);
                val+=pRoomTips(250);
                logic.setRegularInRoom(null);
                logic.setPrivateRoomCommand(null);
                logic.setPRoomInvite(false);
            }
            logic.setInPRoom(false);
        }else{
            //No razzia:
            //No minor:
            val+=pRoomTips(100);
            val += Match(logic.getRegularInRoom());
            logic.getPlayer().addExperience(3);
        }
        return val;
    }
    public String pRoomTips(int bonus){
        double amount = Math.round((tipsGained(bonus, logic.getPlayer().getEnhancements()*6.5+350+bonus))*100.0)/100.0;
        logic.getPlayer().addMoney(amount);
        return "You gained $" + amount + " from dancing.";
    }
}
