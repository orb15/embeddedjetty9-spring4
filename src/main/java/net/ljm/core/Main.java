package net.ljm.core;

import net.ljm.jetty.EmbeddedJetty;
import net.ljm.jetty.JettyConfig;

/* 
 * Main class to launch embedded Jetty server
 */
public class Main {

	public static void main(String[] args) {
		
		try {
			JettyConfig jettyConfig = new JettyConfig();
			EmbeddedJetty.startServer(jettyConfig);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
