package sample;

/**
 * Has all the components for the Business
 */
public class Business {

    private String business_id;
    private String name;
    private String city;
    private String state;
    private double stars;
    private int review_count;
    private int is_open;
    private String categories;

    public Business(String business_id, String name, double stars) {
        this.business_id = business_id;
        this.name = name;
        this.stars = stars;
    }

    /**
     * gets Businnes_ID
     * @return
     */
    public String getBusiness_id() {
        return business_id;
    }

    /**
     * Sets the Business_ID
     * @param business_id
     */
    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }
    /**
     * gets name of User
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the User
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * gets the city in which the business is in
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * sets the city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * gets the state in which the business is in
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * sets the state
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * gets the number of stars that the business has recieved
     * @return
     */
    public double getStars() {
        return stars;
    }

    /**
     * sets the stars
     * @param stars
     */
    public void setStars(double stars) {
        this.stars = stars;
    }

    /**
     * gets the review count
     * @return
     */
    public int getReview_count() {
        return review_count;
    }

    /**
     * sets the review count
     * @param review_count
     */
    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    /**
     * gets the int 0 or 1 to represent whether the business is open or not
     * @return
     */
    public int getIs_open() {
        return is_open;
    }

    /**
     * sets whether business is open or not
     * @param is_open
     */
    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }

    /**
     * gets the categories of businesses
     * @return
     */
    public String getCategories() {
        return categories;
    }

    /**
     * sets the categories of businesses
     * @param categories
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }
}
