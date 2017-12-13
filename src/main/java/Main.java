import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

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


    public static void main(String[] args){
        Twitter twitter = createInstance();


    }
}
