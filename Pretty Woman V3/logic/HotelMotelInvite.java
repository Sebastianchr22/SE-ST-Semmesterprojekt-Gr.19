package logic;

import acq.ILogic;
import acq.IRegular;



public class HotelMotelInvite {
    
    private ILogic logic;
    private ListOfRegulars reglist;
    

    public void Hotel(IRegular regular) {
        reglist.regularList = logic.getRegularList();
        
        System.out.println("You have been invited to a Hotel. Do you accept?");
        //Check degree of success in the game:
        //Print win degree:
        WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
        //Set highscore:
        logic.setWon(true);
    }

    public void Motel(IRegular regular) {
        System.out.println("You have been invited to a Motel.");
        WinTranslation trans = new WinTranslation(reglist.winDegree(regular));
        //Set highscore:
        logic.setWon(true);
    }

    HotelMotelInvite(IRegular regular) {
        if (!regular.getName().toUpperCase().equals("JACK THE BOUNCER") && !regular.getName().toUpperCase().equals("EX-BOYFRIEND DANIEL") ) {
            if (regular.getWealth() >= 1500000) {
                //If regular is worth more than or equals to 1.5M invite to hotel:
                Hotel(regular);
            } else {
                //Invite to motel:
                Motel(regular);
            }
        } else {
            Hotel(regular);
        }

    }
}
