package kr.co.greenart.web.customer.qna;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder// 필드값이 많을 때는 builder활용
public class QNA {
	private Integer articleId; // 게시판 글 번호
	private String title; // 제목
	private String content; // 내용
	private String username; // 사용자 이름
	private String password; // 비번
	private Integer views; // 조회수
	private LocalDateTime createdAt; // 날짜 시간
	private LocalDateTime updatedAt;
	private Boolean secure; // 비밀
	private Boolean deleted; // 삭제
}
