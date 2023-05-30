// Franco Vidal
// CSE 122
// TA: Elizabeth Shirakian
// 5/30/2023
// 
// This class allows the user to create a tweetbot that takes in tweets, delete tweets, find the
// total number of tweets, view the next tweets, or reset the list of tweets

import java.util.ArrayList;
import java.util.List;

public class TweetBot {

// fields
    private List<String> newTweets;
    private int index = 0;

/*
* This constructor defines a new List that coppies the values of the given tweets List
* Exceptions
*    - throws an IllegalArgumentException if the size of the given list is less than one
* Parameters:
*    - tweets: given List of tweets
* Returns:
*    - None
*/
    public TweetBot(List<String> tweets) {
        if (tweets.size() < 1) {
            throw new IllegalArgumentException();
        }
        newTweets = new ArrayList<>();
        for (String tweet : tweets ) {
            newTweets.add(tweet);
        }
    }

/*
* This method determines the amount of tweets in the current tweet List
* Exceptions
*    - None
* Parameters:
*    - None
* Returns:
*    - returns the size of the current tweet List
*/
    public int numTweets() {
        return newTweets.size();
    }

/*
* This method allows the user to add a tweet to the end of the current tweet List
* Exceptions
*    - None
* Parameters:
*    - tweet: String given by the user of the tweet they want to add to the List
* Returns:
*    - None
*/
    public void addTweet(String tweet) {
        newTweets.add(tweet);
    }
        
/*
* This method finds the next tweet in the tweet List. once the list has been exhaustedm it will start
* from the beginning of the list. if a tweet is added after the list has been exhausted, that tweet will
* be returned before recycling.
* Exceptions
*    - 
* Parameters:
*    - 
* Returns:
*    - 
*/
    public String nextTweet() {
        if (index >= newTweets.size()) {
            index = 0;
        }
        String currentTweet = newTweets.get(index);
        index++;
        return currentTweet;
    }

/*
* This method removes a given tweet from the tweet List
* Exceptions
*    - None
* Parameters:
*    - tweet: String of the given tweet to remove from the user
* Returns:
*    - None
*/
    public void removeTweet(String tweet) {
        if (newTweets.contains(tweet)) {
            int removedIndex = newTweets.indexOf(tweet);
            newTweets.remove(removedIndex);
            if (removedIndex < index) {
                index--;
            }
        }
    }

/*
* This method resets the state of the nextTweet counter so it will start from the beginning on the next call of
* nextTweet
* Exceptions
*    - None
* Parameters:
*    - None
* Returns:
*    - None
*/
    public void reset() {
        index = 0;
    }
}   
