package entities;

public class Favorite extends SaveUserRelation {

    private Save chollo;
    private User usuario;

    public Favorite(Save chollo, User usuario) {
        this.chollo = chollo;
        this.usuario = usuario;
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
}
