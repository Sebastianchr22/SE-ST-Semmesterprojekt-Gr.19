package PrettyWoman;
public class PrivateRoom
{
    Chance chance = new Chance();
    PlayerStats stats = new PlayerStats();
    DanceMech dance = new DanceMech();
    Regular Sebastian = new Regular(1,"Sebastian",22,"Swaggy","Gold",2,"Silver",3);
    
    public void pRoomTips(){
        double amount = dance.tipsGained(stats.getEnhancements())*3.3+500;
        stats.addMoneySaved(amount);
        System.out.println("You gained $" + amount + " from dancing.");
    }
    public void privateRoomInvite(Regular regular){
        regular.getPreference0();
        if(regular.getAge() < 18){
            //Razzia might happen:
            if(chance.ChanceCalc(50, 100)){
                //Returned true:
                System.out.println("A police raid just happened and you just got busted dancing for minor.");
                System.out.println("The police hand you a $500 fine, and you are being held at the police station over night.");
                System.out.println("You gained some experience from the raid, and from your arrest.");
                stats.removeMoneySaved(500);
                stats.addExperience(3);
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
