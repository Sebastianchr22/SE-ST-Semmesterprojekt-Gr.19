package PrettyWoman;
import java.math.*;
public class PrivateRoom extends DanceMech
{
    PlayerStats playerStats = new PlayerStats();
    
    public void pRoomTips(){
        double amount = Math.round((tipsGained(playerStats.getEnhancements())*3.3+500)*100.0)/100.0;
        System.out.println("You gained $" + amount + " from dancing.");
        playerStats.addMoneySaved(amount);
    }
    public void privateRoomInvite(Regular regular){
        if(regular.getAge() < 18){
            //Razzia might happen:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                System.out.println("A police raid just happened and you just got busted dancing for minor.");
                System.out.println("The police hand you a $500 fine, and you are being held at the police station over night.");
                System.out.println("You gained some experience from the raid, and from your arrest.");
                playerStats.removeMoneySaved(500);
                playerStats.addExperience(3);
            }else{
                //Returned false:
                System.out.println("A police raid just happened, thankfully the police did not notice that you were dancing for a minor.");
                pRoomTips();
            }
        }else{
            //No razzia:
            pRoomTips();
        }
    }
}
