package services;

import entities.User;
import facades.DAO;

import java.util.List;

public class UserService {
    public User getUser(String id){
        List<User> users = DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE id=:id;")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetch(User.class);
        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> getUsers(){
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario;")
                .executeAndFetch(User.class);
    }

    public User getUserByTelephone(String telephone){
        List<User> users = DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE telefono=:telefono;")
                .addParameter("telefono", telephone)
                .executeAndFetch(User.class);
        return users.isEmpty() ? null : users.get(0);
    }

    public User getUserByAlias(String alias){
        List<User> users = DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE alias=:alias;")
                .addParameter("alias", alias)
                .executeAndFetch(User.class);
        return users.isEmpty() ? null : users.get(0);
    }

    public User createUser(String telephone, String alias){
        if(getUserByAlias(alias) != null || getUserByTelephone(telephone) != null) return null;
        Object id = DAO.getInstance().getConnection().createQuery("INSERT INTO usuario (telefono,alias,administrador) VALUES (:telefono,:alias,false);", true)
                .addParameter("alias", alias)
                .addParameter("telefono", telephone)
                .executeUpdate()
                .getKey();
        return new User((Integer) id, telephone, alias, false);
    }
}
