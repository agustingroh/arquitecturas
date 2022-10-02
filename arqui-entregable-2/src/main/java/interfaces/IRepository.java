package main.java.interfaces;
import main.java.entities.Career;
import main.java.entities.Person;

import java.io.Serializable;
import java.util.List;

public interface IRepository<Entity , ID extends Serializable> {
    public void insert(Entity entity);

   public List<Entity> getAll();

   public Entity get(ID id);

   public Entity delete(ID id);

}
