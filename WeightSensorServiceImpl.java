package sensor.service;

import java.util.List;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sensor.Rules.AlertMetrixRule;
import sensor.dao.WeightSensorDAO;
import sensor.model.AlertMetricsData;
import sensor.model.WeightSensorData;

@Component("sensorService")
public class WeightSensorServiceImpl implements WeightSensorService{
    
   
    private WeightSensorDAO weightSensorDAO;
    
    @Autowired
    public void setWeightSensorDAO(WeightSensorDAO weightSensorDAO) {
        this.weightSensorDAO = weightSensorDAO;
    }

    public void saveMetrics(String value, String milliSeonds){
	
	WeightSensorData sensorData = new WeightSensorData();
	sensorData.setValue(value);
	sensorData.setTimeStampInMilliseconds(Long.valueOf(milliSeonds));
	executeRules(sensorData);
	
	weightSensorDAO.saveWeightMetrics(sensorData);
	
    }

    private void executeRules(WeightSensorData sensorData) {
	AlertMetrixRule alertMetrixRule = new AlertMetrixRule();
	RulesEngine engine = RulesEngineBuilder.aNewRulesEngine().build();
	engine.registerRule(alertMetrixRule);
	engine.fireRules();
    }

    public List<WeightSensorData> findAllWeightMetrics() {
	return weightSensorDAO.findALLWeightMetrics();
	
    }
    
    public List<AlertMetricsData> findAllAlertMetrics() {
	return weightSensorDAO.findALLAlertMetrics();
	
    }
    
    public List<AlertMetricsData> findAllAlertMetrics(String input1, String input2) {
	long timeMillisecondsStart = Long.parseLong(input1);
	long timeMillisecondsEnd = Long.parseLong(input2);
	return weightSensorDAO.findALLAlertMetrics(timeMillisecondsStart,timeMillisecondsEnd);
    }
    
    public List<WeightSensorData> findAllWeightMetrics(String input1, String input2){
	long timeMillisecondsStart = Long.parseLong(input1);
	long timeMillisecondsEnd = Long.parseLong(input2);
	return weightSensorDAO.findALLWeightMetrics(timeMillisecondsStart,timeMillisecondsEnd);
    }
}
