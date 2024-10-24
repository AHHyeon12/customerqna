package kr.co.greenart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.greenart.web.customer.qna.QNA;
import kr.co.greenart.web.customer.qna.QNA_Mapper;
//어플리케이션이 구동될 때
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
// 실행할 때 특정 동작을 실행시킬 수 있는 commandLineRunner
	@Autowired
	private QNA_Mapper mapper;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 2; i < 27; i++) {
			mapper.save(QNA.builder()
				.title("title" + i)
				.content("content" + i)
				.username("username" + i)
				.password("password" + i)
				.build());
				
		}
		mapper.save(QNA.builder()
				.title("제목")
				.content("content")
				.username("username")
				.password("password")
				.build());
	}

}
