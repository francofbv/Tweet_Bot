import java.util.ArrayList;
import java.util.List;

public class TweetBotTest {
    public static void main(String[] args) {
        // Write any testing code here to test your TweetBot
        List<String> tweets = new ArrayList<>();
        tweets.add("test");
        TweetBot bot = new TweetBot(tweets);
        // tweets.add("tweet1");
        // tweets.add("tweet2");
        // System.out.println(bot.nextTweet());
        // tweets.add("tweet3");
        bot.addTweet("test 1");
        bot.addTweet("test 2");
        bot.addTweet("test 3");
        bot.addTweet("test 4");
        bot.addTweet("test 5");
        System.out.println(bot.numTweets());
        System.out.println(bot.nextTweet());
        System.out.println(bot.nextTweet());
        System.out.println(bot.nextTweet());
        bot.reset();
        System.out.println(bot.numTweets());
        System.out.println(bot.nextTweet());
        

        
        
        
        // TweetBot bot = new TweetBot(tweets);
        // System.out.println(bot.numTweets());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        // bot.removeTweet("Tweet4");
        // bot.addTweet("NewTweet!");
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        // System.out.println(bot.nextTweet());
        
        
        TwitterTrends newBot = new TwitterTrends(bot);
        System.out.println(newBot.getMostFrequentWord());
    }
}
