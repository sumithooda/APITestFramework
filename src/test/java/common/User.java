package common;

import com.google.gson.JsonObject;

/**
 * Pojo class for User call
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private JsonObject address;
    private String phone;
    private String website;
    private JsonObject company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public JsonObject getAddress() {
       return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public JsonObject getCompany() {
        return company;
    }
}
