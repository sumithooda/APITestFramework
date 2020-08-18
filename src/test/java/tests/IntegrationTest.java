package tests;

import common.Comments;
import common.Posts;
import common.TestBase;
import common.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utility.CommonActions;

public class IntegrationTest extends TestBase {
    //Pojo class objects @global to use throughout test class
    User[] user;
    Posts[] posts;
    Comments[] comments;

    /**
     * Fetching user details based on test data
     */
    @Test
    public void findUser() {
        Response response = CommonActions.performGet(prop.get("contextUser"), "username", userName);
        response.then().statusCode(200);
        user = response.getBody().as(User[].class);
        Assert.assertTrue(user.length == 1, "More than one user is present with " + userName);
        Assert.assertTrue(!user[0].getAddress().isJsonNull(),"Address is empty");
        Assert.assertTrue(!user[0].getCompany().isJsonNull(),"company is empty");
    }

    /**
     * Fetching posts for user
     */
    @Test(dependsOnMethods = {"findUser"})
    public void getPosts() {
        Response response = CommonActions.performGet(prop.get("contextPost"), "userId", user[0].getId());
        response.then().statusCode(200);
        posts = response.getBody().as(Posts[].class);
        Assert.assertTrue(!(posts[0].getId()==0),"Id is not available for "+user[0].getId());
        Assert.assertTrue(!(posts[0].getBody()==null),"Body is not available for "+posts[0].getId());
        Reporter.log("Number of posts available for user " + userName + " are " + posts.length,true);
    }

    /**
     * Validating comments for each post belongs to mentioned user
     */
    @Test(dependsOnMethods = {"getPosts"})
    public void getComments() {
        for (Posts currentPosts : posts) {
            Response response = CommonActions.performGet(prop.get("contextComments"), "postId", currentPosts.getId());
            response.then().statusCode(200);
            comments = response.getBody().as(Comments[].class);
            Reporter.log("total commnets on post " + currentPosts.getId() + " = " + comments.length,true);
            for (Comments currentComments : comments) {
                Assert.assertTrue(!(currentComments.getBody()==null),"body is empty for "+currentComments.getPostId());
                Assert.assertTrue(!(currentComments.getPostId()==0),"post id is not available");
                Assert.assertTrue(CommonActions.validateEmail(currentComments.getEmail()), "email is not in valid format for Post id = "
                        + currentComments.getPostId() + " comment id = " + currentComments.getId());
            }
        }
    }
}
