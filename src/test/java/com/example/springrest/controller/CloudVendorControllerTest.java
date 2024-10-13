package com.example.springrest.controller;


import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CloudVendorControllerTest {

    private String baseUrl = "http://localhost:8080/cloudvendor/";

    @Test
    public void getCloudVendorDetailsTest() {
        String vendorTd = "1";
        given().get(baseUrl + vendorTd)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getAllCloudVendorDetailsTest() {
        given().get(baseUrl)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void createCloudVendorDetailsTest() throws JsonProcessingException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("vendorId", "2");
        requestBody.put("vendorName", "Google");
        requestBody.put("vendorAddress", "Banglore");
        requestBody.put("vendorPhoneNumber", "234567");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyAsString = objectMapper.writeValueAsString(requestBody);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBodyAsString)
                .post(baseUrl)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void updateCloudVendorDetailsTest() throws JsonProcessingException {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("vendorId", "2");
        requestBody.put("vendorName", "Google");
        requestBody.put("vendorAddress", "Banglore");
        requestBody.put("vendorPhoneNumber", "234568");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyAsString = objectMapper.writeValueAsString(requestBody);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBodyAsString)
                .put(baseUrl)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void deleteCloudVendorDetailsTest() {
        String vendorId = "2";
        given()
                .delete(baseUrl + vendorId)
                .then()
                .statusCode(200)
                .log().all();
    }
}
