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
            case "Outfit":
                if(preference.getAmount() <= driver.inv.Outfit){
                    res=true;
                }
                break;
            case "Wig":
                if(preference.getAmount() <= driver.inv.wig){
                    res=true;
                }
                break;
            case "Shoes":
                if(preference.getAmount() <= driver.inv.shoes){
                    res=true;
                }
                break;
            case "Makeup":
                if(preference.getAmount() <= driver.inv.makeup){
                    res=true;
                }
                break;
            case "Adidas":
                if(preference.getAmount() <= driver.inv.Adidas){
                    res=true;
                }
                break;
            case "Wedding":
                if(preference.getAmount() <= driver.inv.weddingring){
                    res=true;
                }
                break;
        }
        return res;
    }
    RegularPlayerMatch(Driver driver, Regular regular){
        if(Match(driver,regular.getPreference0()) && Match(driver, regular.getPreference1())){
            System.out.println("The two of you are a match!");
            if(chance.ChanceCalc(50, 100)){
                //Invite to hotel / motel:
                HotelMotelInvite invite = new HotelMotelInvite(driver, regular);
            }
        }else{
            System.out.println("You two are not a match..");
        }
        
    }
}
