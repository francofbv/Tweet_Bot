// Franco Vidal
// CSE 122
// TA: Elizabeth Shirakian
// 5/30/2023
// 
// This program puts all of the tweets from the tweets.txt file and puts them into a tweetBot.
// it also demonstrates what the tweetBot and twitterTrends classes allow the user to do.

import java.util.*;
import java.io.*;

public class TwitterMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("tweets.txt")); // Make Scanner over tweet file
        List<String> tweets = new ArrayList<>();
        while (input.hasNextLine()) { // Add each tweet in file to List
            tweets.add(input.nextLine());
        }

        TweetBot bot = new TweetBot(tweets); // Create TweetBot object with list of tweets
        TwitterTrends trends = new TwitterTrends(bot); // Create TwitterTrends object
    


    bot.addTweet("Tweet number 1");
    System.out.println(bot.numTweets());
    for (int i = 0; i < 5; i++) {
        System.out.println(bot.nextTweet());
    }
    bot.removeTweet("A tweet about something controversial");
    System.out.println("The most frequent word among all the tweets is: " + trends.getMostFrequentWord());
    System.out.println("The least frequent word among all the tweets is: " + trends.getLeastFrequentWord());
    bot.reset();
    }
}
