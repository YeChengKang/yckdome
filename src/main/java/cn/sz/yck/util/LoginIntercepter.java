package cn.sz.yck.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter implements HandlerInterceptor {
	
	private String [] arr = {"uc/login","","bc/findall","bc/findbyid"};
	
	public boolean checkUrl(String myurl) {
		
		if(myurl.endsWith(".jsp")||myurl.endsWith(".png")||myurl.endsWith(".css")||myurl.endsWith(".js")) {
			return true;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(myurl)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �������ִ�еĲ�����һ�������ͷ���Դ
	 * Ҫ��preHandle�������뷵��true���Ż�ִ��afterCompletion����
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("�������ʱ�Ĳ���");
	}

	/**
	 * Ŀ�귽��ִ��֮��Ĳ���
	 * Ҫ��preHandle�������뷵��true���Ż�ִ��postHandle����
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("Ŀ�귽��ִ��֮��Ĳ���");
	}

	/**
	 * ��Ŀ�귽��ִ��֮ǰҪ��ɵĲ���
	 * �����������true��������Լ����������������false�����󽫵���Ϊֹ������Ŀ�귽����������ִ�У�
	 */
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Ŀ�귽��ִ��֮ǰ�Ĳ���");
		//��һ��ͨ��request.getSession()���õ�session
		HttpSession session = request.getSession();
		//�ڶ���ͨ��session.getAttribute���õ�һ��Object����
		Object obj = session.getAttribute("myusers");
		
		String path = request.getContextPath();
		String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		if(obj==null) {
			
			String uri = request.getRequestURI();
			String myurl = uri.substring(path.length()+1);
			System.out.println("myurl"+myurl);
			if(this.checkUrl(myurl)) {
				return true;
			}
			
			response.sendRedirect(basepath+"/uc/login");
			return false;
		}
		return true;
	}

}
