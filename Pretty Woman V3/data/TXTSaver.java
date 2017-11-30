package data;

import acq.IData;
import acq.IPlayer;
import java.io.*;
import java.util.*;

public class TXTSaver {

    private IData data = DataFacade.getInstance();

    ;
    
    public void save(Collection<Integer> stats, Collection<String> inventory) {
        File save = new File("savefolder", "savefile.txt");
        save.getParentFile().mkdirs();

        try {
            PrintWriter saveWriter = new PrintWriter(save);

            for (Integer val : stats) {
                saveWriter.println(val);
            }

            for (String name : inventory) {
                saveWriter.println(name);
            }
            saveWriter.close();
        } catch (FileNotFoundException ex) {
            // insert code to run when exception occurs
            System.out.println("Error occured during save process");
        }
    }

    private IPlayer newPlayer;

    public IPlayer load() {
        try { //try finding the file:
            BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "savefile.txt"));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            int counter = 0;
            while (line != null) {
                System.out.println(line);
                newPlayer = loadPlayer(line, counter, data);
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
        return newPlayer;
    }

    private int daysleft;
    private int exp;
    private int enh;
    private int hunger;
    private int moves;
    private double money;

    private ArrayList<String> list = new ArrayList();

    private IPlayer loadPlayer(String value, int index, IData data) {

        if (value != null) {
            if (index <= 6) {
                switch (index) {
                    case 0:
                        daysleft = Integer.parseInt(value);
                        break;
                    case 1:
                        enh = Integer.parseInt(value);
                        break;
                    case 2:
                        exp = Integer.parseInt(value);
                        break;
                    case 3:
                        hunger = Integer.parseInt(value);
                        break;
                    case 4:
                        moves = Integer.parseInt(value);
                        break;
                    case 5:
                        money = Double.parseDouble(value);
                        break;
                    case 6:
                        if (value.equals("Wedding Ring")) {
                            list.add(value);
                        }
                        break;
                }
            } else {
                if (!value.equals("Wedding Ring")) {
                    list.add(value);
                }
            }
        } else {
            System.out.println("Value was null");
        }

        IPlayer newplayer = new DataPlayer(exp, enh, moves, money, hunger, daysleft, list);
        return newplayer;
    }

}
