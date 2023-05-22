import java.util.*;

public class TweetBotTest {
    public static void main(String[] args) {
        // Write any testing code here to test your TweetBot
        List<String> tweets = new ArrayList<>();
        tweets.add("tweet1");
        tweets.add("tweet2");
        tweets.add("tweet3");
        tweets.add("tweet4");
        tweets.add("tweet5");
        TweetBot bot = new TweetBot(tweets);
        // System.out.println(bot.numTweets());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        TwitterTrends newBot = new TwitterTrends(bot);
        bot.removeTweet("Tweet4");
        bot.addTweet("NewTweet!");
        System.out.println(bot.nextTweet());
        System.out.println(bot.nextTweet());
        System.out.println(bot.nextTweet());
        System.out.println(bot.nextTweet());
        
        
        System.out.println(newBot.getMostFrequentWord());
        
    }
}
