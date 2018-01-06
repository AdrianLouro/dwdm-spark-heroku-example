package facades;


import entities.Entity;

import java.util.List;

public abstract class AbstractEntityFacade implements AbstractFacade {

    public abstract Entity create(Entity entity);

    public abstract void edit(Entity entity);

    public abstract void remove(Entity entity);

    public abstract Entity find(int id);

    public abstract List<Entity> findAll();
}
