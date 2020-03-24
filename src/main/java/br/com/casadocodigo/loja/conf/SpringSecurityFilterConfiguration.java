package br.com.casadocodigo.loja.conf;

import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class SpringSecurityFilterConfiguration extends AbstractSecurityWebApplicationInitializer{
	@Override
	protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		servletContext.addFilter("encodingFilter", filter).addMappingForUrlPatterns(null, false, "/*");;

	}

}
