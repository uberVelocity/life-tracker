package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.beans.Statement;
import java.util.Collection;
import java.util.List;

public class Database {

    private EntityManagerFactory emf;
    private EntityManager em;
    private String filename = "dbentries";

    public Database() {}

    public void openDataSource() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/" + filename + ".odb");
        em = emf.createEntityManager();
    }

    public void closeDataSource() {
        em.close();
        emf.close();
    }

    public void addEntry(Entry entry) {
        em.getTransaction().begin();
        em.persist(entry);
        em.getTransaction().commit();
    }

    public Collection<Entry> getUsers() {
        em.getTransaction().begin();
        TypedQuery<Entry> query =
                em.createQuery("SELECT e FROM Entry e", Entry.class);
        em.getTransaction().commit();

        List<Entry> results = query.getResultList();
        return results;
    }

    public void dropTables() {
        openDataSource();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Object").executeUpdate();
        em.getTransaction().commit();
        closeDataSource();
    }

}
