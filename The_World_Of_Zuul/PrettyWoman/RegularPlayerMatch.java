package PrettyWoman;
public class RegularPlayerMatch {
    Chance chance = new Chance();
    public boolean Match(Driver driver, Preference preference){
        driver.inv.countItems();
        boolean res = false;
        switch(preference.getName()){
            case "Gold":
                if(preference.getAmount() <= driver.inv.goldItems){
                    res=true;
                }
                break;
            case "Silver":
                if(preference.getAmount() <= driver.inv.silverItems){
                    res=true;
                }
                break;
        }
        return res;
    }
    public void RegularPlayerMatch(Driver driver, Regular regular){
        if(Match(driver,regular.getPreference0()) && Match(driver, regular.getPreference1())){
            System.out.println("They are a match!");
            if(chance.ChanceCalc(50, 100)){
                //Invite to hotel / motel:
                HotelMotelInvite invite = new HotelMotelInvite(driver, regular);
                
            }
        }else{
            System.out.println("No match..");
            System.out.println(regular.getPreferences());
            driver.inv.showInventory();
            System.out.println(driver.inv.goldItems + "Gold");
            System.out.println(driver.inv.silverItems + "Silver");
        }
        
    }
}
