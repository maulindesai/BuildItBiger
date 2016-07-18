package com.example;

import org.junit.Test;

import java.util.Random;

public class JokersTest {

   @Test
    public void jokeTest(){
       //jokes list
       String[] jokes={
               "Three guys, stranded on a desert island, find a magic lantern containing a genie, who grants them each one wish. The first guy wishes he was off the island and back home. The second guy wishes the same. The third guy says \"I’m lonely. I wish my friends were back here.\""
               ,"My sister was with two men in one night. She could hardly walk after that. Can you imagine? Two dinners!"
               ,"burp"
               ,"burp again","hihihihihi"
       };

       Jokers jokers=new Jokers(jokes);
       assert jokers.findJoke() !=null;
   }
}
