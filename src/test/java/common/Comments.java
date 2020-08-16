package common;

/**
 * Pojo class for Comment response
 */
public class Comments {

    /**
     * attribute to store values from get comment response
     */
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
