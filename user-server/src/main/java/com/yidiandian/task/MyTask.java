package com.yidiandian.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class MyTask implements Job {

    @Autowired
    private DemoService service;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        service.server("1");
    }
}
