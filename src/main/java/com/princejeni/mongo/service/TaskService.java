package com.princejeni.mongo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.princejeni.mongo.model.Task;
import com.princejeni.mongo.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task addTask( Task task) {
		task.setId(UUID.randomUUID().toString().split("-")[0]);
		return taskRepository.save(task);
	}
	

	public List<Task> findAllTasks(){
		return taskRepository.findAll();
	}
	
	
	public Task getById( String id) {
		return taskRepository.findById(id).get();
	}
	
	
	
	public List<Task> getTaskBySeverity(int severity){
		return taskRepository.findBySeverity(severity);
	}
	
	public List<Task> getTaskByAssignee(String assignee){
		return taskRepository.getTasksByAssignee(assignee);
	}
	
	public Task updateTask(Task taskRequest) {
		Task existingTask = taskRepository.findById(taskRequest.getId()).get();
		existingTask.setDescription(taskRequest.getDescription());
		existingTask.setAsignee(taskRequest.getAsignee());
		existingTask.setSeverity(taskRequest.getSeverity());
		existingTask.setStoryPoint(taskRequest.getStoryPoint());
		return taskRepository.save(existingTask);
	}
	
	public String deleteTask(String id) {
		taskRepository.deleteById(id);
		return id+": task deleted sucessfully";
		
	}
	
	

}
