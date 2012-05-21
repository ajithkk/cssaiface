package org.cssa.iface.gui.events;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.cssa.iface.gui.college.CollegeDetilsView;

/**
 * 
 * @author ajith
 * @since 1/27/2012
 */

public class EventsController implements ActionListener  {
	
	EventsView eventsView = null;
	EventTableModel eventTableModel = null;
	
	public EventsController() {
		eventTableModel = new EventTableModel(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command =  e.getActionCommand();
		if(EventsView.CANCEL.equals(command)) {
			eventsView.setEventCode("Cancel Clicked");
		}
		if(EventsView.CLEAR.equals(command)) {
			clearEventView();
		}
		if(EventsView.SAVE.equals(command)) {
			eventsView.setEventCode("Save Clicked");
		}
		if(EventsView.DELETE.equals(command)) {
			eventsView.setEventCode("Delete Clicked");
		}
		
		if(EventsView.EDIT.equals(command)) {
			eventsView.setEventCode("Edit Clicked");
		}
		if(EventsView.PRINT.equals(command)) {
			eventsView.setEventCode("Print Clicked");
		}
		
	}
	
	/**
	 * Clear EventView TextFiels Data
	 */
	private void clearEventView() {
		eventsView.setEventCode("");
		eventsView.setEventName("");
		eventsView.setMaxParticipants("");
		eventsView.setPoints("");
		
	}

	public  Component askEventView() {
		eventsView = new EventsView(this,eventTableModel);
		return eventsView.showEventscreen();
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				try {
				      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels())
				        if ("Nimbus".equals(laf.getName())) UIManager.setLookAndFeel(laf.getClassName());
				    } catch(Exception e) {
				      e.printStackTrace();
				    }
				JFrame frame = new JFrame();
				/*try {
		            // Set System L&F
		        UIManager.setLookAndFeel(
		            UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (UnsupportedLookAndFeelException e) {
		       // handle exception
		    }
		    catch (ClassNotFoundException e) {
		       // handle exception
		    }
		    catch (InstantiationException e) {
		       // handle exception
		    }
		    catch (IllegalAccessException e) {
		       // handle exception
		    }*/
				//EventsView eventsView = new EventsView(this, new EventTableModel());

				/*frame.setLayout(new GridBagLayout());
				GridBagConstraints constraints = new GridBagConstraints();
				constraints.gridx = 0;
				constraints.gridy = 0;*/
				frame.add(new EventsController().askEventView());
				//constraints.anchor = GridBagConstraints.NORTHWEST;
				// frame.add(new Event().init(),BorderLayout.NORTH);
				//frame.add(new CollegeDetilsView(this).getCollegeDetailsPanel(),
					//	constraints);
				// f//rame.add(new Event().getBottamPanel(), BorderLayout.CENTER);
				// frame.add(new Event().getSideButtonPanel(), BorderLayout.)
				//frame.pack();
				 /*constraints = new GridBagConstraints();
				constraints.gridx = 0;
				constraints.gridy = 2;*/
				//constraints.anchor = GridBagConstraints.NORTHWEST;
				//frame.add(new CollegeDetilsView().getMainDetailsPanel(),
						//constraints);
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.setSize(800, 400);
				frame.setVisible(true);
			}
		});
	}

}
