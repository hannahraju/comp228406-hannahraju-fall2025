package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

// Test class simulates a 5 question multiple choice test covering the first 3 lectures of COMP228
public class Test {

    public static int numQuestions;
    public static String[] questions;
    public static String[] answerkey;
    public static int numCorrect;

    //constructor
    public Test() {
        numQuestions = 4;
        questions = new String[numQuestions];
        answerkey = new String[numQuestions];
        numCorrect = 0;
    }

    // simulateQuestions() method simulates the 5 multiple choice questions
    private static void simulateQuestions() {
        questions[0] = "What is the correct way to format an output to the terminal?\na) System.out.printf( \"Sum is %d%n\", sum);\nb) System.out.printf(\"Sum is %i%n\", sum)\nc) System.out.println( \"Sum is %d%n\", sum)\nd) System.out.println( \"Sum is %i%n\", sum);";
        questions[1] = "Class, method, and variable names are all examples of:\na) constructors\nb) identifiers\nc) declarations\nd) definitions";
        questions[2] = "Which of the following is an example of using a \"getter\":\na) this.Name()\nb) name = getName(person)\nc) person.getName() \nd) name = this.name(person)";
        questions[3] = "What is an example of method overloading?\na) Calling a function using too many parameters\nb) A method returns more than one value]\nc) Your programs gets stuck in an infinite loop\nd) Building a class with multiple constructors";
        answerkey = new String[]{"a", "b", "c", "d"};

    }

    // checkAnswer()  method checks the user's inputted answers
    private static Boolean checkAnswer(String answer, int index) {
        if (answer.equals(answerkey[index])) {
            numCorrect++;
            return true;
        } else {
            return false;
        }

    }

    // generateMessage() method displays random message to user depending on how they answer
    public static String generateMessage(Boolean correct) {
        Random random = new Random();
        if (correct) {
            switch (random.nextInt(4)) {
                case 0:
                    return ("Nice!");

                case 1:
                    return ("Excellent!");

                case 2:
                    return ("Right on!");

                case 3:
                    return ("That's correct!");
            }
        } else {
            switch (random.nextInt(4)) {
                case 0:
                    return ("Sorry, please try again!");
                case 1:
                    return ("Wrong!");
                case 2:
                    return ("Nope! Maybe next time!");
                case 3:
                    return ("Keep trying, you'll get it!");
            }

        }
        return ("ERROR");
    }

    // inputAnswer() method interacts with the user to input their answers
    public static void inputAnswer() {
        simulateQuestions();
        for (int i = 0; i < numQuestions; i++) {
            JOptionPane.showMessageDialog(null, questions[i]);
            String answer = JOptionPane.showInputDialog("Please input your answer");
            Boolean correct = checkAnswer(answer, i);
            JOptionPane.showMessageDialog(null, generateMessage(correct));
        }
        String results = "Correct answers: " + Integer.toString(numCorrect) + "\nIncorrect answers: " + Integer.toString(numQuestions - numCorrect) + "\nPercent score: " + Integer.toString(numCorrect*100 / numQuestions);
        JOptionPane.showMessageDialog(null,results);

    }

}



// References:
// https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html
