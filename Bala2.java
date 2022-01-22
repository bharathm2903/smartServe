//Tool used Spring Tool Suite.
//Dependencies imported 
//        <dependency>
//			<groupId>com.googlecode.json-simple</groupId>
//			<artifactId>json-simple</artifactId>
//			<version>1.1.1</version>
//		  </dependency>
//This dependency helps to get features related to json.
package com.example.restful;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Bala2 {

    public static void main(String[] args) {
        try {

            URL u = new URL("https://s3.amazonaws.com/open-to-cors/assignment.json");

            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //fetching response code
            int responsecode=conn.getResponseCode();

            if (responsecode!=200 || responsecode!=400) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String a ="";
                //open stream helps to read the content of the url
                Scanner b=new Scanner(u.openStream());

                //Convert JSON data into a string using a scanner
                while(b.hasNext()) {
                    a+=b.nextLine();
                }
                //parse the string into a json object
                JSONParser parse=new JSONParser();
                JSONObject data_obj=(JSONObject) parse.parse(a);
                JSONObject pro= ((Object) data_obj).getJSONObject("songs");
                Iterator x = pro.keySet();
                JSONArray jsonArray = new JSONArray();

                while (x.hasNext()){
                    String key = (String) x.next();
                    jsonArray.put(songs.get(key));
                }
                
                JSONObject obj=(JSONObject) data_obj.get("products");
                	for(int i=0;i<obj.size();i++) {
                		System.out.println("Sub Category of the product:"+obj.get("subcatagory"));
                		System.out.println("Title of the product:"+obj.get("title"));
                		System.out.println("Price of the product:"+obj.get("price"));
                		System.out.println("Popularity of the product:"+obj.get("popularity"));
                	}
      
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}