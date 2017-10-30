package PrettyWoman;
public class Regulars
{
    public Preference Gold = new Preference("Gold", 2);
    public Preference Silver = new Preference("Silver", 1);
    public Preference Wig = new Preference("Wig", 1);
    public Preference Gold0 = new Preference("Gold",0);
    public Preference Weddingring = new Preference("Wedding",1);
    public Preference GoldMore = new Preference("Gold", 5);
    public Preference SilverMore = new Preference("Silver", 5);
    
    public Regular Sebastian = new Regular("Sebastian", 22, "Swaggy", Gold, Silver);
    public Regular John = new Regular("John Mayer", 34, "Nice guy", Gold, Silver);
    public Regular Carl = new Regular("CORRAAAAAAL!", 12, "small, whiny", Gold, Silver);
    public Regular Bouncer = new Regular("Jack the bouncer", 45, "muscular, he's always smiled at you, and greets you every morning. Maybe he fancies you a bit..?",Gold0,Gold0);
    public Regular exBoyfriend = new Regular("Ex-boyfriend Daniel", 32, "Good as always, well dressed.",Weddingring, Gold0);
    public Regular Charlie = new Regular("Charlie Sheen", 52, "Casual, but well dressed.", Gold, Wig);
    public Regular realDonaldTrump = new Regular("Donald Trump", 71, "A bit orange, daddy's boy", GoldMore, SilverMore);
    
    public void createReglist(ListOfRegulars reglist)
    {
        reglist.addToList(Sebastian);
        reglist.addToList(Carl);
        reglist.addToList(John);
        reglist.addToList(exBoyfriend);
        reglist.addToList(Charlie);
        reglist.addToList(realDonaldTrump);
    }

}
