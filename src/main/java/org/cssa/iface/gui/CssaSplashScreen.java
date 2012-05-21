/**
 * 
 */
package org.cssa.iface.gui;



import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.ImageObserver;

import org.cssa.iface.util.ImageUtil;

/**
 * @author ajith
 *
 */
public class CssaSplashScreen  extends Frame {
	
	private static final ImageObserver NO_OBSERVER = null;
	private static final int IMAGE_ID  = 0;
	
	private String imageId;
	private MediaTracker mediaTracker;
	private Image image;
	
	CssaSplashScreen(String imageId) {
		if(null == imageId || imageId.trim().length() == 0) {
			throw new IllegalArgumentException("Image Id does not have content.");
		}
		this.imageId = imageId;
		
	}
	public void splash() {
		
		initImageAndTricker();
		setSize(image.getWidth(NO_OBSERVER), image.getHeight(NO_OBSERVER));
	    center();
	    
		mediaTracker.addImage(image, IMAGE_ID);
		try {
			mediaTracker.waitForID(IMAGE_ID);
		}catch (Exception e) {
			System.out.println("Cannot track image load.");
		}
		SplashWindow splashWindow = new SplashWindow(this,image);
	}
	
	private void initImageAndTricker() {
		mediaTracker = new MediaTracker(this);
		image = new ImageUtil().getImage(imageId);
	}
	
	private void center() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle frame = getBounds();
		setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/ 2) ;
		
	}
	
	private class SplashWindow extends Window {
		
		private Image image;
		public SplashWindow(Frame parent, Image image) {
			super(parent);
			this.image = image;
			setSize(image.getWidth(NO_OBSERVER), image.getHeight(NO_OBSERVER));
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle frame = getBounds();
			setLocation((screen.width - frame.width)/2, (screen.height - frame.height)/ 2) ;
			setVisible(true);
		}
		
		public void paint(Graphics graphics) {
			if(null != image) {
				graphics.drawImage(image, 0, 1, this);
			}
		}
	}
	
	public static void main(String[] args) {
		CssaSplashScreen splashScreen = new CssaSplashScreen("crazy-turtle-cartoon-comic.png");
		splashScreen.splash();
		try {
		      Thread.sleep(3000);
		    }
		    catch(InterruptedException ex) {
		      System.out.println(ex);
		    }
		   System.exit(0);
		  }
	}
	
	
	
	


