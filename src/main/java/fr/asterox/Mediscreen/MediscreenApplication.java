package fr.asterox.Mediscreen;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@EnableZuulProxy
@EnableDiscoveryClient
@EnableFeignClients("fr.asterox")
@SpringBootApplication
public class MediscreenApplication {
	private static final Logger LOGGER = LogManager.getLogger(MediscreenApplication.class);

	public static void main(String[] args) throws IOException {
		LOGGER.info("Initializing Mediscreen");
		SpringApplication.run(MediscreenApplication.class, args);
	}
}
