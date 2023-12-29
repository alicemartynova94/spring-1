package service;

import dao.TaskDAO;
import domain.Status;
import domain.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAllTasks(int offset, int limit) {
        return taskDAO.getAllTasks(offset, limit);
    }

    public int getTotalNumberOfTasks() {
        return taskDAO.getTotalNumberOfTasks();
    }

    @Transactional(readOnly = false)
    public Task update(int id, String description, Status status) {
        Task task = taskDAO.getTaskById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }

        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdate(task);
        return task;
    }

    public Task create(String description, Status status){
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDAO.saveOrUpdate(task);
        return task;
    }
    @Transactional
    public void delete(int id){
        Task task = taskDAO.getTaskById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }
        taskDAO.delete(task);
    }
}
