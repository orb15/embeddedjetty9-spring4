package net.ljm.spring;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/* 
 * A simple Spring MVC class to provide test endpoints to demonstrate that the Jetty server is up and running
 */

@Controller
@ResponseBody
public class SpringControllerTestMethods {

	@RequestMapping("/embeddedTestJson")
	public TestPageJsonResponse showTestPageJson() {
		
		return new TestPageJsonResponse();
	}
	
	@RequestMapping("/embeddedTestString")
	public String showTestPageString() {
		
		return  "Embedded Jetty String Test.  Local server time is: " + new Date();
	}
	
	private class TestPageJsonResponse {
		
		private String title;
		private String serverLocalTime;

		public TestPageJsonResponse() {
			
			title = "Embedded Jetty JSON Test";
			serverLocalTime = new Date().toString();
		}
		
		@SuppressWarnings("unused")
		public String getTitle() {return title;}
		@SuppressWarnings("unused")
		public String getServerLocalTime() {return serverLocalTime;}
	}
}
