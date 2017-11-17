/*
- Hvad skal der til for at en GUI og et BUS lag kan kommunikerer?
en Facade som implementerer et interface:

Matador eksempel:
_________________________________________________
interface:
    public void Move*();
    public void buyField(Field field, Player player);
        Controlleren i GUI, skal her kende til både Player og Field classen.. No good.
        Løsning:
        Lad den kende til Interfaces (i):
        public void buyField(IField field, IPlayer player);


_______________________________________________
Disse Interfaces, hvad skal gøres med dem?
    - de kommes i en ny pakke.
        - Nemlig Acquaintance (ACQ) pakken (common).
    - Skal også indeholde et IBUS lag, altså et interface som Bus laget bruger.
    - GUI skal så gøre 'Afhængig af' ACQ pakken. Det samme gøres med BUS laget. Data ligeså.


_______________________________________________
Der laves en ny pakke 'Starter':
    - Den bruges til at forbinde de andre lag, og indeholder en Main metode.
    - Denne pakke skal kende til GUI, BUS, og Data laget, samt ACQ pakken.


________________________________________________
Starter klassen skal indeholde:
    IBUS bus = new BusFacade();
    IController CO = new Controller();
    CO.InjectBus(bus);              //Dette injecter en reference til en komponent som vi skal bruge under runtime.
    GUI.StartApplication();

________________________________________________
BUS Facaden :
public class Facade
    implements IBUS{}



Facaden provider et interface til Controller. Controller requires et interface.




På tværs af lagene kommunikerer vi kun med interfaces, hvad med inde i klasserne?
    - må godt refereces til klasser internt. På tværs af pakker på et lag, tillades dette ikke.




Bus laget manipulerer data, før den returnerer data.
Data laget skal ikke gøre dette.


____________________________________________________
Fra controlleren:
    private IBus bus;
initialiseres via injection.


____________________________________________________










*/