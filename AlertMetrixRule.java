package sensor.Rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import sensor.dao.WeightSensorDAO;
import sensor.model.AlertMetricsData;

@Rule(name ="AlertMetricsRule")
public class AlertMetrixRule {
    
    public String inputValue;
    
 
    private WeightSensorDAO sensorDAO;
    
    @Autowired
    public void setSensorDAO(WeightSensorDAO sensorDAO) {
        this.sensorDAO = sensorDAO;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    @Condition
    public boolean validateBaseWeight(){
	int baseWeightOfPerson = 150;
	int baseWeight = Integer.parseInt(inputValue);
	int percentageN = (int)(baseWeight*(10.0f/100.0f));
	if(baseWeight<baseWeightOfPerson - percentageN || baseWeight>baseWeightOfPerson+percentageN) 
	    return false;
	else
	    return true;
    }
    
    @Action
    public void then(){
	AlertMetricsData alertMetricsData = new AlertMetricsData();
	alertMetricsData.setBaseweight(inputValue);
	alertMetricsData.setAlertDescription("Overweight");
	sensorDAO.saveAlertMetrics(alertMetricsData);
    }
    

}
