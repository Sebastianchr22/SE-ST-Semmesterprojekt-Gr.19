package PrettyWoman;

public class PrivateRoom
{
    public double tipsGained(double bonus, PlayerStats playerStats)
    {
        double percentageBonusTip = 1 + playerStats.getEnhancements() * 0.05;//Calculates a percentage of bonus based on improvements
        double tips = 5.0 + Math.random() * 30.0;//Calculates a random number between 5 to 30
        return Math.round((percentageBonusTip * tips + bonus) * 100.0) / 100.0; //Returns the random* the percentage, rounded off with two digits after the comma.
    }
    
    public void Match(Inventory inv,Regular regular, PlayerStats playerstats, ListOfRegulars reglist){
        //Boolean method to check if a regular and a player is a match:
        RegularPlayerMatch match = new RegularPlayerMatch();
        match.RegularPlayerMatch(inv, regular, playerstats, reglist);
    }
    
    public void privateRoomInvite(Regular regular, PlayerStats playerstats, Inventory inv, ListOfRegulars reglist, Regulars regulars){
        
        //If the regular is a minor, a raid might happen
        Chance chance = new Chance();
        if(regular.getAge() < 21){
            //Chance of police raid 50%:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                System.out.println("A police raid just happened and you just got busted dancing for a minor.");
                System.out.println("The police hand you a $500 fine, and you are being held at the police station over night.");
                System.out.println("You gained some experience from the raid, and from your arrest.");
                playerstats.removeMoneySaved(500);
                playerstats.addExperience(3);
            }else{
                //Returned false:
                System.out.println("A police raid just happened, thankfully the police did not notice that you were dancing for a minor.");
                pRoomTips(250, playerstats, reglist, regulars);
            }
        }else{
            //No razzia:
            //No minor:
            Match(inv,regular,playerstats, reglist);
            pRoomTips(0, playerstats, reglist, regulars);
        }
    }
    public void pRoomTips(int bonus, PlayerStats playerStats, ListOfRegulars reglist, Regulars regulars){
        double amount = Math.round((tipsGained(playerStats.getEnhancements()*6.5+350+bonus, playerStats))*100.0)/100.0;
        playerStats.addMoneySaved(amount);
        System.out.println("You gained $" + amount + " from dancing.");
    }
}
