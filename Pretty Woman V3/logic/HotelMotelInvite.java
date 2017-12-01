package logic;

import acq.ILogic;
import acq.IRegular;

public class HotelMotelInvite {

    private ILogic logic;

    public String Hotel(IRegular regular) {
        String val = "You have been invited to a Hotel!";
        //Check degree of success in the game:
        //Print win degree:
        WinTranslation trans = new WinTranslation();
        //Set highscore:
        logic.setWon(true);
        return val + "\n" + trans.WinTranslation(logic.getWinPercent(regular));
    }

    public String Motel(IRegular regular) {
        String val = "You have been invited to a Motel.";
        WinTranslation trans = new WinTranslation();
        logic.setWon(true);

        return val + "\n" + trans.WinTranslation(logic.getWinPercent(regular));
    }

    public String HotelMotelInvite(IRegular regular) {
        logic = LogicFacade.getInstance();
        if (!regular.getName().toUpperCase().equals("JACK THE BOUNCER") && !regular.getName().toUpperCase().equals("EX-BOYFRIEND DANIEL")) {
            if (regular.getWealth() >= 1500000) {
                //If regular is worth more than or equals to 1.5M invite to hotel:
                return Hotel(regular);
            } else {
                //Invite to motel:
                return Motel(regular);
            }
        } else {
            return Hotel(regular);
        }

    }
}
