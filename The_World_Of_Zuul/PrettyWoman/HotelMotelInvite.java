package PrettyWoman;
public class HotelMotelInvite {
    public void Hotel(ListOfRegulars reglist, Regular regular){
        System.out.println("You have been invited to a Hotel.");
        //Check degree of success in the game:
            System.out.println(reglist.countRegulars());
            //Print win degree:
            WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
    }
    public void Motel(ListOfRegulars reglist, Regular regular){
        System.out.println("You have been invited to a Motel.");
        WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
    }
    HotelMotelInvite(PlayerStats playerStats, Inventory inv, Regular regular, ListOfRegulars reglist){
        
        if(regular.getWealth() >= 1500000){
            //If regular is worth more than or equals to 1.5M invite to hotel:
            Hotel(reglist, regular);
        }else{
            //Invite to motel:
            Motel(reglist, regular);
        }
    }
}
