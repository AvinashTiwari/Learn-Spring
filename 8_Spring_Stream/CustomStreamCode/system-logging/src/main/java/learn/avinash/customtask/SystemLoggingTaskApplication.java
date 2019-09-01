package learn.avinash.customtask;

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
public class SystemLoggingTaskApplication {

	@Bean
	public MySystemLog mySystemLog(){
		return new MySystemLog();
	}

	public static void main(String[] args) {
		SpringApplication.run(SystemLoggingTaskApplication.class, args);
	}

	public static class MySystemLog implements ApplicationRunner{
		@Override
		public void run(ApplicationArguments args) throws Exception {
			System.out.println("Run method " + new SimpleDateFormat().format(new Date()));
		}
	}
}
