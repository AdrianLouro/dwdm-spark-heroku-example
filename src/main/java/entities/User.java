package entities;

public class User extends Entity{
    private int id;
    private String telefono;
    private String alias;
    private boolean administrador;

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

    public String getTelefono() {
        return telefono;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
