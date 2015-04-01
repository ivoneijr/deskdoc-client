package br.com.senac.sd.deskdoc.main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import br.com.senac.sd.deskdoc.converter.DocumentConverter;
import br.com.senac.sd.deskdoc.model.Document;

public class Main extends Thread{

	
	public static void main(String[] args) {
		(new Main()).start();
	}
	
	public void run(){
		while(true){
			
			try {
				
//				JSONArray jsDocuments = new JSONArray();
				JSONObject jsDocument = null;
				
				jsDocument = HttpGETObject("http://localhost:3000/documents/1");
				Document doc = getConverter().toDocument(jsDocument);
				
				System.out.println(doc.getBody());
				
				
//				for (int i = 0; i < jsDocuments.length(); i++) { 
//					jsDocument = (JSONObject) jsDocuments.get(i);
//					Document doc = getConverter().toDocument(jsDocument);
//				}
				
				System.out.println();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static JSONArray HttpGETArray(String url){

		try {

			ClientRequest request = new ClientRequest(url);
//			request.accept("application/json");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(response.getEntity().getBytes())));

			String output;
			String output2="";

			while ((output = br.readLine()) != null) {
//				System.out.println(output);
				output2=output;
			}
			return new JSONArray(output2);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null; 
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}
	
	public static JSONObject HttpGETObject(String url){
		
		try {
			
			ClientRequest request = new ClientRequest(url);
//			request.accept("application/json");
			ClientResponse<String> response = request.get(String.class);
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(response.getEntity().getBytes())));
			
			String output;
			String output2="";
			
			while ((output = br.readLine()) != null) {
//				System.out.println(output);
				output2=output;
			}
			return new JSONObject(output2);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null; 
		} catch (IOException e) {
			e.printStackTrace();
			return null; 
		} catch (Exception e) {
			e.printStackTrace();
			return null; 
		}
	}

	public static DocumentConverter getConverter() {
		return DocumentConverter.getInstance();
	}
	
	private void await() throws InterruptedException {
		Thread.sleep(3000);
	}
}
