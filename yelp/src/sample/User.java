package sample;

/**
 * contains the components for the user
 */
public class User {

    private String user_id;
    private String name;
    private int review_count;
    private String yelping_since;
    private int fans;
    private String elite;
    private double average_stars;

    public User() {

    }

    /**
     * sets the user_id
     *
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * gets the user_id
     *
     * @return
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * sets the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * gets the review count
     *
     * @return
     */
    public int getReview_count() {
        return review_count;
    }

    /**
     * sets the review count
     *
     * @param review_count
     */
    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    /**
     * sets the number of years a user has utilized Yelp
     *
     * @param yelping_since
     */
    public void setYelping_since(String yelping_since) {
        this.yelping_since = yelping_since;
    }

    /**
     * gets the number of years a user has utilized Yelp
     *
     * @return
     */
    public String getYelping_since() {
        return yelping_since;
    }

    /**
     * sets the number of fans a user has
     *
     * @param fans
     */
    public void setFans(int fans) {
        this.fans = fans;
    }

    /**
     * gets the number of fans a user has
     *
     * @return
     */
    public int getFans() {
        return fans;
    }

    /**
     * sets the user to be an Elite Yelp user
     *
     * @param elite
     */
    public void setElite(String elite) {
        this.elite = elite;
    }

    /**
     * gets the Elite Yelp user
     *
     * @return
     */
    public String getElite() {
        return elite;
    }

    /**
     * sets the average stars
     *
     * @param average_stars
     */
    public void setAverage_stars(double average_stars) {
        this.average_stars = average_stars;
    }

    /**
     * gets the average stars
     *
     * @return
     */
    public double getAverage_stars() {
        return average_stars;
    }
}
