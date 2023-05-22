import java.util.ArrayList;
import java.util.List;

public class TweetBot {

// vars (temp)
private List<String> newTweets;
private int index = 0;

// Constructors
public TweetBot(List<String> tweets) {
    if (tweets.size() < 1) {
        throw new IllegalArgumentException();
    }
    newTweets = new ArrayList<>();
    for (String tweet : tweets ) {
        newTweets.add(tweet);
    }
}

// Methods
public int numTweets() {
    return newTweets.size();
}

public void addTweet(String tweet) {
    newTweets.add(tweet);
}
    
public String nextTweet() {
    if (index >= newTweets.size()) {
        index = 0;
    }
    String currentTweet = newTweets.get(index);
    index++;
    return currentTweet;
}

public void removeTweet(String tweet) {
    if (newTweets.contains(tweet)) {
        int removedIndex = newTweets.indexOf(tweet);
        newTweets.remove(removedIndex);
        if (removedIndex < index) {
            index--;
        }
    }
}

public void reset() {
    index = 0;
}
}   