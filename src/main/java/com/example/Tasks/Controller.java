package com.example.Tasks;

import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	@Autowired
	TaskService taskService;
	@PostMapping("/api/addtasks")
	public String createTask(@RequestBody Task task){
		taskService.saveOrupdate(task);
		return "Successfully saved the task: "+ task.getTitle();
		
	}
	@PutMapping("/api/updatetasks/{taskId}")
	public String updateTask(@RequestBody Task task,@PathVariable int taskId){
		task.setTaskId(taskId);
		taskService.saveOrupdate(task);
		 return "Successfully updated the task: "+ task.getTaskId();
	}
	@DeleteMapping("/api/deletetasks/{taskId}")
	public String DeleteTask(@PathVariable int taskId){
		
		taskService.delete(taskId);
		 return "Successfully deleted the task: "+ taskId;
	}
	
	@GetMapping("/api/getAllTasks")
	public List<Task> getTask(){
		return taskService.getAll();
		 
	}
	
	  @PostMapping("/api/tasks/{taskId}/assign") 
	  public int assignTask(@RequestBody
	  int userid,@PathVariable int taskId){
		  
		  return taskService.assignTask(taskId,userid);
	  
	  
	  }
	  @GetMapping("/api/users/{userId}/tasks")
		public List<Task> getTask(@PathVariable int userId ){
			return taskService.findByuserId(userId);
			 
		}
	  @PostMapping("/api/tasks/{taskId}/progress")
		public int setProgress(@RequestBody int progress, @PathVariable int taskId ){
			return taskService.setProgress(progress,taskId);
			 
		}
	  @GetMapping("/api/tasks/status/{status}")
		public List<Task> getTaskByStatus( @PathVariable String status ){
			return taskService.getTaskByStatus(status);
			 
		}
	  
	  @GetMapping("/api/tasks/statistics")
		public Statistics getTaskstatistics( ){
			return taskService.getTaskstatistics();
			 
		}
	  
	  @GetMapping("/api/tasks/overdue")
		public List<Task> getTasksoverdue( ){
			return taskService.getTasksoverdue();
			 
		}
	  
	  @GetMapping("/api/tasks/completed")
		public List<Task> getTasksByDateRange(@RequestParam String startDate, @RequestParam String endDate){
			return taskService.getCompletedTasksByDateRange(startDate,endDate);
			 
		}
	  
	  @GetMapping("/api/tasks/getPriorityQueue")
		public PriorityQueue<Task> getPriorityQueue(){
			return taskService.getPriorityQueue();
			 
		}
	  
	 
}
