package entities;

public abstract class SaveUserRelation {
    private Save save;
    private User user;

    public SaveUserRelation(Save save, User usuario) {
        this.save = save;
        this.user = user;
    }

    public Save getSave() {
        return save;
    }

    public User getUser() {
        return user;
    }
}
