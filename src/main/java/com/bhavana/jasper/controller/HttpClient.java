package com.bhavana.jasper.controller;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.bhavana.jasper.data.Getdata;
import com.bhavana.jasper.data.EmployeeData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClient {
	    // one instance, reuse
	    private final CloseableHttpClient httpClient = HttpClients.createDefault();

	    public void close() throws IOException {
	        httpClient.close();
	    }

	    public ArrayList<EmployeeData> sendGet() throws Exception {
	    	ArrayList<EmployeeData> list = new ArrayList<EmployeeData>();
	    	
	    	HttpGet request = new HttpGet("http://dummy.restapiexample.com/api/v1/employees");
	    	
	        // add request headers
//	        request.addHeader("custom-key", "bhavana");
//	        request.addHeader(HttpHeaders.USER_AGENT, "agent");

	        try (CloseableHttpResponse response = httpClient.execute(request)) {

	            // Get HttpResponse Status
	            System.out.println(response.getStatusLine().toString());

	            HttpEntity entity = response.getEntity();
//	            Header headers = entity.getContentType();
//	            System.out.println("headers --> "+headers);

	            if (entity != null) {
	                // return it as a String
	                String result = EntityUtils.toString(entity);
	                
	                Gson gson = new Gson();
	                Getdata data = gson.fromJson(result, Getdata.class);

	                System.out.println("data --> "+data);
	                
	                return data.getEdata();
	            } else {
	            	return list;
	            }
	        }
	    }

	    public void sendPost() throws Exception {

	        HttpPost post = new HttpPost("http://dummy.restapiexample.com/api/v1/create");

	        // add request parameter, form parameters
	        List<NameValuePair> urlParameters = new ArrayList<>();
	        urlParameters.add(new BasicNameValuePair("name", "bhavana"));
	        urlParameters.add(new BasicNameValuePair("salary", "10"));
	        urlParameters.add(new BasicNameValuePair("age", "30"));

	        post.setEntity(new UrlEncodedFormEntity(urlParameters));

	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
	             CloseableHttpResponse response = httpClient.execute(post)) {

	            System.out.println(EntityUtils.toString(response.getEntity()));
	        }

	    }
}
