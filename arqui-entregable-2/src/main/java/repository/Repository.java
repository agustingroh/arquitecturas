package main.java.repository;

import main.java.interfaces.IRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class Repository {

    protected EntityManager em;

    public Repository(EntityManager em){
        this.em = em;
    }
}
