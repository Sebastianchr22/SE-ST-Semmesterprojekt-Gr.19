package data;

import acq.IData;
import acq.IPlayer;
import java.io.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TXTSaver {

    private IData data = DataFacade.getInstance();

    public void newFiles() throws UnsupportedEncodingException {
        try (Writer save = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("savefolder/savefile.txt"), "utf-8"))) {
        } catch (IOException ex) {
            System.out.println("Error creating savefile..");
        }
        
        try (Writer score = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("savefolder/highscore.txt"), "utf-8"))) {
        }catch (IOException ex) {
            System.out.println("Error creating scorefile..");
        }
    }

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

    public void saveHighScore(int score) throws FileNotFoundException, IOException {

        File save = new File("savefolder", "highscore.txt");
        save.getParentFile().mkdirs();

        //Reads all existing lines in the file:
        ArrayList<Integer> scores = new ArrayList();

        BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "highscore.txt"));

        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            System.out.println("Highscore read: " + line);
            scores.add(Integer.parseInt(line));
            builder.append(line);
            builder.append(System.lineSeparator());
            line = reader.readLine();
        }
        scores.add(score);

        //Adds all scores to the list, plus the new score:
        PrintWriter saveWriter = new PrintWriter(save);

        for (int i : scores) {
            System.out.println("Score inserted: " + i);
            saveWriter.println(i);
        }
        saveWriter.close();
    }

    public ObservableList loadHighScore() throws FileNotFoundException, IOException {

        ObservableList<Integer> scores = FXCollections.observableArrayList();
        ObservableList<Integer> scoresSorted = FXCollections.observableArrayList();

        BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "highscore.txt"));
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            scores.add(Integer.parseInt(line));

            builder.append(line);
            builder.append(System.lineSeparator());
            line = reader.readLine();
        }
        scores = scores.sorted(); //Sorts list, low to high
        System.out.println(scores.toString());

        //Counts items:
        int counter = 0;
        for (int i : scores) {
            counter++;
        }
        //Goes through the amount of items, in inverted order (last first)
        //Last will be larges, adds that, repeats for the rest.
        for (int j = counter; j > 0; j--) {
            scoresSorted.add(scores.get(j - 1));
        }

        return scoresSorted;
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
