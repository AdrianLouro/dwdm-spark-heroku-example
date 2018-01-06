package services;

import entities.Reaction;
import facades.DAO;
import org.sql2o.ResultSetHandler;

public class ReactionService {

    public Reaction getReaction(String saveId, String userId) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM reaccion WHERE chollo=:saveId AND usuario=:userId")
                .addParameter("saveId", Integer.parseInt(saveId))
                .addParameter("userId", Integer.parseInt(userId))
                .executeAndFetchFirst((ResultSetHandler<Reaction>) resultSet ->
                        new Reaction(
                                new SaveService().getSave(saveId),
                                new UserService().getUser(userId),
                                resultSet.getBoolean("positiva")
                        )
                );
    }

    public Reaction getReactionByPositiva(String saveId, String userId, String positiva) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM reaccion WHERE chollo=:saveId AND usuario=:userId AND positiva=:positiva")
                .addParameter("saveId", Integer.parseInt(saveId))
                .addParameter("userId", Integer.parseInt(userId))
                .addParameter("positiva", Boolean.valueOf(positiva))
                .executeAndFetchFirst((ResultSetHandler<Reaction>) resultSet ->
                        new Reaction(
                                new SaveService().getSave(saveId),
                                new UserService().getUser(userId),
                                resultSet.getBoolean("positiva")
                        )
                );
    }

    public boolean createReaction(String saveId, String userId, String positiva) {
        DAO.getInstance().getConnection().createQuery("INSERT INTO reaccion (chollo,usuario,positiva) VALUES (:chollo,:usuario,:positiva);")
                .addParameter("chollo", Integer.parseInt(saveId))
                .addParameter("usuario", Integer.parseInt(userId))
                .addParameter("positiva", Boolean.valueOf(positiva))
                .executeUpdate();
        return true;
    }

    public boolean editReaction(String chollo, String usuario, String positiva) {
        DAO.getInstance().getConnection().createQuery("UPDATE reaccion SET positiva=:positiva WHERE chollo=:chollo AND usuario=:usuario;")
                .addParameter("chollo", Integer.parseInt((chollo)))
                .addParameter("usuario", Integer.parseInt((usuario)))
                .addParameter("positiva", Boolean.valueOf(positiva))
                .executeUpdate();
        return true;
    }

    public boolean deleteReaction(String saveId, String userId) {
        DAO.getInstance().getConnection().createQuery("DELETE from reaccion WHERE chollo=:saveId AND usuario=:userId;")
                .addParameter("saveId", Integer.parseInt((saveId)))
                .addParameter("userId", Integer.parseInt((userId)))
                .executeUpdate();
        return true;
    }

}
