package sensor.controller;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sensor.model.AlertMetricsData;
import sensor.model.WeightSensorData;
import sensor.service.WeightSensorService;


@RestController
@RequestMapping("/weightsensor")
public class WeightSensorRestController {
    
    private final WeightSensorService sensorService;
    
    @Autowired
    public WeightSensorRestController(WeightSensorService sensorService){
	this.sensorService = sensorService;
    }
    
    @RequestMapping(value="/sensordata", method=RequestMethod.POST)
    public void create(@RequestBody HashMap<String,String> sensorData){
	sensorService.saveMetrics(sensorData.get("value"), sensorData.get("timeStamp"));
    }
    
    @RequestMapping(value="/weightmetrics" , method=RequestMethod.GET)
    @Produces(MediaType.APPLICATION_XML)
    public List<WeightSensorData> listAllWeightMetrics(){
	return sensorService.findAllWeightMetrics();
    }
    
    @RequestMapping(value="/alertmetrics" , method=RequestMethod.GET)
    @Produces(MediaType.APPLICATION_XML)
    public List<AlertMetricsData> listAllAlertMetrics(){
	return sensorService.findAllAlertMetrics();
    }
    
    @RequestMapping(value="/alertmetricsByDateRange" , method=RequestMethod.POST)    
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<AlertMetricsData> listAllAlertMetricsbyDateRange(JSONObject jsonInputObject){
	 String input1 = (String) jsonInputObject.get("timestamp1");
	 String input2 = (String) jsonInputObject.get("timestamp2");
	return sensorService.findAllAlertMetrics(input1,input2);
    }
    
    @RequestMapping(value="/weightmetricsByDateRange" , method=RequestMethod.POST)    
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<WeightSensorData> listAllWeightMetricsbyDateRange(JSONObject jsonInputObject){
	 String input1 = (String) jsonInputObject.get("timestamp1");
	 String input2 = (String) jsonInputObject.get("timestamp2");
	return sensorService.findAllWeightMetrics(input1,input2);
    }
}
