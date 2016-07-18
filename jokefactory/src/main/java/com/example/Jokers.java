package com.example;

import java.util.Random;

public class Jokers {
    public String[] jokes;

    public Jokers(String[] jokes) {
        this.jokes=jokes;
    }

    public Jokers() {
        //jokes list
        jokes= new String[]{
                "Three guys, stranded on a desert island, find a magic lantern containing a genie, who grants them each one wish. The first guy wishes he was off the island and back home. The second guy wishes the same. The third guy says \"I’m lonely. I wish my friends were back here.\""
                , "My sister was with two men in one night. She could hardly walk after that. Can you imagine? Two dinners!"
                , "burp"
                , "burp again"
        };
    }

    public String findJoke() {
        int random= new Random().nextInt(jokes.length-1);
        return jokes[random];
    }
}
