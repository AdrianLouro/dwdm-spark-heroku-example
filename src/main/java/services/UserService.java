package services;

import entities.User;

public class UserService {
    public User getUser(String id){
        return new User(1,"12345","juan");
    }

    public User getUsers(){
        return new User(2,"12345","juan");
    }

    public User getUserByTelephone(String telephone){
        return new User(3,telephone,"juan");
    }

    public User getUserByAlias(String alias){
        return new User(4,"123",alias);
    }

    public User createUser(String id, String telephone, String alias){
        return new User(Integer.parseInt(id), telephone, alias);
    }
}
