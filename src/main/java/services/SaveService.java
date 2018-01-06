package services;

import entities.Save;
import facades.DAO;
import org.sql2o.ResultSetHandler;
import spark.Request;

import java.util.Date;
import java.util.List;

public class SaveService {
    public Save getSave(String id) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM chollo WHERE id=:id")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetchFirst((ResultSetHandler<Save>) resultSet ->
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

    public List<Save> getSaves() {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM chollo ORDER BY fechaActualizacion DESC")
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

    public boolean createSave(String titulo, String enlace, String descripcion, String precioAntes, String precioDespues, String empresaNoPatrocinada, String empresaPatrocinada, String usuario, String categoria) {
        DAO.getInstance().getConnection().createQuery("INSERT INTO chollo (titulo,enlace,descripcion,precioAntes,precioDespues,fechaCreacion,fechaActualizacion,empresaNoPatrocinada,empresaPatrocinada,usuario,categoria)" +
                " VALUES (:titulo,:enlace,:descripcion,:precioAntes,:precioDespues,:fechaCreacion,:fechaActualizacion,:empresaNoPatrocinada,:empresaPatrocinada,:usuario,:categoria);")
                .addParameter("titulo", titulo)
                .addParameter("enlace", enlace)
                .addParameter("descripcion", descripcion)
                .addParameter("precioAntes", Float.parseFloat(precioAntes))
                .addParameter("precioDespues", Float.parseFloat(precioDespues))
                .addParameter("fechaCreacion", new Date())
                .addParameter("fechaActualizacion", new Date())
                .addParameter("empresaNoPatrocinada", empresaNoPatrocinada)
                .addParameter("empresaPatrocinada", Integer.parseInt((empresaPatrocinada)))
                .addParameter("usuario", Integer.parseInt(usuario))
                .addParameter("categoria", Integer.parseInt(categoria))
                .executeUpdate();
        return true;
    }

    public boolean editSave(String id, String titulo, String enlace, String descripcion, String precioAntes, String precioDespues, String empresaNoPatrocinada, String empresaPatrocinada, String categoria) {
        DAO.getInstance().getConnection().createQuery("UPDATE chollo SET titulo=:titulo,enlace=:enlace,descripcion=:descripcion,precioAntes=:precioAntes,precioDespues=:precioDespues,fechaActualizacion=:fechaActualizacion,empresaNoPatrocinada=:empresaNoPatrocinada,empresaPatrocinada=:empresaPatrocinada,categoria=:categoria WHERE id=:id;")
                .addParameter("id", Integer.parseInt((id)))
                .addParameter("titulo", titulo)
                .addParameter("enlace", enlace)
                .addParameter("descripcion", descripcion)
                .addParameter("precioAntes", Float.parseFloat(precioAntes))
                .addParameter("precioDespues", Float.parseFloat(precioDespues))
                .addParameter("fechaActualizacion", new Date())
                .addParameter("empresaNoPatrocinada", empresaNoPatrocinada)
                .addParameter("empresaPatrocinada", Integer.parseInt((empresaPatrocinada)))
                .addParameter("categoria", Integer.parseInt(categoria))
                .executeUpdate();
        return true;
    }

    public boolean deleteSave(String id) {
        DAO.getInstance().getConnection().createQuery("DELETE from chollo WHERE id=:id;")
                .addParameter("id", Integer.parseInt((id)))
                .executeUpdate();
        return true;
    }

    public int getReactionsCountFor(String id, String positiva) {
        return DAO.getInstance().getConnection().createQuery("SELECT COUNT(*)\n" +
                "FROM (reaccion\n" +
                "INNER JOIN chollo ON reaccion.chollo = chollo.id)\n" +
                "WHERE chollo.id=:id\n" +
                "AND reaccion.positiva=:positiva;")
                .addParameter("id", Integer.parseInt((id)))
                .addParameter("positiva", Boolean.valueOf((positiva)))
                .executeScalar(Integer.class);
    }
}
