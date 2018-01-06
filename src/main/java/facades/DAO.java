package facades;

import org.sql2o.Sql2o;

public class DAO {

    private static DAO instance = null;
    private Sql2o connection = new Sql2o("jdbc:postgresql://" + "ec2-54-195-241-106.eu-west-1.compute.amazonaws.com" + ":" + 5432 + "/" + "dbpnhqsh7n0hsa" + "?sslmode=require",
            "oswrqvsrldjzex", "c746eb92bd4e055963cdd36a1b7ff198913c90d2ea83050f388dbfa01a328b06");


    public static DAO getInstance(){
        if(instance != null) return instance;
        instance = new DAO();
        return instance;
    }

    public Sql2o getConnection(){
        return connection;
    }

}
