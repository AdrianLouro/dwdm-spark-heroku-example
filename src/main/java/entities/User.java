package entities;

public class User {
    private int id;
    private String telefono;
    private String alias;
    private boolean administrador;

    public User(String telephone, String alias, boolean administrador) {
        this.telefono = telefono;
        this.alias = alias;
        this.administrador = administrador;
    }

    public User(int id, String telefono, String alias, boolean administrador) {
        this.id = id;
        this.telefono = telefono;
        this.alias = alias;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telefono;
    }

    public void setTelephone(String telefono) {
        this.telefono = telefono;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
