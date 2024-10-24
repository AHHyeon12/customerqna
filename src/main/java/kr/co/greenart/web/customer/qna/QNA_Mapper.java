package kr.co.greenart.web.customer.qna;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface QNA_Mapper {
	@Select("Select Count(*) From customerqna")
	int count();
	
	@Select("Select Count(*) From customerqna Where title LIKE CONCAT('%', #{searching}, '%')")
	int countByTitles(String title);
	
	
	// 글 작성
	@Insert({ "INSERT INTO customerqna (title, content, username, password)",
			"VALUES (#{title}, #{content}, #{username}, #{password})" })
	@Options(useGeneratedKeys = true, keyProperty = "articleId")
	// 게시글 목록(id, title, username, is_secure)
	//@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyColumn = "article_id", keyProperty = "articleId", resultType = Integer.class, before = false)
	int save(QNA qna);

	@Select({ "SELECT article_id, title, content, username, views, is_secure, created_at, updated_at FROM customerqna",
			"ORDER BY article_id DESC", "LIMIT #{pageSize} OFFSET #{OFFSET}" })
	@Results(id = "qnaList", value = { @Result(column = "article_id", property = "articleId"),
			@Result(column = "title", property = "title"), @Result(column = "content", property = "content"),
			@Result(column = "username", property = "username"), @Result(column = "views", property = "views"),
			@Result(column = "is_secure", property = "secure"),
			@Result(column = "created_at", property = "createdAt"),
			@Result(column = "updated_at", property = "updatedAt")})
	List<QNA> findAll(int pageSize, int OFFSET);

	@Select({ "SELECT article_id, title, content, username, views, is_secure, created_At, updated_At FROM customerqna", "WHERE is_secure = 0",
			"ORDER BY article_id DESC", "LIMIT #{limit} OFFSET #{pageSize}" })
	@ResultMap("qnaList")
	List<QNA> findBySecureIsFalse(int pageSize, int OFFSET);

	// 게시글 조회 시, is_secure 값이 false인 행만 조회
	@Select("SELECT * FROM customerqna WHERE article_Id = #{articleId}")
	@Results(id = "qnaMapping", value = { @Result(column = "article_id", property = "articleId", id = true),
			@Result(column = "title", property = "title"), @Result(column = "content", property = "content"),
			@Result(column = "username", property = "username"), @Result(column = "views", property = "views"),
			@Result(column = "is_secure", property = "secure") 
			,@Result(column = "is_deleted", property = "deleted"),
			@Result(column = "created_at", property = "createdAt"),
			@Result(column = "updated_at", property = "updatedAt")
	})
			QNA findById(Integer articleId);
	
	
	@Select("SELECT article_id, title, content, username, views, "
			+ "is_secure, created_at, updated_at "
	        + "FROM customerqna "
	        + "WHERE title LIKE CONCAT('%', #{searching}, '%')"
	        + "ORDER BY article_id DESC LIMIT #{pageSize} OFFSET #{offset}")
	@ResultMap("qnaList")
	List<QNA> findAllByTitle(String searching, int pageSize, int offset);


	
	
	@Update("UPDATE customerqna SET views = views + 1 WHERE article_id = #{articleId}")
	int updateCount(Integer articleId);
  
	// TODO SQL 명령문 구현
	void findBySecureIsFalse();

	// 게시글 조회(id로 검색, title, content, username)
	void findByPk();

	// 게시글(id)의 비밀 여부 조회 (is_secure)
	void findSecureByPk();

	// views count 수정(id)(1 증가)
	void updateCount();

	// 글 논리 삭제(pk 및 password 일치) : is_deleted => 1로 수정
	void updateDelete();

}
