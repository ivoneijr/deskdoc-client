package br.com.senac.sd.deskdoc.converter;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import br.com.senac.sd.deskdoc.model.Document;

public class DocumentConverter{

	private static final DocumentConverter INSTANCE = new DocumentConverter();
	
	public static DocumentConverter getInstance(){
		return INSTANCE;
	}

	public Document toDocument(JSONObject jsDoc) {

		Document doc = new Document();
		
		doc.setId(jsDoc.getInt("id"));
		doc.setTitle(jsDoc.getString("title"));
		doc.setBody(jsDoc.getString("body"));
		
		return doc;
	}

	public JSONObject toJson(Document source) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Document> toDocument(List<JSONObject> targetList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONArray toJson(List<Document> targetList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
