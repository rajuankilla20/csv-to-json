package model.gpod;

import java.util.Date;
import java.util.Objects;

public class SelectedPickupTime {
    private String dayName;
    private String endTime;
    private String pickupLocation;
    private String startTime;


    public SelectedPickupTime() {
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "SelectedPickupTime{" +
                "dayName='" + dayName + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
