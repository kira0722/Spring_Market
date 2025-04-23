package com.example.market.Domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private Integer purcharseId;
    private String clienteId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurcharseItem> item;


    public Integer getPurcharseId() {
        return purcharseId;
    }

    public void setPurcharseId(Integer purcharseId) {
        this.purcharseId = purcharseId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurcharseItem> getItem() {
        return item;
    }

    public void setItem(List<PurcharseItem> item) {
        this.item = item;
    }
}
