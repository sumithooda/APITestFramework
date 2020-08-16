package tests;

import common.Comments;
import common.Posts;
import common.TestBase;
import common.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import utility.CommonActions;

public class IntegrationTest extends TestBase {
    User[] user;
    Posts[] posts;
    Comments[] comments;

    /**
     * Fetching user details based on test data
     */
    @Test(priority = 1)
    public void findUser() {
        Response response = CommonActions.performGet(CommonActions.userContext, "username", userName);
        response.then().statusCode(200);
        user = response.getBody().as(User[].class);
        Assert.assertTrue(user.length == 1, "More than one user is present with " + userName);
        System.out.println(user[0].getUserName());
    }

    /**
     * Fetching posts for user
     */
    @Test(priority = 2, dependsOnMethods = {"findUser"})
    public void getPosts() {
        Response response = CommonActions.performGet(CommonActions.PostContext, "userId", user[0].getId());
        response.then().statusCode(200);

        posts = response.getBody().as(Posts[].class);
        Assert.assertEquals(posts[0].getUserId(),Integer.parseInt(userId),"User id for "+userName+"is not correct");
        System.out.println("Number of posts available for user " + userName + " are " + posts.length);
    }

    /**
     * Validating comments for each post belongs to mentioned user
     */
    @Test(priority = 3, dependsOnMethods = {"getPosts"})
    public void getComments() {
        for (Posts currentPosts : posts) {
            Response response = CommonActions.performGet(CommonActions.commentContext, "postId", currentPosts.getId());
            response.then().statusCode(200);
            comments = response.getBody().as(Comments[].class);
            System.out.println("total commnets on post " + currentPosts.getId() + " = " + comments.length);
            for (Comments currentComments : comments) {
                System.out.println("Email for post " + currentComments.getPostId() + " with comment id = " + currentComments.getId() + " " + currentComments.getEmail());
                Assert.assertTrue(CommonActions.validateEmail(currentComments.getEmail()), "email is not in valid format for Post id = "
                        + currentComments.getPostId() + " comment id = " + currentComments.getId());
            }

        }

    }
}
