package services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import entities.Favorite;
import facades.DAO;
import org.sql2o.ResultSetHandler;
import spark.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteService {
    public Favorite getFavorite(String saveId, String userId) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM favorito WHERE chollo=:saveId AND usuario=:userId")
                .addParameter("saveId", Integer.parseInt(saveId))
                .addParameter("userId", Integer.parseInt(userId))
                .executeAndFetchFirst((ResultSetHandler<Favorite>) resultSet ->
                        new Favorite(new SaveService().getSave(saveId), new UserService().getUser(userId))
                );
    }

    public boolean createFavorite(String saveId, String userId, Request req) {
//        JsonObject jsonObject = new Gson().fromJson(req.body(), JsonObject.class);
//        saveId = jsonObject.get("chollo").getAsString();
//        userId = jsonObject.get("usuario").getAsString();
        DAO.getInstance().getConnection().createQuery("INSERT INTO favorito (chollo,usuario) VALUES (:chollo,:usuario);")
                .addParameter("chollo", Integer.parseInt(saveId))
                .addParameter("usuario", Integer.parseInt(userId))
                .executeUpdate();
        return true;
    }

    public boolean deleteFavorite(String saveId, String userId, Request req) {
//        System.out.println(saveId + " " + userId + " " + req.body());
//        JsonObject jsonObject = new Gson().fromJson(req.body(), JsonObject.class);
//        saveId = jsonObject.get("chollo").getAsString();
//        userId = jsonObject.get("usuario").getAsString();
        DAO.getInstance().getConnection().createQuery("DELETE from favorito WHERE chollo=:saveId AND usuario=:userId;")
                .addParameter("saveId", Integer.parseInt((saveId)))
                .addParameter("userId", Integer.parseInt((userId)))
                .executeUpdate();
        return true;
    }

    public List<Favorite> getFavoritesByUser(String userId) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM favorito WHERE usuario=:userId")
                .addParameter("userId", Integer.parseInt(userId))
                .executeAndFetch((ResultSetHandler<Favorite>) resultSet ->
                        new Favorite(new SaveService().getSave(resultSet.getString("chollo")), new UserService().getUser(userId))
                );
    }
}
