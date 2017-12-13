import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Twitter createInstance(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("I4hXsAS3v7ybDN62AAUSosofZ")
                .setOAuthConsumerSecret("PAvCA4aKXL96k72iHPKLUVgtAKN2KxmPMtgJpVh7emkRFihBBa")
                .setOAuthAccessToken("911684699218513921-gyTcbKBzd9ZgtxYHVI6cLocrogD438b")
                .setOAuthAccessTokenSecret("Eo0Rta62aM0QMcciuKc5XhzzvSc22jblSu2Zm4yn02iAu");
        TwitterFactory tf = new TwitterFactory(cb.build());

        return tf.getInstance();
    }

    public static String createTweet(String tweet) throws TwitterException{
        Twitter twitter = createInstance();
        Status status = twitter.updateStatus("Test with twitter 4j");
        return status.getText();

    }

    public static List<User> getUserFriends(String username) throws TwitterException{
        long cursor = -1;
        Twitter twitter = createInstance();
        List<User> users = new ArrayList<User>();
        try{
            users = twitter.getFriendsList(username, cursor, 200);
        }
        catch (TwitterException e){
            e.printStackTrace();
        }

        return users;
    }
    public static void printUsernames(List<User> users){
        for(User user: users){
            System.out.println("\t\t" + user.getName());
        }
    }

    public static void getFriendsOfFriends(String username) throws TwitterException{
        List<User> users = getUserFriends(username);
        System.out.print("\t\t" + username + "'s friends:");
        printUsernames(users);
    }



    public  static void main(String[] args){
        String test = "This is  a test of the twitter4j";
        String result = "Bullshit";
        String username = "realDonaldTrump";
        try{
            List<User> users = getUserFriends(username);
            System.out.println(username + "'s friends:");
            printUsernames(users);
            for(User user: users){
                getFriendsOfFriends(user.getScreenName());
                Thread.sleep(2000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
