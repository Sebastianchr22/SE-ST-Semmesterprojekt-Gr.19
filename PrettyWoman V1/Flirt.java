package PrettyWoman;
public class Flirt {
    Chance chance = new Chance();
    
    Flirt(Driver driver, Regular regular){
        if(chance.ChanceCalc(80,100)){
            //Successful flirting:
            System.out.println("Your flirting was succesful");
            HotelMotelInvite result = new HotelMotelInvite(driver, regular);
        }else{
            System.out.println("It doesn't seem like he heard you.");
        }
    }
}