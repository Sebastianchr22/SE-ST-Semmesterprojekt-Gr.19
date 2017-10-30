package PrettyWoman;

public class HotelMotelInvite {

    public void Hotel(Driver driver, Regular regular) {
        System.out.println("You have been invited to a Hotel. Do you accept?");
        //Check degree of success in the game:
        //Print win degree:
        WinTranslation trans = new WinTranslation(driver.reglist.winDegree(regular));
        driver.setWon(true);
    }

    public void Motel(Driver driver, Regular regular) {
        System.out.println("You have been invited to a Motel.");
        WinTranslation trans = new WinTranslation(driver.reglist.winDegree(regular));
        driver.setWon(true);
    }

    HotelMotelInvite(Driver driver, Regular regular) {
        if (!regular.getName().toUpperCase().equals("JACK THE BOUNCER") && !regular.getName().toUpperCase().equals("EX-BOYFRIEND DANIEL") ) {
            if (regular.getWealth() >= 1500000) {
                //If regular is worth more than or equals to 1.5M invite to hotel:
                Hotel(driver, regular);
            } else {
                //Invite to motel:
                Motel(driver, regular);
            }
        } else {
            Hotel(driver, regular);
        }

    }
}
