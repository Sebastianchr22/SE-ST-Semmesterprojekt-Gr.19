/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Sebas
 */
public class WinTranslation {
    public String Won(){
        return  "you now have a sugardaddy, and you don't have to strip anymore!";
    }
    WinTranslation(double percent){
        if(percent <=20.0){
            System.out.println("You did very poorly, but yet you've made it, " + Won());
        }if(percent >=21 && percent <= 40){
            System.out.println("You did quite poorly, but yet you've made it, " + Won());
        }if(percent >=41 && percent <= 60){
            System.out.println("You did alright, and you've made it, " + Won());
        }if(percent >=61 && percent <= 80){
            System.out.println("You did quite well, and you've made it, " + Won());
        }if(percent >=81 && percent <= 100){
            System.out.println("You did fantastic, "+ Won());
        }
    }
}
