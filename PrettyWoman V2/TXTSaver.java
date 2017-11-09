package PrettyWoman;

import java.io.*;

public class TXTSaver implements SaveBuilder {

    @Override
    public void saveGame(Driver driver) {
        File save = new File("savefolder", "savefile.txt");
        save.getParentFile().mkdirs();

        try {
            PrintWriter saveWriter = new PrintWriter(save);
            saveWriter.println(driver.playerStats.getDaysLeft());
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
            int counter = 0;
            while (line != null) {
                System.out.println(line);
                setDriver(line, counter, driver);
                builder.append(line);
                builder.append(System.lineSeparator());
                line = reader.readLine();
                counter++;
            }
        } catch (FileNotFoundException ex) { //Code if error finding file:
            System.out.println("Error finding file");
        } catch (IOException ex) { //Code if error reader:
            System.out.println("Error reading file");
        }
    }

    
    private void setDriver(String value, int index, Driver driver) {

        if (value != null) {
            if (index <= 6) {
                switch (index) {
                    case 0:
                        driver.playerStats.setDaysLeft(Integer.parseInt(value));
                        break;
                    case 1:
                        driver.playerStats.setEnhancements(Integer.parseInt(value));
                        break;
                    case 2:
                        driver.playerStats.setExperience(Integer.parseInt(value));
                        break;
                    case 3:
                        driver.playerStats.setCurrentHunger(Integer.parseInt(value));
                        break;
                    case 4:
                        driver.playerStats.setMoneySaved(Double.parseDouble(value));
                        break;
                    case 5:
                        driver.playerStats.setMoves(Integer.parseInt(value));
                        break;
                    case 6:
                        if (!value.equals("Wedding Ring")) {
                            driver.inv.removeFromList(driver.inv.weddingring);
                            Item item = driver.itemlist.containsItem(value);
                            driver.inv.addToList(item);
                            driver.itemlist.removeFromList(item);
                        }
                        break;
                }
            } else {
                if (!value.equals("Wedding Ring")) {
                    Item item = driver.itemlist.containsItem(value);
                    driver.inv.addToList(item);
                    driver.itemlist.removeFromList(item);
                }
            }
        } else {
            System.out.println("Value was null");
        }
    }
}
