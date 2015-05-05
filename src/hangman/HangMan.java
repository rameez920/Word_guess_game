
package hangman;


import java.util.*;
 


public class HangMan {


    public static void main(String[] args) {
       Scanner kb = new Scanner(System.in);
       String[] wordBank = new String[10];
       
       //prompt user to enter a word for user to guess
       System.out.println("Enter a word for the player to guess");
       String word = kb.nextLine();
       char[] letters = word.toCharArray();
       boolean[] found = new boolean[letters.length];
       ArrayList<Character> guessedLetters = new ArrayList<>();
       
       
       //fill boolean array with false
       for(int i = 0; i < found.length; i++) {
           found[i] = false;
       }
       
       int guesses = 6;
       int score = 0;
       char letterGuess;
       
       //main loop checks user guesses
       while(guesses > 0 && score < letters.length) {
           printWord(letters, found);
           System.out.println("Guess a letter");
           letterGuess = kb.next().toLowerCase().charAt(0);
           
          if (guessedLetters.contains(letterGuess)) {
              System.out.println("Already guessed try another letter");
          } else if (!guessLetter(letterGuess, letters, found)) { //user guesses wrong
              System.out.println("Sorry guess again");
              System.out.println("Number of guesses left " + guesses);
              guessedLetters.add(letterGuess);
              guesses--;
          } else { //user guesses right 
              score++;
              guessedLetters.add(letterGuess); 
          }
              
      }
       
       
       if (guesses == 0) {
           System.out.println("Sorry you ran out of guesses");
           System.out.println("The word was " + word);
       } else if (score == word.length()) {
           System.out.println("Congrats you guesses right!!! the word is " + word);
       }
       
       
       
    } 

 
 
    
  public static boolean guessLetter(char guess, char[] word, boolean found[]) {
     
     // find each instance of the letter that is guessed
     for (int i = 0; i < found.length; i++) {
          
          if (word[i] == guess) {
              found[i] = true;
          }
          
      }
     
     for (int i = 0; i < word.length; i++) {
          
          if (word[i] == guess) {
              return true;
          }
          
      }
      return false;
 
 }


  
  public static void printWord(char word[], boolean found[]) {
    String result = "";
    for(int i = 0; i < word.length; i++) {
        if (found[i]) {
            result += word[i];
        } else {
            result+= " _";
        } 
    }
    System.out.println(result);
}

}
