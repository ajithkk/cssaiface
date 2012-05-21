/**
 * 
 */
package org.cssa.iface.util;


import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Class to load images
 * @author ajith
 *
 */
public class ImageUtil {
	
	public ImageUtil() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param name image name  
	 * @return image 
	 */
	public  ImageIcon loadImage(String name) {
		ImageIcon image = null;
		try { 
			ClassLoader loader = this.getClass().getClassLoader();
			URL url = loader.getResource("image" + File.separator + name);  
			if(url != null) {
				java.awt.Image img = Toolkit.getDefaultToolkit().createImage(url);
				if(img != null) {
					image = new ImageIcon(img);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return image;
	}
	
	public Image getImage(String name) {
		Image image = null;
		try {
			ClassLoader loader = this.getClass().getClassLoader();
			URL url = loader.getResource("image" + File.separator + name); 
			if(null != url) {
				image = Toolkit.getDefaultToolkit().getImage(url);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return image;
	}
	
}
