package com.github.zipcodewilmington;

import java.util.*;


public class WordGuess {

    private String[] wordBank = {"warlike", "flawless", "please", "offer", "unknown", "silent", "jog", "record", "pinch", "lying" };
    private String wordToGuess = "";
    private char playerGuesses = ' ';
    private int numOfGuesses = 0;
    private String playerInputString = "";
    private boolean playState = false;
    private boolean guessed = false;
    private char [] arr1 = new char[wordToGuess.length()];


    public void runGame(){
        //starts the game with prompt for input and assign
        selectWordToGuess();
        announceGame();
        initializeGame(wordToGuess.length());
        while (numOfGuesses > 0 ){
            playerNextGuess();
            compareStrings();
        }


    }

    public void selectWordToGuess(){
        int rand = (int) (Math.random() * wordBank.length);
        wordToGuess = wordBank[rand];
        numOfGuesses = wordBank[rand].length();
    }

    public void announceGame(){
        System.out.println("There is a secret word that has been selected:");
        System.out.println("The game is about you guessing the word.");
        System.out.println(wordToGuess);
    }

    public char getPlayerInput(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        char response = (char) sc.next().charAt(0);
        return response;
    }



    static void gameOver(){

    }

    public void initializeGame(int x) {
        char[] arr = new char[x];
        Arrays.fill(arr, '_');
        arr1 = arr;
       playerInputString = Arrays.toString(arr);
        System.out.println("Word to guess: " + playerInputString);
    }

    public void displayPlayerGuesses(){
        System.out.println("Word to guess: " + Arrays.toString(arr1));
    }

    public void playerNextGuess() {
        playerGuesses =  (getPlayerInput("Guess your letter "));
    }

    public void createPlayerArray(String s){
        ArrayList<String> gl = new ArrayList<>();
        gl.add(s);

    }

    public int checkIfLetterIsInWord(){
        String s = Character.toString(playerGuesses);
       int indexForLetter =-1;
        if (wordToGuess.contains(s)){
            indexForLetter = wordToGuess.indexOf(playerGuesses);
        };
        return indexForLetter;
    }

    public boolean isWordGuessed() {

        int i = checkIfLetterIsInWord();
        if (i != -1){
            //System.out.println(arr1[i]);
            arr1[i] =  playerGuesses;

           //p System.out.println(Arrays.toString(arr1));
            displayPlayerGuesses();
        return true;
        }
        numOfGuesses--;
        return false;
    }

    public static void askToPlayAgain() {

    }

    public void compareStrings() {
        //Print array to show where player is at.
        boolean wordGuessed = isWordGuessed();
        if (wordGuessed && wordToGuess.equals(Arrays.toString(arr1))) {
            playerWon();
        } else if (wordGuessed && numOfGuesses == 0){

            playerLost();
        } else {
            playerNextGuess();
        }

    }

    public void playerWon() {
        //print message
        char userInput = getPlayerInput("You won, Do you want to play again? 1-Yes, 2-No");
        keepPlayOrQuit(userInput);
    }
    public void playerLost() {
        //print sad message
        System.out.println("You run out of guesses:");
        char userInput = getPlayerInput("You lost, Do you want to play again? 1-Yes, 2-No");
        keepPlayOrQuit(userInput);

    }

    public void keepPlayOrQuit(char c){
        if (c == '1'){
            playState = true;
        } else if (c == '2'){
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }


    public static void process() {
        //loops through the word array looking for the inputed guesses and replaces the "_" with the guessed char if found
    }
}
