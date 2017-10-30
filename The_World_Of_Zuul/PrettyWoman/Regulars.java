package PrettyWoman;
public class Regulars
{
    public Preference Gold = new Preference("Gold", 2);
    public Preference Silver = new Preference("Silver", 1);
    public Preference Wig = new Preference("Wig", 1);
    public Preference Gold0 = new Preference("Gold",0);
    public Preference Weddingring = new Preference("Wedding",1);
    
    public Regular Sebastian = new Regular(1, "Sebastian", 22, "Swaggy", Gold, Silver);
    public Regular John = new Regular(1, "John Mayer", 34, "Nice guy", Gold, Silver);
    public Regular Carl = new Regular(2, "CORRAAAAAAL!", 12, "small, whiny", Gold, Silver);
    public Regular Bouncer = new Regular(3, "Jack the bouncer", 45, "muscular, he's always smiled at you, and greets you every morning. Maybe he fancies you a bit..?",Gold0,Gold0);
    public Regular exBoyfriend = new Regular(4,"Ex-boyfriend Daniel", 32, "Good as always, well dressed.",Weddingring, Gold0);
    public void createReglist(ListOfRegulars reglist)
    {
        reglist.addToList(Sebastian);
        reglist.addToList(Carl);
        reglist.addToList(John);
        reglist.addToList(exBoyfriend);
       
        
    }

}