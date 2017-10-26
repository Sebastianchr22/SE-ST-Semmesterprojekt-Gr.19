package PrettyWoman;

import java.util.ArrayList;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Obel
 */
public class Regulars
{
    ArrayList<Regular> reglist = new ArrayList<>();
    ListOfRegulars listReg = new ListOfRegulars(reglist);
    
    Regulars(){
    Preference Gold = new Preference("Gold", 2);
    Preference Silver = new Preference("Silver", 1);
    Preference Wig = new Preference("Wig", 1);
    Regular Sebastian = new Regular(1, "Sebastian", 22, "Swaggy", Gold, Silver);
    Regular John = new Regular(1, "John Mayer", 34, "Nice guy", Gold, Wig);
    Regular Carl = new Regular(2, "CORRAAAAAAL!", 12, "small, whiny", Silver, Wig);
    reglist.add(Sebastian);
    reglist.add(Carl);
    reglist.add(John);
    }
}
//    public String[][] regulars = new String[][] 
//    {
//        {"0", "Charlie Sheen", "52", "Handsome man, dressed casually, but well.", "150000000", "Personal enhancements", "PV1", "Preference2", "PV2", ""},
//        {"1", "Donald Trump", "71", "A bit orange, daddys' boy", "3500000000", "Gold", "PV1", "Preference2", "PV2", ""},
//        {"2", "Sebastian 'Yeezy' Christiansen", "22", "A young swagger. Shoe game's on point.", "6000", "Yeezy", "PV1", "Preference2", "PV2", ""},
//        {"3", "Chad Fortman", "Age", "Built like a tank, seems blockheaded.", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"4", "Nathan Looper", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"5", "Lloyd Champine", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"6", "Craig Woodruff", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"7", "Aron Rebuck", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"8", "Tom Byrns", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"9", "Herbert Milledge", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"10", "Rasmus Stamm", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"11", "Marcelo Cohan", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"12", "Raphael Bankes", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"13", "Scott Calderwood", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""},
//        {"14", "George Gerrard", "Age", "Looks", "Wealth", "Preference1", "PV1", "Preference2", "PV2", ""}};