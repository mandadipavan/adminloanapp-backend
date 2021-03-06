package com.eclerx.flowable.loanrequestprocess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.eclerx.flowable.loanrequestprocess.pojo.Customer;
import com.eclerx.flowable.loanrequestprocess.property.FileStorageProperties;
import com.eclerx.flowable.loanrequestprocess.service.CustomerService;


@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class LoanrequestprocessApplication {
    
	Logger logger = LoggerFactory.getLogger(LoanrequestprocessApplication.class);
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private RuntimeService runtimeService;
	
	public static void main(String[] args) {
		SpringApplication.run(LoanrequestprocessApplication.class, args);
	}
	@PostConstruct
	public void fetchProcessInstances() throws ParseException {
		
		List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().active().list();	
	}

}
