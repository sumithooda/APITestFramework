package tests;

import common.Comments;
import common.Posts;
import common.TestBase;
import common.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class IntegrationTest extends TestBase {
    User[] user;
    Posts[] posts;
    Comments[] comments;

    @Test
    public void findUser() {
        Response response = given().queryParam("username", userName).when().get("/users");
        response.then().statusCode(200);
        user = response.getBody().as(User[].class);
        System.out.println(user[0].getUserName());
    }

    @Test
    public void getPosts() {
        Response response = given().queryParam("userId", 5).when().get("/posts");
        response.then().statusCode(200);
        posts = response.getBody().as(Posts[].class);
        System.out.println(posts.length);
    }

    @Test
    public void getComments() {
        Response response = given().queryParam("postId", 41).when().get("/comments");
        response.then().statusCode(200);
        comments = response.getBody().as(Comments[].class);
        System.out.println(comments.length);
        System.out.println(comments[0].getPostId());
        System.out.println(comments[0].getId());
        System.out.println(comments[0].getName());
        System.out.println(comments[0].getEmail());
        System.out.println(comments[0].getBody());

    }
}
