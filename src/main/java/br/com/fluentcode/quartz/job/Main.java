package br.com.fluentcode.quartz.job;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
	
	public static void main(String[] args) {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
		    // Starts the scheduler
		    scheduler.start();
			
			// Define the job and tie it to our HelloJob class
			JobDetail job = newJob(HelloJob.class)
			        .withIdentity("job1", "group1")
			        .build();

			// Trigger the job to run now, and then repeat every 3 seconds
		    Trigger trigger = newTrigger()
		        .withIdentity("trigger1", "group1")
		        .startNow()
		        // Cron expression "0/3 * * * * ?" means "every 3 seconds"
		        .withSchedule(cronSchedule("0/3 * * * * ?"))            
		        .build();
		    
		    // Tell quartz to schedule the job using our trigger
		    scheduler.scheduleJob(job, trigger);
		    
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
}
