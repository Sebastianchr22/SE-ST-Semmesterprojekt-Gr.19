package PrettyWoman;
public class HotelMotelInvite {
    private PlayerStats playerstats;
    private Inventory inv;
    private Regular regular;
    private ListOfRegulars reglist;
    public void Hotel(ListOfRegulars reglist){
        System.out.println("You have been invited to a Hotel.");
        //Check degree of success in the game:
            System.out.println(reglist.countRegulars());
            //Print win degree:
            WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
    }
    public void Motel(){
        System.out.println("You have been invited to a Motel.");
        WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
    }
    HotelMotelInvite(PlayerStats playerstats, Inventory inv, Regular regular, ListOfRegulars reglist){
        this.playerstats=playerstats;
        this.regular=regular;
        this.reglist=reglist;
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
