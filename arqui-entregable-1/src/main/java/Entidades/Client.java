package Entidades;

public class Client {
    private int id;

    private String name;

    private String mail;

    public Client(String name, String mail) {
        this.name = name;
        this.mail = mail;
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
}

