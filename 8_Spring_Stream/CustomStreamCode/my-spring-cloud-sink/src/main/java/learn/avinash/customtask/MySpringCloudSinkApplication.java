package learn.avinash.customtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableBinding(Sink.class)
@SpringBootApplication
public class MySpringCloudSinkApplication {


    private static Logger logger = LoggerFactory.getLogger(MySpringCloudSinkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MySpringCloudSinkApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {

        logger.info("Received: " + date);
    }


}