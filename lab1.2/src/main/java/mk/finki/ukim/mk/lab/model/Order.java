package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Order {
    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;
    private Long orderID;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAddress, Long orderID) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderID = orderID;
    }

    public String getBalloonColor() {
        return balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Long getOrderID() {
        return orderID;
    }
}
