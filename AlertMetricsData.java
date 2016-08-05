package sensor.model;

import org.mongodb.morphia.annotations.Entity;

@Entity("alertMetrics")
public class AlertMetricsData {
    
    public String getBaseweight() {
        return baseweight;
    }
    public void setBaseweight(String baseweight) {
        this.baseweight = baseweight;
    }
    public String getAlertDescription() {
        return alertDescription;
    }
    public void setAlertDescription(String alertDescription) {
        this.alertDescription = alertDescription;
    }
    private String baseweight;
    private String alertDescription;
    
    private long timeInmilliSeconds;

    public long getTimeInmilliSeconds() {
        return timeInmilliSeconds;
    }
    public void setTimeInmilliSeconds(long timeInmilliSeconds) {
        this.timeInmilliSeconds = timeInmilliSeconds;
    }
}
