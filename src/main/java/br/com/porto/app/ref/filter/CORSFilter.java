package br.com.porto.app.ref.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class CORSFilter implements Filter {

    public CORSFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void destroy() {
    }
     	
    public void doFilter(
        ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    	String origin =  ((HttpServletRequest) request).getHeader("Origin");
    	
////        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "X-Requested-With");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Credentials", "true");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
//        ((HttpServletResponse) response).setHeader("Access-Control-Max-Age", "3600");
////        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        
////        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "file://localhost/Users/tiagolopes/Documents/workspace-re/aula02/acess.html");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
//        
////        ((HttpServletResponse) response).addHeader("Access-Control-Expose-Headers", "x-auth-token");
//
//        ((HttpServletResponse) response).addHeader("x-auth-token", "ksajkldjlasdfjasoiudruehfhjasjhfkdshjfhgsdygfruyiwerioiupweqiuerqwiou34898794ry8ewuhjhkdjk");
////        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
//       
//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        ((HttpServletResponse) response).setHeader("Access-Control-Max-Age", "3600");
//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "x-requested-with, X-Auth-Token, Content-Type");
        
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*, http://127.0.0.1:8080");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With, POST, GET, OPTIONS, DELETE, accept, x-requested-with, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept ");
        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "GET, PUT, OPTIONS, X-XSRF-TOKEN, x-requested-with, X-Auth-Token, Content-Type");
        
//      ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
      ((HttpServletResponse) response).addHeader("Access-Control-Allow-Credentials", "true");
      ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
        
        chain.doFilter(request, response);
    }
}
