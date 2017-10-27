package PrettyWoman;
public class RegularPlayerMatch {
    Chance chance = new Chance();
    public boolean Match(Inventory inv, Preference preference){
        inv.countItems();
        boolean res = false;
        switch(preference.getName()){
            case "Gold":
                if(preference.getAmount() <= inv.goldItems){
                    res=true;
                }
                break;
            case "Silver":
                if(preference.getAmount() <= inv.silverItems){
                    res=true;
                }
                break;
        }
        return res;
    }
    public void RegularPlayerMatch(Inventory inv, Regular regular, PlayerStats playerstats, ListOfRegulars reglist){
        if(Match(inv,regular.getPreference0()) && Match(inv,regular.getPreference1())){
            System.out.println("They are a match!");
            if(chance.ChanceCalc(50, 100)){
                //Invite to hotel / motel:
                HotelMotelInvite invite = new HotelMotelInvite(playerstats,inv,regular,reglist);
                
            }
        }else{
            System.out.println("No match..");
            System.out.println(regular.getPreferences());
            inv.showInventory();
            System.out.println(inv.goldItems + "Gold");
            System.out.println(inv.silverItems + "Silver");
        }
        
    }
}
