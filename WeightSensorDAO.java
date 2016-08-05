package sensor.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import sensor.model.AlertMetricsData;
import sensor.model.WeightSensorData;

@Component("weightSensorDAO")
public class WeightSensorDAO {
    
 
    private Datastore datastore = WeightSensorMongoDBConnection.instance().getDataStore();;
    
   
    public void saveWeightMetrics(WeightSensorData sensorData){
	try {
	    datastore.save(sensorData);
	} catch(Exception e){
	    e.printStackTrace();
	}
	
	
    }
    
    public void saveAlertMetrics(AlertMetricsData alertMetricsData){
	try {
	    datastore.save(alertMetricsData);
	} catch(Exception e){
	    e.printStackTrace();
	}
    }
    
    public List<WeightSensorData> findALLWeightMetrics(){
	List<WeightSensorData> sensorData=null;
	try {
   	 Query query = datastore.createQuery(WeightSensorData.class);
   	 sensorData = query.asList();
   	} catch(Exception e){
   	    e.printStackTrace();
   	}
   	return sensorData;
       }
    
    
    public List<AlertMetricsData> findALLAlertMetrics(){
   	List<AlertMetricsData> alertMetricsData=null;
   	try {
      	 Query query = datastore.createQuery(AlertMetricsData.class);
      	 alertMetricsData = query.asList();
      	} catch(Exception e){
      	    e.printStackTrace();
      	}
      	return alertMetricsData;
    }
    
    public List<AlertMetricsData> findALLAlertMetrics(long timeStart, long timeEnd){
   	List<AlertMetricsData> alertMetricsData=null;
   	try {
      	 Query query = datastore.createQuery(AlertMetricsData.class).filter("timeInmilliSeconds>", timeStart).filter("timeInmilliSeconds<", timeEnd);
      	 alertMetricsData = query.asList();
      	} catch(Exception e){
      	    e.printStackTrace();
      	}
      	return alertMetricsData;
    }
    
    public List<WeightSensorData> findALLWeightMetrics(long timeStart, long timeEnd){
   	List<WeightSensorData> weightSensorData=null;
   	try {
      	 Query query = datastore.createQuery(WeightSensorData.class).filter("timeStampInMilliseconds>", timeStart).filter("timeStampInMilliseconds<", timeEnd);
      	 weightSensorData = query.asList();
      	} catch(Exception e){
      	    e.printStackTrace();
      	}
      	return weightSensorData;
    }
    
}
