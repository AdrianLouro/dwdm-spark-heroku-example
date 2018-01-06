package entities;

public class Reaction extends SaveUserRelation {

    private Save chollo;
    private User usuario;
    private boolean positiva;

    public Reaction(Save chollo, User usuario, boolean positiva) {
        this.chollo = chollo;
        this.usuario = usuario;
        this.positiva = positiva;
    }

    public Save getSave() {
        return chollo;
    }

    public User getUser() {
        return usuario;
    }

    public void setSave(Save chollo) {
        this.chollo = chollo;
    }

    public void setUser(User usuario) {
        this.usuario = usuario;
    }

    public boolean getPositiva() {
        return positiva;
    }

    public void setPositiva(boolean positiva) {
        this.positiva = positiva;
    }
}
