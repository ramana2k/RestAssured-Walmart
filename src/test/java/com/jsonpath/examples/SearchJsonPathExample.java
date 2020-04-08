package com.jsonpath.examples;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class SearchJsonPathExample {
	
	static final String API_KEY="75e3u4sgb2khg673cbv2gjup";
	
	
@BeforeClass	
public static void init(){
	RestAssured.baseURI="http://api.walmartlabs.com";
	RestAssured.basePath="/v1";
	
}
/*
 * Extaract the num items
 * */
@Test
public void test001()
{
	int num_items=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("numItems");
	System.out.println(" The num items are "+num_items);
	
}

/*
Extracting the Query value
 */


@Test
public void test002()
{
	String queryValue=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("query");
	System.out.println(" The queryValue are "+queryValue);
	
}

/*
Extracting the name value
 */


@Test
public void test003()
{
	String name=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items[0].name");
	System.out.println(" The name are "+name);
	
}

/*
Extracting the gift options value
 */
@Test
public void test004()
{
	HashMap<String,String> giftOptions=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items[0].giftOptions");
	System.out.println(" The giftOptions values are "+giftOptions);
	
}


/*
Extracting the size of the array list items
 */
@Test
public void test005()
{
	int size=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.size()");
	System.out.println(" The size of the items is "+size);
	
}

/*
Extracting the all the names under the items
 */
@Test
public void test006()
{
	List<String> names=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.name");
	System.out.println(" The size of the items is "+names);
	
}

/*
Extracting the all the names under the items which has got the Applie ipood touch
 */
@Test
public void test007()
{
	List<HashMap<String,Object>> Values=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.findAll{it.name='Apple iPod touch 32GB'}");
	System.out.println(" The values are : "+Values);
	
}

/*
Extracting the all sale price values
 */
@Test
public void test008()
{
	System.out.println("Getting the salPrice Values");
	List<Float> salePrice=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.findAll{it.name='Apple iPod touch 32GB'}.salePrice");
	System.out.println(" The values are : "+salePrice);
	
}

/*
Extracting the all sale price values which are less than 150
 */
@Test
public void test009()
{
	System.out.println("Getting the salPrice Values");
	List<String> names=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.findAll{it.salePrice<150}.name");
	System.out.println("<-------------starting test------------->");
	System.out.println("The list of sale price less than $150 are :"+names);

	System.out.println("<-------------Ending test------------->");

	
}

/*
Extracting all the msrp values whose name starts with 'Ref'
 */
@Test
public void test010()
{
	System.out.println("Getting the salPrice Values");
	List<String> msrp=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.findAll{it.name==~/Ref.*/}.msrp");
	System.out.println("<-------------starting test------------->");
	System.out.println("Extracting all the msrp values whose name starts with 'Ref' :"+msrp);

	System.out.println("<-------------Ending test------------->");

	
}

/*
Extracting all the sale prices of items for the name ends with el
 */
@Test
public void test011()
{
	System.out.println("Extracting all the sale prices of items for the name ends with el");
	List<String> salePrice=given()
	.queryParam("query","ipod")
	.queryParam("format","json")
	.queryParam("apiKey",API_KEY)
	.get("/search")
	.then()
	.extract().path("items.findAll{it.name==~/.* el)/}.salePrice");
	System.out.println("<-------------starting test------------->");
	System.out.println("Extracting all the sale prices of items for the name ends with el :"+salePrice);

	System.out.println("<-------------Ending test------------->");

	
}
}
