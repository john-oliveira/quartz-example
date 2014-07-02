package br.com.fluentcode.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("Hello World! " + new Date());
	}

}
