package logic;

import acq.ILogic;
import acq.IPreference;
import acq.IRegular;

public class RegularPlayerMatch {

    private ILogic logic = LogicFacade.getInstance();
    private Inventory inv;

    Chance chance = new Chance();

    public boolean Match(IPreference preference) {

        boolean res = false;
        switch (preference.getName()) {
            case "Gold":
                if (preference.getAmount() <= inv.getSpecific("Gold")) {
                    res = true;
                }
                break;
            case "Silver":
                if (preference.getAmount() <= inv.getSpecific("Silver")) {
                    res = true;
                }
            case "Outfit":
                if (preference.getAmount() <= inv.getSpecific("Outfit")) {
                    res = true;
                }
                break;
            case "Wig":
                if (preference.getAmount() <= inv.getSpecific("Wig")) {
                    res = true;
                }
                break;
            case "Shoes":
                if (preference.getAmount() <= inv.getSpecific("Shoes")) {
                    res = true;
                }
                break;
            case "Makeup":
                if (preference.getAmount() <= inv.getSpecific("Makeup")) {
                    res = true;
                }
                break;
            case "Adidas":
                if (preference.getAmount() <= inv.getSpecific("Adidas")) {
                    res = true;
                }
                break;
            case "Wedding":
                if (preference.getAmount() <= inv.getSpecific("Wedding")) {
                    res = true;
                }
                break;
        }
        return res;
    }

    public String RegularPlayerMatch(IRegular regular) {
        String val = "";
        inv = logic.getInv();
        if (Match(regular.getPreference0()) && Match(regular.getPreference1())) {
            val = "The two of you are a match!";
            if (chance.ChanceCalc(60, 100)) {
                //Invite to hotel / motel:
                HotelMotelInvite invite = new HotelMotelInvite();
                return val + "\n" + invite.HotelMotelInvite(regular);
            }else{
                return logic.getRegularInRoom().getName() + " did not invite anywhere, and just left.";
            }
        } else {
            val = "You two are not a match..";
            logic.setRegularInRoom(null);
            logic.setPrivateRoomCommand(null);
            logic.setPRoomInvite(false);
        }
        return val;

    }
}
