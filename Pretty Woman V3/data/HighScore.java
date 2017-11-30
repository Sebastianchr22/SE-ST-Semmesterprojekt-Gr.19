package data;

import acq.IData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScore {

    private DataFacade data = new DataFacade();

    public void save(int score) {
        try { //try finding the file:
            BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "highscore.txt"));
            String line = reader.readLine();

//            System.out.println("Old highscore:" + line);
//            System.out.println("New score: " + data.getScore());

            if (Integer.parseInt(line) < score) {
                File save = new File("savefolder", "highscore.txt");
                save.getParentFile().mkdirs();

                try {
                    PrintWriter saveWriter = new PrintWriter(save);
                    saveWriter.println(score);
                    saveWriter.close();
                } catch (FileNotFoundException ex) {
                    // insert code to run when exception occurs
                    System.out.println("Error occured during save process");
                }
            } else {
                System.out.println("You didn't get a highscore");
            }

        } catch (FileNotFoundException ex) { //Code if error finding file:
            System.out.println("Error finding file");
        } catch (IOException ex) { //Code if error reader:
            System.out.println("Error reading file");
        }
    }

    public void load() {
        try { //try finding the file:
            BufferedReader reader = new BufferedReader(new FileReader("savefolder" + "/" + "highscore.txt"));
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();

            //System.out.println("Highscore: " + line);
            //data.setHighScore(Integer.parseInt(line));
            
            
            //Read from doc, set collection, parse collection to Logic:
            builder.append(line);
            builder.append(System.lineSeparator());

        } catch (FileNotFoundException ex) { //Code if error finding file:
            System.out.println("Error finding file");
        } catch (IOException ex) { //Code if error reader:
            System.out.println("Error reading file");
        }
    }
}
