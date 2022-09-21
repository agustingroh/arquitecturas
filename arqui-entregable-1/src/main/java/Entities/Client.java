package Entities;

public class Client {
    private int id;
    private String name;
    private String mail;
    public Client(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
    public Client (Integer id, String name, String mail){
        this(name,mail);
        this.id= id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Client getClient(){
        return new Client(this.name, this.mail);
    }
    @Override
    public String toString(){
        return  "Id:" + this.id + " " + "Name:" + this.name + " " + "Email:" + this.mail;
    }
}

