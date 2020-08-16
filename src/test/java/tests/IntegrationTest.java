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

import static io.restassured.RestAssured.given;

public class IntegrationTest extends TestBase {
    User[] user;
    Posts[] posts;
    Comments[] comments;

    @Test(priority = 1)
    public void findUser() {
        Response response = given().queryParam("username", userName).when().get("/users");
        response.then().statusCode(200);
        user = response.getBody().as(User[].class);
        Assert.assertTrue(user.length == 1, "More than one user is present with " + userName);
        System.out.println(user[0].getUserName());


    }

    @Test(priority = 2)
    public void getPosts() {
        Response response = given().queryParam("userId", user[0].getId()).when().get("/posts");
        response.then().statusCode(200);
        posts = response.getBody().as(Posts[].class);
        System.out.println("Number of posts available for user " + userName + " are " + posts.length);
    }

    @Test(priority = 3)
    public void getComments() {
        for (Posts currentPosts : posts) {
            Response response = given().queryParam("postId", currentPosts.getId()).when().get("/comments");
            response.then().statusCode(200);
            comments = response.getBody().as(Comments[].class);
            System.out.println("total commnets on post " + currentPosts.getId() + " = " + comments.length);
            for (Comments currentComments : comments) {
                System.out.println("Email for post " + currentComments.getPostId() + " with comment id = " + currentComments.getId() + " " + currentComments.getEmail());
                Assert.assertTrue(CommonActions.validateEmail(currentComments.getEmail()), "email is not in valid format for Post id = "
                        + currentComments.getPostId() + "comment id = " + currentComments.getId());
            }

        }

    }
}
