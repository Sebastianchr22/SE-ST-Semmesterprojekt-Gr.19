package PrettyWoman;

public class PrivateRoom
{
    public void Match(Inventory inv,Regular regular, PlayerStats playerstats, ListOfRegulars reglist){
        //Boolean method to check if a regular and a player is a match:
        RegularPlayerMatch match = new RegularPlayerMatch();
        match.RegularPlayerMatch(inv, regular, playerstats, reglist);
    }
    
    public void privateRoomInvite(Regular regular, PlayerStats playerstats, Inventory inv, ListOfRegulars reglist){
        
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
                pRoomTips(250,playerstats);
            }
        }else{
            //No razzia:
            //No minor:
            Match(inv,regular,playerstats, reglist);
            pRoomTips(0,playerstats);
        }
    }
    public void pRoomTips(int bonus, PlayerStats playerStats){
        DanceMech dance = new DanceMech();
        double amount = Math.round((dance.tipsGained(playerStats.getEnhancements()*6.5+350+bonus))*100.0)/100.0;
        playerStats.addMoneySaved(amount);
        System.out.println("You gained $" + amount + " from dancing.");
    }
}
