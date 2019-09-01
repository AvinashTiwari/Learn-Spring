package learn.avinash.springcloudservice;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableTask
@SpringBootApplication
public class MySpringCloudProcess {



	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudProcess.class, args);
	}

}
