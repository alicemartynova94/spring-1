package dao;

import domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDAO {

    private final SessionFactory sessionFactory;

    public TaskDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Task> getAllTasks(int offset, int limit) {
        Query<Task> query = getSession().createQuery("select t from Task t", Task.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public int getTotalNumberOfTasks(){
        Query<Long> query = getSession().createQuery("select count(t) from Task t", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
