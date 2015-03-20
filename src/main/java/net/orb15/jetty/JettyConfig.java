package net.orb15.jetty;

/* 
 * Jetty configuration JavaBean / POJO to hold all the necessary configuration options for a Jetty embedded server
 * and their default values.
 */
public class JettyConfig {

	private static final int DEFAULT_IDLE_TIMEOUT = 1000;
	private static final int DEFAULT_ACCEPT_QUEUE_SIZE = 10;
	private static final int DEFAULT_PORT = 8080;
	
	private static final String DEFAULT_HOST = "localhost";
	
	private static final boolean DEFAULT_QUIET_MODE = false;
	
	private int idleTimeout;
	private int acceptQueueSize;
	private int port;
	
	private String host;

	private boolean quietMode;
	
	public JettyConfig() {
		
		idleTimeout = DEFAULT_IDLE_TIMEOUT;
		acceptQueueSize = DEFAULT_ACCEPT_QUEUE_SIZE;
		port = DEFAULT_PORT;
		
		host = DEFAULT_HOST;

		quietMode = DEFAULT_QUIET_MODE;
	}

	public int getIdleTimeout() {
		return idleTimeout;
	}

	public void setIdleTimeout(int idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public int getAcceptQueueSize() {
		return acceptQueueSize;
	}

	public void setAcceptQueueSize(int acceptQueueSize) {
		this.acceptQueueSize = acceptQueueSize;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public boolean isQuietMode() {
		return quietMode;
	}

	public void setQuietMode(boolean quietMode) {
		this.quietMode = quietMode;
	}
}
