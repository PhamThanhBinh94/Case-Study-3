package com.codegym.model;

public class Bill {
    private int bill_id;
    private String customer_id;
    private String create_date;
    private String address;
    private String status;

    public Bill() {
    }

    public Bill(String customer_id, String create_date, String address, String status) {
        this.customer_id = customer_id;
        this.create_date = create_date;
        this.address = address;
        this.status = status;
    }

    public Bill(int bill_id, String customer_id, String create_date, String address, String status) {
        this.bill_id = bill_id;
        this.customer_id = customer_id;
        this.create_date = create_date;
        this.address = address;
        this.status = status;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id=" + bill_id +
                ", customer_id='" + customer_id + '\'' +
                ", create_date='" + create_date + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
