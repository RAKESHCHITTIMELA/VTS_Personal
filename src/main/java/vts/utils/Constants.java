package vts.utils;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Constants {
      
	public static final String keywordfile = System.getProperty("user.dir") + "\\src\\main\\java\\vts\\testdata\\TestData.xlsx";
//	public static final String keywordfile = "C:\\Users\\RAKESH\\Downloads\\TestData.xlsx";
	public static final String sheet = "Testdata";
	public static final String resultsheet = "TestResult";
	
	
	public static void mongoDB() {
		
//		String client_url = "mongodb://" + "USERNAME" + ":" + "PASSWORD" + "@" + "localhost" + ":" +27017;
			String client_url = "mongodb://" + "13.233.160.62" + ":" +27017;
			
			MongoClientURI mongoclientURI = new MongoClientURI(client_url);
			MongoClient mongoclient = new  MongoClient(mongoclientURI);
			
			MongoDatabase mongodatabase = mongoclient.getDatabase("mainDB");
			MongoIterable<String> mongoiterable = mongodatabase.listCollectionNames();
			MongoCursor<String> iterator = mongoiterable.iterator();
			
			while(iterator.hasNext()) {

				System.out.println(iterator.next());
				
			}
//			collection.find().forEach(printBlock);
		
		MongoCollection<Document>	collection = mongodatabase.getCollection("otpVerificationBean");
		      MongoCursor<Document> cursor = collection.find().iterator();
		      while(cursor.hasNext()) {
		    //	  Integer num = new Integer(6364908628);
		    //	  Integer intWrapper = Integer.valueOf("6364908628");
		    	  Document doc = cursor.next();
		    	ArrayList<Object> users = new ArrayList <Object > (doc.values());
		    //	for(int i=0;i<users.size();i++)
		    //	if(users.get(0)==num)
//		    	if(users.get(0).toString().equals(mobilenumber))
//		    	 System.out.printf("%s",  users.get(2));	 
		    	
		      }
			}	 
		
		
	}

