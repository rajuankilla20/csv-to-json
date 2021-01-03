package model.gpod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FinalUserOrders {
    private String userId;
    List<UserOrders> userOrders = new ArrayList<>();


    public FinalUserOrders() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<UserOrders> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrders> userOrders) {
        this.userOrders = userOrders;
    }


    @Override
    public String toString() {
        return "FinalUserOrders{" +
                "userId='" + userId + '\'' +
                ", userOrders=" + userOrders +
                '}';
    }
}
