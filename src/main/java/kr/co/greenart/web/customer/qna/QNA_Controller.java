package kr.co.greenart.web.customer.qna;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QNA_Controller {
	@Autowired
	private QNA_Service service;

	@GetMapping("/qna")
	public String qna(@RequestParam(defaultValue = "0") int page
			, @RequestParam(defaultValue = "10") int size,
			Model model) {
		int limit = size;
		int offset = page * size;
		int totalItems = service.count();
//		int totalPages = totalItems % size == 0 ? totalItems / size : totalItems / size + 1;
		int totalPages = (int) Math.ceil((double) totalItems/size);
		List<QNA> qnaList = service.findAll(limit, offset);
		model.addAttribute("qnaList", qnaList);
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		
		return "qna";
	}
	
	@PostMapping("/qna")
	public String searchingTitle(@RequestParam(defaultValue = "0") int page
			, @RequestParam(defaultValue = "10") int size,
			@RequestParam String searching, Model model) {
		int limit = size;
		int offset = page * size;
		int totalItems = service.countByTitles(searching);
//		int totalPages = totalItems % size == 0 ? totalItems / size : totalItems / size + 1;
		int totalPages = (int) Math.ceil((double) totalItems/size);
	    List<QNA> qnaList = service.findAllByTitle(searching,limit, offset);

	    // qnaList를 모델에 추가하여 뷰로 전달
	    model.addAttribute("qnaList", qnaList);
	    model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);

	    return "qna"; // qna.jsp로 이동
	}
	 

	@GetMapping("/qna/{id}")
	public String readArticle(@PathVariable Integer id, Model model) {
		QNA qna = service.findById(id);

		model.addAttribute("qna", qna);

		return "article";
	}

	// 글 추가 화면을 가져오는 부분
	@GetMapping("/addArticle")
	public String addArticle() {

		return "addArticle";
	}

	// 글 추가 화면을 넣었을 때 들고오는 부분
	@PostMapping("/addArticle")
	public String addPlusArticle(@RequestParam String title, @RequestParam String content,
			@RequestParam String username, @RequestParam String password) {
		QNA qna = QNA.builder().title(title).content(content).username(username).password(password).build();
		int result = service.save(qna);
		return "redirect:/qna";
	}
}
