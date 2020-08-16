package common;

import com.google.gson.JsonObject;

/**
 * Pojo class for User call
 */
public class User {
    public int id;
    public String name;
    public String username;
    public String email;
    public JsonObject address;
    public String phone;
    public String website;
    public JsonObject company;

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
