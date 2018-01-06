package services;

import entities.Category;
import entities.Save;
import facades.DAO;
import org.sql2o.ResultSetHandler;

import java.util.List;

/**
 * Created by alour on 06/01/2018.
 */
public class CategoryService {
    public Category getCategory(String id){
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM categoria WHERE id=:id;")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetchFirst(Category.class);
    }

    public List<Category> getCategories(){
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM categoria;")
                .executeAndFetch(Category.class);
    }

    public List<Save> getSaves(String id) {
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM chollo WHERE categoria=:id")
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
}
