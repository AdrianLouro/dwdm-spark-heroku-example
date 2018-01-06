package services;

import entities.Company;
import facades.DAO;

import java.util.List;

/**
 * Created by alour on 06/01/2018.
 */
public class CompanyService {

    public Company getCompany(String id){
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM empresaPatrocinada WHERE id=:id;")
                .addParameter("id", Integer.parseInt(id))
                .executeAndFetchFirst(Company.class);
    }

    public List<Company> getCompanies(){
        return DAO.getInstance().getConnection().createQuery("SELECT * FROM empresaPatrocinada;")
                .executeAndFetch(Company.class);
    }
}
