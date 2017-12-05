package cakemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);

    }
}
