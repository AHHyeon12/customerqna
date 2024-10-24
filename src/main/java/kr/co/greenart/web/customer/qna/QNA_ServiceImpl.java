package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.web.util.QNA_IsSecure;
import kr.co.greenart.web.util.QNA_NotFoundException;

// service를 구현하는 구현객체

@Service
@Primary
public class QNA_ServiceImpl implements QNA_Service {
	
	// mapper에 대한 의존성 주입
	@Autowired
	private QNA_Mapper mapper;
	
	@Override
	@Transactional
	public QNA findById(Integer articleId) {
		
		QNA qna = mapper.findById(articleId);
		
		if (qna == null) {
			throw new QNA_NotFoundException(articleId);
		}
		
		 
		 if (qna.getSecure()) {
			 throw new QNA_IsSecure(articleId);
		 }

		
	 int rows = mapper.updateCount(articleId);
	 if (rows == 1) {
		 qna.setViews(qna.getViews() + 1);
	 }
		
		return qna;
	}

	@Override
	public List<QNA> findAll(int pageSize, int OFFSET) {
		return mapper.findAll(pageSize, OFFSET);
	}

	@Override
	public int save(QNA qna) {
		return mapper.save(qna);
	}

	@Override
	public int count() {
		return mapper.count();
	}



	@Override
	public int countByTitles(String title) {
		// TODO Auto-generated method stub
		return mapper.countByTitles(title);
	}

	@Override
	public List<QNA> findAllByTitle(String searching, int pageSize, int offset) {
		// TODO Auto-generated method stub
		return mapper.findAllByTitle(searching, pageSize, offset);
	}
}
