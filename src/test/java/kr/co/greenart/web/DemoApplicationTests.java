package kr.co.greenart.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.greenart.web.customer.qna.QNA;
import kr.co.greenart.web.customer.qna.QNA_Mapper;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoApplicationTests {
	@Autowired
	private QNA_Mapper mapper;
	
	@Test
	@Order(1) // 낮은 값이 우선순위라서 먼저 실행됨
	void contextLoads() {
		QNA qna = QNA.builder().title("제목").content("내용").username("유저네임").password("비밀번호").build();
		int rows = mapper.save(qna);
		
		assertEquals(1, rows); // 한줄이 추가되면 pk값이 0이 아닐때 추가되도록함
		assertNotNull(qna.getArticleId());
		}
	
	@Test
	@Order(2)
	void atestSelect() {
		List<QNA> all = mapper.findAll(10, 0);
		
		assertNotEquals(0, all.size());
	}
}
