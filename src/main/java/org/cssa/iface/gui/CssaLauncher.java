/**
 * 
 */
package org.cssa.iface.gui;

import java.awt.EventQueue;
import java.util.logging.Logger;

import org.cssa.iface.infrastructure.CSSAConstants;
import org.cssa.iface.util.Util;

/**
 * @author ajith
 *
 */
public class CssaLauncher {

	private static CssaSplashScreen splashScreen;
	private static final Logger cssaLogger = Util.getLogger(CssaLauncher.class);
	
	private static void showSplashScreen() {
		cssaLogger.info("Showing the splash screen");
		splashScreen = new CssaSplashScreen("crazy-turtle-cartoon-comic.png");
		splashScreen.splash();
	}
	
	private void showMainWindow() {
		cssaLogger.info("Showing the main window");
		CssaMDIForm iface = new CssaMDIForm();
		iface.setVisible(true);
		
	}
	private static final class SplashScreenCloser implements Runnable {

		@Override
		public void run() {
			cssaLogger.fine("Closing the splash screen....");
			splashScreen.dispose();
		}
	}
	private void logBasicSystemInfo() {
		cssaLogger.info("Launching the application...");
	    cssaLogger.config(
	      "Operating System: " + System.getProperty("os.name") + " " + 
	      System.getProperty("os.version")
	    );
	    cssaLogger.config("JRE: " + System.getProperty("java.version"));
	    cssaLogger.info("Java Launched From: " + System.getProperty("java.home"));
	    cssaLogger.config("Class Path: " + System.getProperty("java.class.path"));
	    cssaLogger.config("Library Path: " + System.getProperty("java.library.path"));
	    cssaLogger.config("Application Name: " + CSSAConstants.APP_NAME + "/" + CSSAConstants.APP_VERSION);
	    cssaLogger.config("User Home Directory: " + System.getProperty("user.home"));
	    cssaLogger.config("User Working Directory: " + System.getProperty("user.dir"));
	    cssaLogger.info("Test INFO logging.");
	    cssaLogger.fine("Test FINE logging.");
	    cssaLogger.finest("Test FINEST logging.");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CssaLauncher launcher = new CssaLauncher();
		launcher.logBasicSystemInfo();
		
		try{
			launcher.showSplashScreen();
			Thread.sleep(300);
		}catch (Exception e) {
			// TODO: handle exception
		}
		EventQueue.invokeLater(new SplashScreenCloser());
		launcher.showMainWindow();
		cssaLogger.info("Launch thread now ending ");
		
	}

}
