package net.ljm.jetty;

import net.ljm.spring.SpringMvcInitializer;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.ClassInheritanceHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.web.WebApplicationInitializer;

/* 
 * The embedded Jetty Server Java configuration
 */
public class EmbeddedJetty {
	
	public static void startServer(JettyConfig jettyConfig) throws Exception {
		
		if(!jettyConfig.isQuietMode())
		{
			System.out.println();
			System.out.println("Starting embedded jetty...");
		}
		
		//create the server
		Server server = new Server();
		ServerConnector c = new ServerConnector(server);
		
		//set the context path
	     WebAppContext webAppContext = new WebAppContext();
	     webAppContext.setContextPath("/");
	     webAppContext.setWelcomeFiles(new String[] {"/static/test.html"});
	     
	     //tell the webApp about our Spring MVC web initializer. The hoops I jump through here are because
	     //Jetty 9 AnnotationConfiguration doesn't scan non-jar classpath locations for a class that implements WebApplicationInitializer.
	     //The code below explicitly tells Jetty about our implementation of WebApplicationInitializer.
	     
	     //this Jetty bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=404176  and the discussion around it defines the issue best. I decided
	     //I would not rely on the potentially buggy solution put into Jetty 9 (discussed in the bug thread) and just go for a fix I know would work.  
	     webAppContext.setConfigurations(new Configuration[] { 
	    		 new AnnotationConfiguration() {
	    		        @Override
	    		        public void preConfigure(WebAppContext context) throws Exception {
	    		        	ClassInheritanceMap map = new ClassInheritanceMap();
	    		            ConcurrentHashSet<String> hashSet = new  ConcurrentHashSet<String>();
	    		            hashSet.add(SpringMvcInitializer.class.getName());
	    		            map.put(WebApplicationInitializer.class.getName(), hashSet);
	    		            context.setAttribute(CLASS_INHERITANCE_MAP, map);
	    		            _classInheritanceHandler = new ClassInheritanceHandler(map);
	    		        }
	    		    } 
		 });
	     server.setHandler(webAppContext);
		
		//core server configuration
		c.setIdleTimeout(jettyConfig.getIdleTimeout());
		c.setAcceptQueueSize(jettyConfig.getAcceptQueueSize());
		c.setPort(jettyConfig.getPort());
		c.setHost(jettyConfig.getHost());
		server.addConnector(c);
		
		//start the server and make it available when initialization is complete
		server.start();
		server.join();
	}

}
