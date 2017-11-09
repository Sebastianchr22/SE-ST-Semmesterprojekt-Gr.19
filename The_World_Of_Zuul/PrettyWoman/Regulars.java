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
    public Preference WigMore = new Preference("Wig", 3);
    public Preference GoldLess = new Preference("Gold", 1);
    public Preference ThreeStripes = new Preference("Adidas", 2);
    public Preference ShoesLess = new Preference("Shoes", 1);
    
    public Regular Sebastian = new Regular("Sebastian", 22, "Swaggy", Gold, Silver);
    public Regular John = new Regular("John Mayer", 34, "Nice guy", Gold, Silver);
    public Regular Carl = new Regular("CORRAAAAAAL!", 12, "small, whiny", Gold, Silver);
    public Regular Bouncer = new Regular("Jack the bouncer", 45, "muscular, he's always smiled at you, and greets you every morning. Maybe he fancies you a bit..?",Gold0,Gold0);
    public Regular exBoyfriend = new Regular("Ex-boyfriend Daniel", 32, "Good as always, well dressed.",Weddingring, Gold0);
    public Regular Charlie = new Regular("Charlie Sheen", 52, "Casual, but well dressed.", Gold, Wig);
    public Regular realDonaldTrump = new Regular("Donald Trump", 71, "A bit orange, daddy's boy.", GoldMore, SilverMore);
    public Regular Frank = new Regular("Frank", 30, "He's got a ring on his finger, but doesn't look happy at all.", Silver, Wig);
    public Regular Tom = new Regular("Tom Byrns", 47, "Looks like a plain old docker, rough, but polite.", WigMore, Silver);
    public Regular Vlad = new Regular("Vlad Gniewko", 28, "Rich slav, Big gold chains. Three Stripes.", GoldLess, ThreeStripes);
    public Regular Kash = new Regular("Kash Aetchum", 12, "Wearing his red and white cap backwards, he looks like the type to catch them all.", Wig, ShoesLess);
    public Regular Olajide = new Regular("KSI Olajide", 24, "Young baller, People are getting famous from YouTube now?", GoldMore, ShoesLess);
    public Regular Kim = new Regular("Kim Jong-Un", 33, "The Supreme leader look, patent pending", WigMore, Gold);
    public Regular Generic = new Regular("Generic Jensen", 37, "Just a very plain, regular looking guy.", Gold, Silver);
    public void createReglist(ListOfRegulars reglist)
    {
        reglist.addToList(Sebastian);
        reglist.addToList(Carl);
        reglist.addToList(John);
        reglist.addToList(exBoyfriend);
        reglist.addToList(Charlie);
        reglist.addToList(realDonaldTrump);
        reglist.addToList(Frank);
        reglist.addToList(Tom);
        reglist.addToList(Vlad);
        reglist.addToList(Kim);
        reglist.addToList(Generic);
    }

}
