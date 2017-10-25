package PrettyWoman;
public class HotelMotelInvite {
    private PlayerStats playerstats;
    private Inventory inv;
    private Regular regular;
    public void Hotel(ListOfRegulars reglist){
        System.out.println("You have been invited to a Hotel.");
        //Check degree of success in the game:
            System.out.println(reglist.countRegulars());
            reglist.winDegree(regular);
            //Regulars in list:
            //Sort according to wealth:
            //Get index of the regular that the player went with:
        //Print win degree:
        
    }
    public void Motel(){
        System.out.println("You have been invited to a Motel.");
        //Check degree of success in the game:
        
        //Print win degree:
        
        //Inform that the game could have been won better.
        
    }
    HotelMotelInvite(PlayerStats playerstats, Inventory inv, Regular regular, ListOfRegulars reglist){
        this.playerstats=playerstats;
        this.regular=regular;
        this.inv=inv;
        if(regular.getWealth() >= 1500000){
            //If regular is worth more than or equals to 1.5M invite to hotel:
            Hotel(reglist);
        }else{
            //Invite to motel:
            Motel();
        }
    }
}
