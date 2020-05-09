package sample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class JsonToSql {

    private static Connection connect() {
        String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/yelpdb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private static void transferReviews(Connection con, JSONParser jsonParser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/elizaneiman-golden/Desktop/yelp_academic_dataset_review.json"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO review VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject record = (JSONObject) jsonParser.parse(line);
                String review_id = (String) record.get("review_id");
                String user_id = (String) record.get("user_id");
                String business_id = (String) record.get("business_id");
                double stars = Double.parseDouble(String.valueOf(record.get("stars")));
                String date = (String) record.get("date");
                String text = (String) record.get("text");
                int useful = Integer.parseInt(String.valueOf(record.get("useful")));
                int funny = Integer.parseInt(String.valueOf(record.get("funny")));
                int cool = Integer.parseInt(String.valueOf(record.get("cool")));
                pstmt.setString(1, review_id);
                pstmt.setString(2, user_id);
                pstmt.setString(3, business_id);
                pstmt.setDouble(4, stars);
                pstmt.setString(5, date);
                pstmt.setString(6, text);
                pstmt.setInt(7, useful);
                pstmt.setInt(8, funny);
                pstmt.setInt(9, cool);
                pstmt.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void transferBusinesses(Connection con, JSONParser jsonParser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Volumes/DrivingEliza/yelp_dataset/yelp_academic_dataset_business.json"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO business VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject record = (JSONObject) jsonParser.parse(line);
                String business_id = (String) record.get("business_id");
                String name = (String) record.get("name");
                String city = (String) record.get("city");
                String state = (String) record.get("state");
                double stars = Double.parseDouble(String.valueOf(record.get("stars")));
                int review_count = Integer.parseInt(String.valueOf(record.get("review_count")));
                int is_open = Integer.parseInt(String.valueOf(record.get("is_open")));
                String categories = (String) record.get("categories");
                pstmt.setString(1, business_id);
                pstmt.setString(2, name);
                pstmt.setString(3, city);
                pstmt.setString(4, state);
                pstmt.setDouble(5, stars);
                pstmt.setInt(6, review_count);
                pstmt.setInt(7, is_open);
                pstmt.setString(8, categories);
                pstmt.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void transferUsers(Connection con, JSONParser jsonParser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Volumes/DrivingEliza/yelp_dataset/yelp_academic_dataset_user.json"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject record = (JSONObject) jsonParser.parse(line);
                String user_id = (String) record.get("user_id");
                String name = (String) record.get("name");
                int review_count = Integer.parseInt(String.valueOf(record.get("review_count")));
                String yelping_since = (String) record.get("yelping_since");
                int useful = Integer.parseInt(String.valueOf(record.get("useful")));
                int funny = Integer.parseInt(String.valueOf(record.get("funny")));
                int cool = Integer.parseInt(String.valueOf(record.get("cool")));
                int fans = Integer.parseInt(String.valueOf(record.get("fans")));
                String elite = (String) record.get("elite");
                double average_stars = Double.parseDouble(String.valueOf(record.get("average_stars")));
                int compliment_hot = Integer.parseInt(String.valueOf(record.get("compliment_hot")));
                int compliment_more = Integer.parseInt(String.valueOf(record.get("compliment_more")));
                int compliment_profile = Integer.parseInt(String.valueOf(record.get("compliment_profile")));
                int compliment_cute = Integer.parseInt(String.valueOf(record.get("compliment_cute")));
                int compliment_list = Integer.parseInt(String.valueOf(record.get("compliment_list")));
                int compliment_note = Integer.parseInt(String.valueOf(record.get("compliment_note")));
                int compliment_plain = Integer.parseInt(String.valueOf(record.get("compliment_plain")));
                int compliment_cool = Integer.parseInt(String.valueOf(record.get("compliment_cool")));
                int compliment_funny = Integer.parseInt(String.valueOf(record.get("compliment_funny")));
                int compliment_writer = Integer.parseInt(String.valueOf(record.get("compliment_writer")));
                int compliment_photos = Integer.parseInt(String.valueOf(record.get("compliment_photos")));

                pstmt.setString(1, user_id);
                pstmt.setString(2, name);
                pstmt.setInt(3, review_count);
                pstmt.setString(4, yelping_since);
                pstmt.setInt(5, useful);
                pstmt.setInt(6, funny);
                pstmt.setInt(7, cool);
                pstmt.setInt(8, fans);
                pstmt.setString(9, elite);
                pstmt.setDouble(10, average_stars);
                pstmt.setInt(11, compliment_hot);
                pstmt.setInt(12, compliment_more);
                pstmt.setInt(13, compliment_profile);
                pstmt.setInt(14, compliment_cute);
                pstmt.setInt(15, compliment_list);
                pstmt.setInt(16, compliment_note);
                pstmt.setInt(17, compliment_plain);
                pstmt.setInt(18, compliment_cool);
                pstmt.setInt(19, compliment_funny);
                pstmt.setInt(20, compliment_writer);
                pstmt.setInt(21, compliment_photos);

                pstmt.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void transferTips(Connection con, JSONParser jsonParser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Volumes/DrivingEliza/yelp_dataset/yelp_academic_dataset_tip.json"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tip VALUES (?, ?, ?, ?, ?)");
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject record = (JSONObject) jsonParser.parse(line);
                String text = (String) record.get("text");
                String date = (String) record.get("date");
                int compliment_count = Integer.parseInt(String.valueOf(record.get("compliment_count")));
                String business_id = (String) record.get("business_id");
                String user_id = (String) record.get("user_id");
                pstmt.setString(1, text);
                pstmt.setString(2, date);
                pstmt.setInt(3, compliment_count);
                pstmt.setString(4, business_id);
                pstmt.setString(5, user_id);
                pstmt.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void transferCheckins(Connection con, JSONParser jsonParser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Volumes/DrivingEliza/yelp_dataset/yelp_academic_dataset_checkin.json"));
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO checkin VALUES (?, ?)");
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject record = (JSONObject) jsonParser.parse(line);
                String business_id = (String) record.get("business_id");
                String date = (String) record.get("date");
                pstmt.setString(1, business_id);
                pstmt.setString(2, date);
                pstmt.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Connection con = connect();
        JSONParser jsonParser = new JSONParser();
        //transferReviews(con, jsonParser);
        //transferBusinesses(con, jsonParser);
        //transferUsers(con, jsonParser);
        //transferTips(con, jsonParser);
        //transferCheckins(con, jsonParser);
    }
}
