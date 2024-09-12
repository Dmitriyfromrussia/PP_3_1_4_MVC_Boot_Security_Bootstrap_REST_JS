package ru.dab.PP_3_1_3_MVC_Boot_Security_Bootstrap;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Pp313MvcBootSecurityBootstrapApplication.class);
	}

}
