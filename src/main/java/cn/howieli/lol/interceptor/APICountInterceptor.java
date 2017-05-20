package cn.howieli.lol.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.howieli.lol.service.ICountService;

public class APICountInterceptor implements HandlerInterceptor {
	@Autowired
	private ICountService countService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (countService.selectToday() == null) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			countService.insertToday();
			System.out.println("定时器还未执行，直接插入当天计数，成功-------->" + format.format(new Date()));
		}
		countService.updateToday();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
