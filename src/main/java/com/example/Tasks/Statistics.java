package com.example.Tasks;

import org.springframework.stereotype.Component;

@Component
public class Statistics {
	
	int totalTasks;
	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public double getCompletedTaskspercentage() {
		return completedTaskspercentage;
	}

	public void setCompletedTaskspercentage(double completedTaskspercentage) {
		this.completedTaskspercentage = completedTaskspercentage;
	}

	int completedTasks;
	
	double completedTaskspercentage;

}
