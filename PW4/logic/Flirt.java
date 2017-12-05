package logic;

public class Flirt {
    Chance chance = new Chance();
    
    public String Flirt(Regular regular){
        String val = "";
        if(chance.ChanceCalc(80,100)){
            //Successful flirting:
            val = "Your flirting was succesful";
            HotelMotelInvite result = new HotelMotelInvite();
            return val + result.HotelMotelInvite(regular);
        }else{
            val = "It doesn't seem like he heard you.";
        }
        return val;
    }
}