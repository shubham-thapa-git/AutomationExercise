package com.shubham.tests.api;


/*Scenario: Create User → Create Post → Add Comment
 
Base URL: https://jsonplaceholder.typicode.com
 
Create a New User
Method: POST
Endpoint: /users
Purpose: Simulate user registration
Request body: { "name": "John Doe", "username": "johndoe", "email": "john@example.com" }
            Expected Output: { "id": 11, "name": "John Doe", "username": "johndoe", "email": "john@example.com" }
 
Create a Post
Method: POST
Endpoint: /posts
Purpose: Simulate user creating a post
Request body: { "userId": <User Id from step 1>, "title": "My First Post", "body": "This is the content of the post." }
Expected Output: { "id": 101, "userId": 11, "title": "My First Post", "body": "This is the content of the post." }
 
Add a Comment
Method: POST
Endpoint: POST /comments
Purpose: Simulate user commenting on their post
Request body: { "postId": <Post Id from step 2>, "name": "John", "email": john@example.com, "body": "This is a comment on my own post." } */
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example {
    

        @Test
        public void createUserPostAndComment(){

            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

            Map<String, Object> userBody = new HashMap<>();
            userBody.put("name","John Doe");
            userBody.put("username", "johndoe");
            userBody.put("email", "john@example.com");
            
            Response userResponse = 
            given()
            .header("Content-Type", "application/json")
            .body(userBody)
            .when()
            .post("/users")
            .then()
            .statusCode(201).extract().response();

            int userId = userResponse.jsonPath().getInt("id");

            Assert.assertEquals(userResponse.jsonPath().getString("name"), "John Doe");

            System.out.println("User ID: " + userId);

            Map<String,Object> postBody = new HashMap<>();
            postBody.put("userId", userId);
            postBody.put("title", "My First Post");
            postBody.put("body", "This is the content of the post.");


            Response postResponse = 
                 given()
                        .when()
                        .header("Content-Type","application/json")
                        .body(postBody)
                        .post("/posts")
                        .then()
                        .statusCode(201).extract().response();

            int postId = postResponse.jsonPath().getInt("id");

            Assert.assertEquals(postResponse.jsonPath().getString("body"),"This is the content of the post." );
            System.out.println("PostId is: "+ postId);

            Map<String, Object> commentBody = new HashMap<>();
            commentBody.put("postId",postId);
            commentBody.put("name","John");
            commentBody.put("email","john@example.com");
            commentBody.put("body","This is a comment on my own post.");

            Response commentResponse = 
                given()
                .header("Content-Type","application/json")
                .body(commentBody)
                .when()
                .post("/comments")
                .then()
                .statusCode(201)
                .extract()
                .response();

            String comment = commentResponse.jsonPath().getString("body");
            Assert.assertEquals(commentResponse.jsonPath().getString("body"), comment);
            System.out.println(commentResponse.asPrettyString());
        }

        
        
    


    }
