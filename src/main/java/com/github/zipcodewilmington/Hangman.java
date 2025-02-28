package com.github.zipcodewilmington;


import org.w3c.dom.ls.LSOutput;
/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    //Isaac Mills-Owoo
    public static void main(String[] args) {
        System.out.println("Let's Play Guess the Word version 1.0");
        Wordguess game = new Wordguess();
        game.runGame();
    }
}
