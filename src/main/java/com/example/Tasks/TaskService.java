package com.example.Tasks;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	
	@Autowired
	Statistics statistics;
	public void saveOrupdate(Task task) {
		taskRepository.save(task);
	}
	
	
	public void delete(int task) {
		taskRepository.deleteById(task);
	}
	
	public List<Task> getAll() {
		return taskRepository.findAll();
	}
	
	  public int assignTask(int taskid, int userid) {
		  return taskRepository.assignTask(taskid, userid);
		  }
	  public List<Task> findByuserId(int userid) {
			return taskRepository.findByuserId(userid);
		}
	  public int setProgress(int progress, int taskid) {
			return taskRepository.setProgress(progress,taskid);
		}


	public List<Task> getTaskByStatus(String status) {
		// TODO Auto-generated method stub
		return taskRepository.findBystatus(status);
	}
	public Statistics getTaskstatistics() {
		statistics.setCompletedTasks(this.getTaskByStatus("completed").size());
		statistics.setTotalTasks(this.getAll().size());
		
		statistics.setCompletedTaskspercentage(((double)statistics.getCompletedTasks()/(double)statistics.getTotalTasks()) * 100);
		
		return statistics;
	}


	public List<Task> getTasksoverdue() {
		// TODO Auto-generated method stub
		Calendar currentDate=Calendar.getInstance();
		String date=String.valueOf(currentDate.get(Calendar.YEAR))
				+"-"+String.valueOf(currentDate.get(Calendar.MONTH)+1)+"-"+String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
		return taskRepository.findBydueDateLessThan(date);
		
	}
	public List<Task> getCompletedTasksByDateRange(String startDate, String toDate) {
		// TODO Auto-generated method stub
		List<Task> list=taskRepository.findBydueDateBetween(startDate,toDate);
		list=list.stream().filter(task->task.status.equals("Completed")).collect(Collectors.toList());
		return list;
		
	}


	public PriorityQueue<Task> getPriorityQueue() {
		// TODO Auto-generated method stub
		PriorityQueue<Task> list=new PriorityQueue<>();

		list.addAll(this.getAll());
		
		return list;
	}

	  

}
