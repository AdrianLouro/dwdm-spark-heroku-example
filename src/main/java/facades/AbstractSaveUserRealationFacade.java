package facades;

import entities.SaveUserRelation;

public abstract class AbstractSaveUserRealationFacade implements AbstractFacade{
    public abstract void create(SaveUserRelation saveUserRelation);

    public abstract void remove(SaveUserRelation saveUserRelation);

    public abstract SaveUserRelation find(SaveUserRelation saveUserRelation);
}
