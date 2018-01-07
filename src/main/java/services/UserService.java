package services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entities.Save;
import entities.User;
import facades.DAO;
import org.sql2o.ResultSetHandler;
import spark.Request;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    public User getUser(String id) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE id=:id;")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetchFirst(User.class);
    }

    public List<User> getUsers() {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario;")
                .executeAndFetch(User.class);
    }

    public User getUserByTelephone(String telephone) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE telefono=:telefono;")
                .addParameter("telefono", telephone)
                .executeAndFetchFirst(User.class);
    }

    public User getUserByAlias(String alias) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM usuario WHERE alias=:alias;")
                .addParameter("alias", alias)
                .executeAndFetchFirst(User.class);
    }

    public User createUser(String telephone, String alias, Request req) {
        JsonObject jsonObject = new Gson().fromJson(req.body(), JsonObject.class);
        telephone = jsonObject.get("telefono").getAsString();
        alias = jsonObject.get("alias").getAsString();

        if (getUserByAlias(alias) != null || getUserByTelephone(telephone) != null) return null;
        Object id = DAO.getInstance().getConnection().createQuery("INSERT INTO usuario (telefono,alias,administrador) VALUES (:telefono,:alias,false);", true)
                .addParameter("alias", alias)
                .addParameter("telefono", telephone)
                .executeUpdate()
                .getKey();
        return new User((Integer) id, telephone, alias, false);
    }

    public List<Save> getSaves(String id) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM chollo WHERE usuario=:id")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetch((ResultSetHandler<Save>) resultSet ->
                        new Save(
                                resultSet.getInt("id"),
                                resultSet.getString("titulo"),
                                resultSet.getString("enlace"),
                                resultSet.getString("descripcion"),
                                resultSet.getFloat("precioAntes"),
                                resultSet.getFloat("precioDespues"),
                                resultSet.getDate("fechaCreacion"),
                                resultSet.getDate("fechaActualizacion"),
                                resultSet.getString("empresaNoPatrocinada"),
                                new CategoryService().getCategory(resultSet.getString("categoria")),
                                new UserService().getUser(resultSet.getString("usuario")),
                                new CompanyService().getCompany(resultSet.getString("empresaPatrocinada"))
                        )
                );
    }

    public List<Save> getFavoriteSaves(String id) {
        return new FavoriteService().getFavoritesByUser(id).stream().map((favorite) -> favorite.getSave()).collect(Collectors.toList());
    }

    public int getReactionsCount(String id, String positiva){
        List<Save> userSaves = getSaves(id);
        int reputation = 0;
        for (Save save : userSaves)
            reputation += new SaveService().getReactionsCount("" + save.getId(), positiva);

        return reputation;
    }
}
