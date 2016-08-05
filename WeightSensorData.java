package sensor.model;

import org.mongodb.morphia.annotations.Entity;

@Entity("weightMetrics")
public class WeightSensorData {

    private String value;
    private long timeStampInMilliseconds;

    public long getTimeStampInMilliseconds() {
        return timeStampInMilliseconds;
    }

    public void setTimeStampInMilliseconds(long timeStampInMilliseconds) {
        this.timeStampInMilliseconds = timeStampInMilliseconds;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

   

}
