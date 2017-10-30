package PrettyWoman;

import java.util.ArrayList;

public class ItemList
{
    int jewelryWeigth = 3;
    int outfitWeigth = 60;
    int wigWeigth = 20;
    int shoesWeigth = 40;
    int makeupWeigth = 5;
    ArrayList<Item> itemList;
    ItemList()
    {
    itemList = new ArrayList<>();
    //wedding ring
    //public Item weddingring = new Item(0, "Wedding Ring", "Your wedding ring", "Wedding", jewelryWeigth);
    //gold jewelry
    Item goldring = new Item(1, "Gold Ring", "A nice gold ring", "Gold", jewelryWeigth);
    Item goldearring = new Item(2, "Gold Earring", "A nice gold earring", "Gold", jewelryWeigth);
    Item goldwristwatch = new Item(3, "Gold Wristwatch", "A nice gold wristwatch", "Gold", jewelryWeigth);
    Item goldbracelet = new Item(4, "Gold Bracelet", "A nice gold bracelet", "Gold", jewelryWeigth);
    Item goldnecklace = new Item(5, "Gold Necklace", "A nice silver necklace", "Gold", jewelryWeigth);
    //silver jewelry
    Item silverring = new Item(6, "Silver Ring", "A cool silver ring", "Silver", jewelryWeigth);
    Item silverearring = new Item(7, "Silver Earring", "A cool silver earring", "Silver", jewelryWeigth);
    Item silverwristwatch = new Item(8, "Silver Wristwatch", "A cool silver wristwatch", "Silver", jewelryWeigth);
    Item silverbracelet = new Item(9, "Silver Bracelet", "A cool silver bracelet", "Silver", jewelryWeigth);
    Item silvernecklace = new Item(10, "Silver Necklace", "A cool silver necklace", "Silver", jewelryWeigth);
    //outfits
    Item schoolO = new Item(11, "School Girl Outfit", "An outfit that will make you look like a sexy young high school student", "Outfit", outfitWeigth);
    Item nurseO = new Item(12, "Nurse Outfit", "An outfit that will make you look like a sexy nurse", "Outfit", outfitWeigth);
    Item ninjaO = new Item(13, "Ninja Outfit", "An outfit that will make you look like a sexy acrobatic ninja", "Outfit", outfitWeigth);
    Item maidO = new Item(14, "Maid Outfit", "An outfit that will make you look like a sexy french maid", "Outfit", outfitWeigth);
    Item policeO = new Item(15, "Police Outfit", "An outfit that will make you look like a sexy police officer", "Outfit", outfitWeigth);
    Item cheerleaderO = new Item(16, "Cheerleader Outfit", "An outfit that will make you look like a sexy cheerleader", "Outfit", outfitWeigth);
    Item cowgirlO = new Item(17, "Cowgirl Outfit", "An outfit that will make you look like a sexy cowgirl", "Outfit", outfitWeigth);
    Item minecraftO = new Item(18, "Sexy Minecraft Outfit", "An outfit that will make you look like a sexy minecraft girl, made of blocks", "Outfit", outfitWeigth);
    Item bunnyO = new Item(19, "Bunny Outfit", "An outfit that will make you look sexy with bunny ears and tail", "Outfit", outfitWeigth);
    Item devilO = new Item(20, "Devil Outfit", "An outfit that will make you look like a sexy devil", "Outfit", outfitWeigth);
    Item adidasO = new Item(21, "Adidas Outfit", "An outfit that will make you into a real slav", "Outfit", outfitWeigth);
    Item superWomanO = new Item(22, "Super Woman Outfit", "An outfit that will make you look like the sexy Super Woman", "Outfit", outfitWeigth);
    //wigs
    Item curlyBlondeW = new Item(23, "Curly Blonde Wig", "Classy curly blonde hair", "Wig", wigWeigth);
    Item longBlueW = new Item(24, "Long Blue Hair Wig", "Long blue hair like taken from an anime", "Wig", wigWeigth);
    Item baldW = new Item(25, "Bald Wig", "Makes you bald", "Wig", wigWeigth);
    Item shortStylishW = new Item(26, "Short Stylish Hair Wig", "Gives you really stylish short hair", "Wig", wigWeigth);
    Item superSaiyanW = new Item(27, "Super Saiyan Wig", "Makes your hair glow yellow, Over 9000!!", "Wig", wigWeigth);
    //shoes
    Item yeezyS = new Item(28, "Yeezy", "Shoes for a real swagster", "Shoe", shoesWeigth);
    Item adidasS = new Item(29, "Adidas Shoes", "The only shoes for a real slav", "Shoe", shoesWeigth);
    Item sandalsS = new Item(30, "Sandals", "Usefull for walking on the beach", "Shoe", shoesWeigth);
    Item highHeelsS = new Item(31, "Red High Heels", "Classy red heels for at classy woman", "Shoe", shoesWeigth);
    Item gucciS = new Item(32, "Gucci Shoes", "Show through your shoes that you got money and bad style", "Shoe", shoesWeigth);
    //makeup
    Item heavyMakeupM = new Item(33, "Heavy Makeup", "When you have to look really good, even if you need a full facemask of makeup", "Makeup", makeupWeigth);
    Item mediumMakeupM = new Item(34, "Medium Makeup", "When you really wanna look good, but still won't use too much makeup", "Makeup", makeupWeigth);
    Item lightMakeupM = new Item(35, "Light Makeup", "Makeup for a more neutral and healthy look", "Makeup", makeupWeigth);

    itemList.add(goldring);
    itemList.add(goldearring);
    itemList.add(yeezyS);
    itemList.add(adidasS);
    }
    
    public int countItems()
    {
        int counter = 0;
        for (Item item : itemList)
        {
            counter++;
        }
        return counter;
    }
    public Item get(int i){
        return itemList.get(i);
    }
    public void removeItem(Item item)
    {
        itemList.remove(item);
    }
    public void addItem(Item item){
        itemList.add(item);
    }
    public void showItemList(){
        for(Item item : itemList){
            System.out.println(item.getValues());
        }
    }
    //SORT ITEMLIST:
    
}
