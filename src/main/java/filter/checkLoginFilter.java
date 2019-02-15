package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import model.Member;


public class checkLoginFilter extends OncePerRequestFilter {
	List<String> url = new ArrayList<String>();
	String servletPath;
	String contextPath;
	String requestURI;

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean isRequestedSessionIdValid = false;
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			servletPath = req.getServletPath();  
			contextPath = req.getContextPath();
			requestURI  = req.getRequestURI();
			isRequestedSessionIdValid = req.isRequestedSessionIdValid();
			
			           
				if (checkLogin(req)) {   
					//  需要登入，但已經登入
					filterChain.doFilter(request, response);
				} else {				
					//  需要登入，尚未登入，所以送回登入畫面
					HttpSession session = req.getSession();
				    // 記住原本的"requestURI"，稍後如果登入成功，系統可以自動轉入
					// 原本要執行的程式。
					session.setAttribute("requestURI", requestURI);
					if ( ! isRequestedSessionIdValid ) {
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					}
					resp.sendRedirect("/FlyAvis/login");
					return;
				}
			
		} else {
			throw new ServletException("Request/Response 型態錯誤(極不可能發生)");
		}
		
//		System.out.println("############TestFilter doFilterInternal executed############");
//		filterChain.doFilter(request, response);
//		System.out.println("############TestFilter doFilter after############");

	}
	private boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		
		Member loginToken = (Member) session.getAttribute("LoginOK");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}
	

}
