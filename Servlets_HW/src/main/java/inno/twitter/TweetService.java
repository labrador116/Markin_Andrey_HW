package inno.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    private static int ids = 0;
    private List<Tweet> tweets = new ArrayList<Tweet>();
    private static TweetService service;

    private TweetService(){}

    public List<Tweet> getAll() {
        return tweets;
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        return tweets.add(tweet);
    }

    public static TweetService getTweetService(){
        if(service==null){
            service=new TweetService();
        }
        return service;
    }


    public Tweet getById(int id) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }

}
