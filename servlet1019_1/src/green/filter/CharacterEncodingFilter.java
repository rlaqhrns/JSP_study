package green.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter(
//	      urlPatterns = "/*",
//	      initParams = {
//	            @WebInitParam(name="encoding", value="utf-8")
//	      })
public class CharacterEncodingFilter implements Filter {
	FilterConfig config; //멤버 변수
   
  
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding(config.getInitParameter("encoding")); //web.xml에서 가져온다.
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
