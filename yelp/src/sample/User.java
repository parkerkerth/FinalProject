package sample;

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

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public void setYelping_since(String yelping_since) {
        this.yelping_since = yelping_since;
    }

    public String getYelping_since() {
        return yelping_since;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getFans() {
        return fans;
    }

    public void setElite(String elite) {
        this.elite = elite;
    }

    public String getElite() {
        return elite;
    }

    public void setAverage_stars(double average_stars) {
        this.average_stars = average_stars;
    }

    public double getAverage_stars() {
        return average_stars;
    }
}
