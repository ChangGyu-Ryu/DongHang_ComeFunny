package common.interceptor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

//InterCeptor
//dispatcher Servlet이 Controller의 메서드를 호출하기 전에
//요청을 가로채서 필요한 선작업을 할 수 있다.

//filter
//Servlet Container가 servlet을 호출하기 전에 요청을 필터링하는 역할
// servlet Container > filter > dispatcher-Servlet >
// interceptro > controller

//filter : 실행되는 영역이 servlet container
//interceptor : 실행되는 영역이 Spring Framework
//aop : 개발자가 작성하는 로직
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request
				, HttpServletResponse response, Object handler) throws ServletException, IOException {
		
		if(request.getRequestURI().contains("notice/")
				&& request.getSession().getAttribute("logInInfo") == null) {
			request.setAttribute("alertMsg", "비회원은 접근할 권한이 없습니다.");
			request.setAttribute("url", request.getContextPath()+"/member/login.do");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			rd.forward(request, response);
			//컨트롤러 메소드를 호출하지 않음!
			return false;
			
		}
		
		return true;
			
		
		
	}
	
	

}
