package logic;

public class Flirt {
    Chance chance = new Chance();
    
    Flirt(Regular regular){
        if(chance.ChanceCalc(80,100)){
            //Successful flirting:
            System.out.println("Your flirting was succesful");
            HotelMotelInvite result = new HotelMotelInvite(regular);
        }else{
            System.out.println("It doesn't seem like he heard you.");
        }
    }
}