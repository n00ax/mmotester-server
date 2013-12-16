package mme.test;

import java.net.UnknownHostException;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MainTest {
	static MongoClient d;
	public static void main(String[] args){
		try {
			d = new MongoClient("localhost");
			DBCollection dll;
			DB db;
			db = d.getDB("testblank");
			dll = db.getCollection("testusers");
			DBObject ds = new BasicDBObject("$set", new BasicDBObject("username","hello"));
			DBObject dn = new BasicDBObject("username","noah");
			dll.update(dn, ds);
			DBCursor nd = dll.find(new BasicDBObject("username", "jack"));
			DBObject dobf = nd.next();
			Map<String, String>dllobj = dobf.toMap();
			System.out.println(dllobj.get("password"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
