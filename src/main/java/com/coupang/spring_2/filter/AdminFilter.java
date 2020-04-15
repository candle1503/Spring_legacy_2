package com.coupang.spring_2.filter;

import java.io.IOException;

//import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coupang.spring_2.member.MemberVO;

/**
 * Servlet Filter implementation class AdminFilter
 */
//@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor.
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest)request).getSession();   // HttpServletRequest(부모) ServletRequest (자식)

		MemberVO memberVO = (MemberVO)session.getAttribute("member");

		String command = ((HttpServletRequest)request).getPathInfo();
		
		
		if(memberVO != null) {
			String id = memberVO.getId();
			if(id.equals("admin")) {
				//admin
				System.out.println("Admin");
				chain.doFilter(request, response);

			}else {
				System.out.println("Member");
				RequestDispatcher view = request.getRequestDispatcher("../member/memberLogin");

			}
		}else {
			//로그인 안된 상태
			((HttpServletResponse)response).sendRedirect("../member/memberLogin");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
