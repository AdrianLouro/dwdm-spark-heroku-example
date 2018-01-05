package entities;


public class User {
    private int id;
    private String telephone;
    private String alias;

    public User( String telephone, String alias) {
        this.telephone = telephone;
        this.alias = alias;
    }

    public User(int id, String telephone, String alias) {
        this.id = id;
        this.telephone = telephone;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
