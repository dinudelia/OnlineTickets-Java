package model;

public class Payment {

    private String idPay;
    private String method;
    private int paid;

    public Payment(String idPay, String method) {
        this.idPay = idPay;
        this.method = method;
        paid = 0;
    }

    public String getIdPay() {
        return idPay;
    }

    public void setIdPay(String idPay) {
        this.idPay = idPay;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
