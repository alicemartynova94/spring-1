package service;

import dao.TaskDAO;
import domain.Task;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO){
        this.taskDAO = taskDAO;
    }

    public List<Task> getAllTasks(int offset, int limit) {
        return taskDAO.getAllTasks(offset, limit);
    }

    public int getTotalNumberOfTasks(){
        return taskDAO.getTotalNumberOfTasks();
    }
}
