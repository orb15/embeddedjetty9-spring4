package net.orb15.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/* 
 * This class performs the necessary setup of the Spring MVC infrastructure
 */

public class SpringMvcInitializer implements WebApplicationInitializer {

	private static final String SPRING_CONFIG_PACKAGE = "net.orb15.spring";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//create a new Spring webapp context and add core listeners for requests and lifecycle events
        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
		servletContext.addListener(RequestContextListener.class);
		servletContext.addListener(new ContextLoaderListener(webAppContext));
		
        //tell Spring where to find @Configuration classes for further Spring config
        webAppContext.setConfigLocation(SPRING_CONFIG_PACKAGE);
        
        //create Spring's Dispatcher servlet and tell the servletContext it is present
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        
        //perform additional dispatcher servlet config
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}

}
