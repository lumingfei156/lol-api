package cn.howieli.lol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@MapperScan("cn.howieli.lol.dao")
@EnableScheduling
@SpringBootApplication
public class LolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LolApiApplication.class, args);
	}
}
