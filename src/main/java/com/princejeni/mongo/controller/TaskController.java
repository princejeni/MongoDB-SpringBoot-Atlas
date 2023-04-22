package com.princejeni.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.princejeni.mongo.model.Task;
import com.princejeni.mongo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;

	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}

	@GetMapping
	public List<Task> getTasks() {
		return taskService.findAllTasks();
	}
	
	
	@GetMapping("/{id}")
	public Task getTask(@PathVariable String id) {
		return taskService.getById(id);
	}
	
	@GetMapping("/severity/{severity}")
	public List<Task> findTaskUsingSeverity(@PathVariable int severity){
		return taskService.getTaskBySeverity(severity);
	}
	
	@GetMapping("/assignee/{asignee}")
	public List<Task> findTaskUsingAssignee(@PathVariable String assignee){
		return taskService.getTaskByAssignee(assignee);
	}
	
	@PutMapping
	public Task modifyTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
	
	@DeleteMapping("/{id}")
	public String eliminateTask(@PathVariable String id) {
		return taskService.deleteTask(id);
	}
	
	
	

}
