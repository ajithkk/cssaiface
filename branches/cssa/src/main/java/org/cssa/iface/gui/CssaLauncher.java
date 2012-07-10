/**
 * 
 */
package org.cssa.iface.gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CssaMDIForm iface = new CssaMDIForm();
					iface.setVisible(true);
					iface.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							Util.exitApplicataion();
						}

					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	private void initializeLoging() {
		Properties properties = new Properties();
		ClassLoader loader = this.getClass().getClassLoader();
	    URL iconUrl = loader.getResource("log4j.properties");
		
		try {
			properties.load(iconUrl.openStream());
			PropertyConfigurator.configure(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static final class SplashScreenCloser implements Runnable {

		@Override
		public void run() {
			cssaLogger.info("Closing the splash screen....");
			splashScreen.dispose();
		}
	}
	private void logBasicSystemInfo() {
		//initializeLoging();
		cssaLogger.info("Launching the application...");
	    cssaLogger.info(
	      "Operating System: " + System.getProperty("os.name") + " " + 
	      System.getProperty("os.version")
	    );
	    cssaLogger.info("JRE: " + System.getProperty("java.version"));
	    cssaLogger.info("Java Launched From: " + System.getProperty("java.home"));
	    cssaLogger.info("Class Path: " + System.getProperty("java.class.path"));
	    cssaLogger.info("Library Path: " + System.getProperty("java.library.path"));
	    cssaLogger.info("Application Name: " + CSSAConstants.APP_NAME + "/" + CSSAConstants.APP_VERSION);
	    cssaLogger.info("User Home Directory: " + System.getProperty("user.home"));
	    cssaLogger.info("User Working Directory: " + System.getProperty("user.dir"));
	    cssaLogger.info("Test INFO logging.");
	    cssaLogger.info("Test FINE logging.");
	    cssaLogger.info("Test FINEST logging.");
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
