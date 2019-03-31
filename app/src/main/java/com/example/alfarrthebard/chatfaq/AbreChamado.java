package com.example.alfarrthebard.chatfaq;

public class AbreChamado {

    private String ticket = "8922";
    private String analista = "Jorge";
    private String status = "andamento";

    public AbreChamado() {
    }

    public AbreChamado(String ticket, String analista, String status) {
        this.ticket = ticket;
        this.analista = analista;
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getAnalista() {
        return analista;
    }

    public void setAnalista(String analista) {
        this.analista = analista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
