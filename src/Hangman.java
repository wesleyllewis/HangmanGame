

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    static Scanner scanner = new Scanner(System.in);
    static List<String> secretWordList = new ArrayList<>();
    static List<String> displayList = new ArrayList<>();
    static List<String> guessList = new ArrayList<>();
    static int turns = 0;
    static String secretWord = "bicycle";

    public static void main(String[] args) {
        System.out.println("Welcome To HangMan, Guess Correctly and Save A Man's Life, Guess Poorly and...\nPlease Enter A Letter.");
        populateBlankList();
        populateSecretWordList(secretWord);
        while (turns <= 9){
            String guess = scanner.nextLine();
            checkGuess(guess);
            winCondition();
        }
        lossCondition();

    }
    public static List populateBlankList() {
        for (int i = 0; i < secretWord.length(); i++) {
            displayList.add("_ ");
        }
        return displayList;
    }
    public static List populateSecretWordList(String secretWord){
        for (int i = 0; i < secretWord.length(); i++) {
            secretWordList.add(Character.toString(secretWord.charAt(i)));

        }
        return secretWordList;
    }
    public static void checkGuess(String guess) {
        if (guess.isEmpty()){
            turns++;
            System.out.println("Incorrect Guess, " + (10 -turns) + " Turns Remaining.");
        } else if (secretWordList.contains(guess)) {
            for (int i = 0; i < secretWord.length(); i++){
                if(guess.equals(secretWordList.get(i))) {
                    displayList.set(i, guess);
                }
            }
            System.out.println("Good Guess. We'll Save This Man Yet!");
            System.out.println(displayList);
            System.out.println(guessList);
        } else {
            guessList.add(guess);
            turns++;
            System.out.println("Incorrect Guess, " + (10 - turns) + " Turns Remaining.");
            System.out.println(displayList);
            System.out.println(guessList);

        }
    }
    public static void winCondition(){
        if  (! displayList.contains("_ ")){
            System.out.println("Congratulations You've Done The Impossible And Saved An Innocent Man!");
            System.exit(0);
        }
    }
    public static void lossCondition(){
        if (turns == 10){
            System.out.println("You've Failed In Your Quest To Save An Innocent Man From Death...\nThe Word Was " + secretWord);
            System.exit(0);
        }
    }

}




