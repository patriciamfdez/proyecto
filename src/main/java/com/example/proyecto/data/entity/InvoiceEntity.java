package com.example.proyecto.data.entity;
import java.util.Date;

public class InvoiceEntity {

    private Date invoiceDate;
    private float amount;
    private String status;


    //Constructor

    public InvoiceEntity(Date invoiceDate, float amount, String status) {
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.status = status;
    }


    //GetterSetter

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}