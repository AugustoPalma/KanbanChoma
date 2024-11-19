package com.example.kanban.service;

import com.example.kanban.model.Task;
import com.example.kanban.model.TaskStatus;
import com.example.kanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task createTask(Task task) {
        task.setStatus(TaskStatus.TODO);
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setPriority(taskDetails.getPriority());
        task.setDueDate(taskDetails.getDueDate());
        return repository.save(task);
    }

    public Task moveTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (task.getStatus() == TaskStatus.TODO) {
            task.setStatus(TaskStatus.IN_PROGRESS);
        } else if (task.getStatus() == TaskStatus.IN_PROGRESS) {
            task.setStatus(TaskStatus.DONE);
        } else {
            throw new RuntimeException("Task is already completed");
        }
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
