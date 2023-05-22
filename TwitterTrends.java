import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwitterTrends {
private TweetBot newBot;

    // Constructor
    public TwitterTrends(TweetBot bot) {
        this.newBot = bot;
    }

    // Methods
    public String getMostFrequentWord() {
        if (newBot.numTweets() == 1) {
            String tweet = newBot.nextTweet().toLowerCase();
            return tweet;
        }
        Map<String, Integer> m = new HashMap<>();
        int max = 0;
        String maxWord = "";
        while (newBot.numTweets() > 0) {
            String tweet = newBot.nextTweet().toLowerCase();
            newBot.removeTweet(tweet);
            Scanner scanner = new Scanner(tweet);
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
        return maxWord; 
    }

    public String getLeastFrequentWord() {
       if (newBot.numTweets() == 1) {
            String tweet = newBot.nextTweet().toLowerCase();
            return tweet;
       } 
       Map<String, Integer> m = new HashMap<>();
       int min = 99999;
       String minWord = "";
       while(newBot.numTweets() > 0) {
            String tweet = newBot.nextTweet().toLowerCase();
            Scanner scanner = new Scanner(tweet);
            while (scanner.hasNext()) {
                String current = scanner.next();
                if (!m.containsKey(current)) {
                    m.put(current, 1);
                } else {
                    m.put(current, m.get(current) + 1);
                }
                if (m.get(current) < min) {
                    min = m.get(current);
                    minWord = current;
                }
            }
       }
       return minWord;
    }
}