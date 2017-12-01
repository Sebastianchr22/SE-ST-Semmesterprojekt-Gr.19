package logic;
public class WinTranslation {
    public String Won(){
        return  "you now have a sugardaddy, and you don't have to strip anymore!";
    }
    public String WinTranslation(double percent){
        String val = "";
        if(percent <=20.0){
            val="You did very poorly, but yet you've made it, " + Won();
        }if(percent >=21 && percent <= 40){
            val="You did quite poorly, but yet you've made it, " + Won();
        }if(percent >=41 && percent <= 60){
            val="You did alright, and you've made it, " + Won();
        }if(percent >=61 && percent <= 80){
            val="You did quite well, and you've made it, " + Won();
        }if(percent >=81 && percent <= 100){
            val="You did fantastic, "+ Won();
        }
        return val;
    }
}
