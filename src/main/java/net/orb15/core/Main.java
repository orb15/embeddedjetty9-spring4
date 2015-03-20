package net.orb15.core;

import net.orb15.jetty.EmbeddedJetty;
import net.orb15.jetty.JettyConfig;

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
