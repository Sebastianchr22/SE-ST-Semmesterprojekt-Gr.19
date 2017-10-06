
import java.util.*;
import java.math.*;

class Chance{
    /**
     * Takes to numbers and finds a common divider, to figure out the chance of something happening.
     * this is done by first checking which number is larger.
     * then we find a common divider between the two, in int form.
     * we make sure that we are not dividing by 0.
     * @param num1
     * @param num2
     * @return true or false
     */
    public boolean ChanceCalc(int num1, int num2) {
        int divider = 1;

        if (num1 < num2) {
            //Number 1 is smaller than number 2:
            divider = num2 / num1;
        }
        if (num2 < num1) {
            //Number 2 is smaller than number 1:
            divider = num1 / num2;
        } else if (num1 == num2) {
            //Avoiding dividing by 0:
            num1 = 1;
            num2 = 1;
        }
        int random = (int) (1 + Math.random() * divider);
        if (random == divider) {
            //True:
            return true;
        } else {
            return false;
        }

    }
}
