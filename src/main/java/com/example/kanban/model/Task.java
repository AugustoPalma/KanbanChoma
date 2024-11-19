package com.example.kanban.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.TODO;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    private LocalDate creationDate = LocalDate.now();

    private LocalDate dueDate;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public void setStatus(TaskStatus taskStatus) {
    }
}
