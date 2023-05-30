// Franco Vidal
// CSE 122
// TA: Elizabeth Shirakian
// 5/30/2023
// 
// this class allows the user to use the get most and least frequent methods in the twitter main class.
// it takes tweets from the designated tweet bot.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class TwitterTrends {
private TweetBot newBot;

/*
* This constructor initializes a given tweetBot to a new tweetBot with the same values
* Exceptions
*    - None
* Parameters:
*    - bot: tweetBot given by the user
* Returns:
*    - None
*/
    public TwitterTrends(TweetBot bot) {
        this.newBot = bot;
    }

/*
* This method finds the word that occurs most frequently in all of the tweets in the tweetBot
* Exceptions
*    - None
* Parameters:
*    - None
* Returns:
*    - The word that occurs most frequently in all of the given tweets in tweetBot
*/
    public String getMostFrequentWord() {
        if (newBot.numTweets() == 1) {
            String tweet = newBot.nextTweet().toLowerCase();
            return tweet;
        }
        Map<String, Integer> m = new HashMap<>();
        int max = 0;
        String maxWord = "";
        int initialNumTweets = newBot.numTweets();
        Queue<String> temp = new LinkedList<>();
        while (newBot.numTweets() > 0) {
            String currentTweet = newBot.nextTweet();
            temp.add(currentTweet);
            newBot.removeTweet(currentTweet);
            currentTweet = currentTweet.toLowerCase();
            Scanner scanner = new Scanner(currentTweet);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (!m.containsKey(current)) {
                    m.put(current, 1);
                } else {
                    m.put(current, m.get(current) + 1);
                }
                if (m.get(current) > max) {
                    max = m.get(current);
                    maxWord = current;
                }
            }
        }
        while (!temp.isEmpty()) {
            newBot.addTweet(temp.remove());
        }
        return maxWord; 
    }

/*
* This method finds the word that occurs least frequently in all of the tweets in the tweetBot
* Exceptions
*    - None
* Parameters:
*    - None
* Returns:
*    - The word that occurs least frequently in all of the given tweets in tweetBot
*/
    public String getLeastFrequentWord() {
        if (newBot.numTweets() == 1) {
            String tweet = newBot.nextTweet().toLowerCase();
            return tweet;
        }
        Map<String, Integer> m = new HashMap<>();
        int min = 99999;
        String minWord = "";
        Queue<String> temp = new LinkedList<>();
        while (newBot.numTweets() > 0) {
            String currentTweet = newBot.nextTweet();
            temp.add(currentTweet);
            newBot.removeTweet(currentTweet);
            currentTweet = currentTweet.toLowerCase();
            Scanner scanner = new Scanner(currentTweet);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (!m.containsKey(current)) {
                    m.put(current, 1);
                } else {
                    m.put(current, m.get(current) + 1);
                }
            }
        }
        for (String word : m.keySet()) {
            if (m.get(word) < min) {
                min = m.get(word);
                minWord = word;
            }
        }
        while (!temp.isEmpty()) {
            newBot.addTweet(temp.remove());
        }
        return minWord;
    }
}