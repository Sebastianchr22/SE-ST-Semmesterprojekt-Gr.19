package PrettyWoman;
public class Flirt {
    Chance chance = new Chance();
    
    Flirt(Regular regular, PlayerStats playerstats, Inventory inv, ListOfRegulars listofregulars){
        if(chance.ChanceCalc(80,100)){
            //Successful flirting:
            System.out.println("Your flirting was succesful");
            HotelMotelInvite result = new HotelMotelInvite(playerstats, inv, regular, listofregulars);
        }else{
            System.out.println("It doesn't seem like he heard you.");
        }
    }
}
