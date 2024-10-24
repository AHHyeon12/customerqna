package kr.co.greenart.web.customer.qna;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import kr.co.greenart.web.util.QNA_NotFoundException;

/**
 * ❗ "QNA_ControllerAdvice" 클래스는 QNA 페이지와 관련된 문제를 해결해 주는 친구야!
 * 여기서 '아, 페이지를 못 찾겠네!' 라는 상황(QNA_NotFoundException)이 생기면,
 * '404 에러 페이지'를 사용자에게 보여주는 역할을 해.
 * 
 * @ControllerAdvice는 특정 컨트롤러(QNA_Controller)에서 발생하는 예외를 모아모아 처리하도록 도와주는 거야.
 */
@ControllerAdvice(assignableTypes = QNA_Controller.class)
public class QNA_ControllerAdvice {

    /**
     * 🚨 이 메서드는 'QNA_NotFoundException'이라는 예외가 발생했을 때 호출돼!
     * 그건 마치, 사용자가 QNA 페이지를 찾으려고 했는데... 페이지가 없는 거야! 
     * 그럴 때 우리는 "404 페이지"를 보여줘야 해!
     *
     * @param e 음... 이 친구는 발생한 QNA_NotFoundException 객체야. 
     * 예외가 왜 생겼는지 정보가 들어있어.
     * 
     * @param resp 여기 등장한 친구는 HTTP 응답 객체야! 
     * 이 친구가 "404 에러"라는 신호를 사용자한테 전달해 줄 거야.
     * 
     * @return 그리고 우리는 마지막으로 "notFound"라는 뷰 이름을 반환해서
     * 예쁘게 '페이지를 찾을 수 없어요!' 화면을 보여줄 거야.
     */
    @ExceptionHandler(QNA_NotFoundException.class)
    public ModelAndView notFound(QNA_NotFoundException e) {
		ModelAndView mv = new ModelAndView("notFound");
		mv.setStatus(HttpStatusCode.valueOf(404));
		
        
        // 🔙 그리고 "notFound"라는 이름의 페이지로 보내서 사용자에게 안내해 주자!
		return mv;
		
    }
}
