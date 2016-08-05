package sensor.dao;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;

public class WeightSensorMongoDBConnection {
    
    private static final WeightSensorMongoDBConnection INSTANCE = new WeightSensorMongoDBConnection();
    private Datastore dataStore;
    private static final String DB_NAME = "weightSensorData";

    
    private WeightSensorMongoDBConnection(){
	 
	try {
	    Mongo mongo = new Mongo("localhost", 27017);
	    dataStore  = new Morphia().mapPackage("sensor.dao").createDatastore(mongo, DB_NAME);
	    dataStore.ensureIndexes();
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
		
    }
    
    public static WeightSensorMongoDBConnection instance(){
	return INSTANCE;
    }
    
    public Datastore getDataStore(){
	return dataStore;
    }
}
