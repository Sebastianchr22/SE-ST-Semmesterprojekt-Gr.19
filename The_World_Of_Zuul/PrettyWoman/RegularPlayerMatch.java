package PrettyWoman;
public class RegularPlayerMatch {
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
                if(preference.getAmount() <= inv.goldItems){
                    res=true;
                }
                break;
        }
        return res;
    }
    RegularPlayerMatch(Inventory inv, Regular regular){
        if(Match(inv,regular.getPreference0()) && Match(inv,regular.getPreference1())){
            System.out.println("They are a match!");
        }else{
            System.out.println("No match..");
        }
        
    }
}
