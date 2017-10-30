package PrettyWoman;

import java.util.ArrayList;
public class SpilWorldOfZuul
{
    public static void main(String[] args)
    {
        Driver driver = new Driver();
        Game game = new Game(driver);
        game.play(driver);
    }

}
