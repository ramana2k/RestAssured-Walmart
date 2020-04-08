package com.jsonpath.examples;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class AssertionsSearchJsonPathExample {

	static final String API_KEY = "75e3u4sgb2khg673cbv2gjup";

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";

	}

	/*
	 * Extaract the num items
	 */
	@Test
	public void test001() {
		given().queryParam("query", "ipod").queryParam("format", "json").queryParam("apiKey", API_KEY).get("/search")
				.then().body("numItems", equalTo(10));
		// .extract().path("numItems");

	}

	/*
	 * Extracting the Query value
	 */

	@Test
	public void test002() {
		given().queryParam("query", "ipod").queryParam("format", "json").queryParam("apiKey", API_KEY).get("/search")
				.then().body("query", equalTo("ipod"));

	}
	
	@Test
	public void test003() {
		given().queryParam("query", "ipod").queryParam("format", "json").queryParam("apiKey", API_KEY).get("/search")
				.then().body("items.name", hasItem("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)"));

	}
	
	@Test
	public void test004() {
		given().queryParam("query", "ipod").queryParam("format", "json").queryParam("apiKey", API_KEY).get("/search")
				.then().body("items.name", hasItems("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)","Apple iPod touch 7th Generation 128GB - Gold (New Model)"));

	}

 }
