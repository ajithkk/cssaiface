/**
 * 
 */
package org.cssa.iface.util;


import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;

import javax.swing.Icon;
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
			URL url = loader.getResource("image" +"/" + name);  
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
			URL url = loader.getResource("image" +"/"+ name); 
			if(null != url) {
				image = Toolkit.getDefaultToolkit().getImage(url);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return image;
	}
	
	public String getImageUrl(String name) {
		URL url = null;
		Image image = null;
		try {
			ClassLoader loader = this.getClass().getClassLoader();
		    url = loader.getResource("image" +"/"+ name.trim()); 
			if(null != url) {
				image = Toolkit.getDefaultToolkit().getImage(url);
			}else {
				return "Null";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return url.toString();
	}
	
	public  Icon getIcon(String name) {
		Icon image = null;
		try { 
			ClassLoader loader = this.getClass().getClassLoader();
			URL url = loader.getResource("image" +"/"+ name);  
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
}
