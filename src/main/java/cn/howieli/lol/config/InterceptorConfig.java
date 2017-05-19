package cn.howieli.lol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.howieli.lol.interceptor.APICountInterceptor;
import cn.howieli.lol.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * 不直接new，是因为我需要在拦截器注入service
	 * 找到的解决方案:http://stackoverflow.com/questions/23349180/java-config-for-spring-interceptor-where-interceptor-is-using-autowired-spring-b
	 * @return
	 */
	@Bean
	public APICountInterceptor apiCountInterceptor() {
		return new APICountInterceptor();
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/admin/**")
													.excludePathPatterns("/admin", "/admin/login");
		registry.addInterceptor(apiCountInterceptor()).addPathPatterns("/api/**");
		super.addInterceptors(registry);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController( "/" ).setViewName( "index" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE );
		super.addViewControllers(registry);
	}
	
}
