package service;

import dao.TaskDAO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO){
        this.taskDAO = taskDAO;
    }
}
