package PrettyWoman;
public class Regulars
{
    public Preference Gold = new Preference("Gold", 2);
    public Preference Silver = new Preference("Silver", 1);
    public Preference Wig = new Preference("Wig", 1);
    public Regular Sebastian = new Regular(1, "Sebastian", 22, "Swaggy", Gold, Silver);
    public Regular John = new Regular(1, "John Mayer", 34, "Nice guy", Gold, Wig);
    public Regular Carl = new Regular(2, "CORRAAAAAAL!", 12, "small, whiny", Silver, Wig);

    public void createReglist(ListOfRegulars reglist)
    {
        reglist.addToList(Sebastian);
        reglist.addToList(Carl);
        reglist.addToList(John);
       
        
    }

}