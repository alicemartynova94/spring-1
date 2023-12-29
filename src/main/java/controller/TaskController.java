package controller;

import org.springframework.stereotype.Controller;
import service.TaskService;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService; 
    }
}
