package com.github.zipcodewilmington;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Random;


public class Wordguess {
//    public static void main(String[] args) {
//
//        runGame();
//    }

    static String[] wordBank = {"warlike", "flawless", "please", "offer", "unknown", "silent", "jog", "record", "pinch", "lying" };
    static String wordToGuess;
    static int numOfGuesses = 0;
    static String playerInput = "";
    static boolean playState = false;

    public static void runGame() {
        System.out.println("Ready to play? ");

        Scanner sc = new Scanner(System.in);
        String playChoice = sc.nextLine();
        if (playChoice.equalsIgnoreCase("yes")) {
            playState = true;
        } else {
            playState = false;
        }
        while (playState){
            pickRandomWord();
            setNumOfGuesses();
            setPlayerInput();
            isWordGuessed(wordToGuess, playerInput);
        }

    }
    public static void pickRandomWord(){
        int rand =(int) (Math.random() * wordBank.length);
        wordToGuess = wordBank[rand];
        char[] ch = wordToGuess.toCharArray();
        System.out.println(ch);
    }

    public static void setPlayerInput(){
        System.out.println("Pick a letter to guess the word: ");
        Scanner sc = new Scanner(System.in);
        playerInput = sc.nextLine();
        System.out.println(playerInput);
        numOfGuesses= numOfGuesses-1;
    }

    public static void testPlayerInput(){
        if (playerInput.length() > 1){
            System.out.println("try again, invalid entry");
            setPlayerInput();
        }
    }

    public static void setNumOfGuesses(){
        numOfGuesses = wordToGuess.length();
        System.out.println("You have " + numOfGuesses + " tries left");
        //wordReturn();
    }

    public static void isWordGuessed(String s, String p) {
        char[] arr = s.toCharArray();
        String[] newArr = new String[s.length()];
        for (int i = 0; i < arr.length; i++) {
            if (p.equalsIgnoreCase(String.valueOf(arr[i]))){
                    newArr[i]= p;
            } else {
                newArr[i] = "_";
            }

        }
        System.out.println(Arrays.toString(newArr));
        if (Arrays.toString(newArr).equals(s)){
            System.out.println("player won, congrats");
        } else {
            System.out.println("keep going");
            setPlayerInput();
        }

    }





//    public static void main(String [] args) {
//        System.out.println("Let's Play Guess the Word version 1.0");
//
//        pickRandomWord();
//        setNumOfGuesses();
//        setPlayerInput();
        //wordReturn();
//        System.out.println("Pick a letter to guess the word: ");
//        Scanner sc = new Scanner(System.in);
//        String playerInput = sc.nextLine();
   // }





//    public static void setNumOfGuesses(){
//        numOfGuesses = wordToGuess.length();
//        System.out.println("You have " + numOfGuesses + " tries left");
//        wordReturn();
//    }



    public static void wordReturn(){
        String[] arr = new String[numOfGuesses];
        for (int i=0; i<arr.length; i++){
            String charToCheck = String.valueOf(wordToGuess.charAt(i));
            if (playerInput.equals("null")){
                if (playerInput.equalsIgnoreCase(charToCheck)){
                    arr[i]= playerInput;
                } else {
                    arr[i] = "_";
                }
            } else {
                arr[i] = "_";
            }
        }
        System.out.print(Arrays.toString(arr));
    }

    public static void playerTurn() {

    }
}
