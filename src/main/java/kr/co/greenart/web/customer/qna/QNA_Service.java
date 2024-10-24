package kr.co.greenart.web.customer.qna;

import java.util.List;

// 요구사항 도출 / 검증
public interface QNA_Service {
	QNA findById(Integer articleId);
	List<QNA> findAll(int pageSize, int OFFSET);
	int save(QNA qna);
	int count();
	int countByTitles(String title);
	List<QNA> findAllByTitle(String searching, int pageSize, int offset);

}
