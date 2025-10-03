package exercise2;
import javax.swing.*;
import java.util.Random;

public class Lotto {

    int[] numbers;

    // constructor for class Lotto. Randomly generates 3 integers between 1 and 9 (inc)
    public Lotto(){
        this.numbers = new int[3];
        Random random = new Random();
        for(int i=0; i<numbers.length; i++){
            this.numbers[i] = random.nextInt(1,10);
        }

    }

    // getter for class Lotto. Returns the array of numbers associated with this lotto instance
    public int[] getNumbers(){
        return this.numbers;
    }

    // Simulate 5 rolls and sums each roll, if the sum matches the user's input, the user wins
    public void playLotto() {
        int input = Integer.valueOf(JOptionPane.showInputDialog("Please input a number between 3 and 27 (inclusive)"));

        // play up to max five rolls
        for (int i = 0; i < 5; i++) {

            Lotto lotto = new Lotto();
            int sum = 0;

            // sum over the numbers array
            for (int j = 0; j < lotto.getNumbers().length; j++) {
                sum += lotto.getNumbers()[j];
            }
            if (input == sum) {
                JOptionPane.showMessageDialog(null, "You win!");
                return;
            } else {

                String out = "The sum was: " + Integer.toString(sum) + " | Roll again!";
                JOptionPane.showMessageDialog(null, out);

            }

        }
        JOptionPane.showMessageDialog(null, "You lose!");
    }
}

