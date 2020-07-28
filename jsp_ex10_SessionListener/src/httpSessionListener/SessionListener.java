package httpSessionListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	static int activeSessions;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("sessionCreated");
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("sessionDestroyed");
		activeSessions--;
	}
}
