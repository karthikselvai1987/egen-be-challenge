package sensor.service;

import java.util.List;

import sensor.model.AlertMetricsData;
import sensor.model.WeightSensorData;

public interface WeightSensorService {
    
    public void saveMetrics(String value, String milliSeonds);
    
    public List<WeightSensorData> findAllWeightMetrics();
    
    public List<AlertMetricsData> findAllAlertMetrics();
    
    public List<AlertMetricsData> findAllAlertMetrics(String input1, String input2); 
    
    public List<WeightSensorData> findAllWeightMetrics(String input1, String input2); 

}
