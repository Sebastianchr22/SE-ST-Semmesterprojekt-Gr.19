package PrettyWoman;

import java.io.*;

public class txtSaver implements saveBuilder {

    @Override
    public void saveGame(Driver driver) {
        File save = new File("savefolder", "savefile.txt");
        save.getParentFile().mkdirs();

        try {
            PrintWriter saveWriter = new PrintWriter(save);
            saveWriter.println(driver.playerStats.getAge());
            saveWriter.println(driver.playerStats.getEnhancements());
            saveWriter.println(driver.playerStats.getExperience());
            saveWriter.println(driver.playerStats.getHunger());
            saveWriter.println(driver.playerStats.getMoneySaved());
            saveWriter.println(driver.playerStats.getMoves());

            for (Item item : driver.inv.Inventory) {
                saveWriter.println(item.getName());
            }
            saveWriter.close();
        } catch (FileNotFoundException ex) {
            // insert code to run when exception occurs
            System.out.println("Error occured during save process");
        }
    }

    @Override
    public void loadGame(Driver driver) {
        try { //try finding the file:
            BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "savefile.txt"));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            
            while(line != null){
                builder.append(line);
                builder.append(System.lineSeparator());
                line = reader.readLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) { //Code if error finding file:
            System.out.println("Error finding file");
        } catch (IOException ex) { //Code if error reader:
            System.out.println("Error reading file");
        }
    }
}
