package com.anaelectronics.listeners;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.anaelectronics.AlarmClock;
import com.anaelectronics.Globals;
import com.anaelectronics.handlers.AlarmHandler;

public class AlarmSetListener implements ActionListener{
	
	private static JPanel boxes = new JPanel();
	private static JPanel buttons = new JPanel();
	private static JFrame dialog = new JFrame("Set Alarm");
	public static JButton okButton = new JButton("OK");
	public static JButton cancelButton = new JButton("Cancel");
	private static JComboBox<Integer> hrs = new JComboBox<Integer>();
	private static JComboBox<String> mins = new JComboBox<String>();
	private static JComboBox<String> ampm = new JComboBox<String>();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		dialog = new JFrame("Set Alarm");
		hrs.removeAllItems();
		mins.removeAllItems();
		ampm.removeAllItems();
		ampm.addItem("AM");
		ampm.addItem("PM");
		for(int i=1;i<13;i++)
			hrs.addItem(i);		
		for(int i=0;i<60;i++)			
			mins.addItem(""+(i<10 ? "0"+i : i));
		dialog.setLayout(new BorderLayout());
		  
        
        dialog.setSize(270, 140); //Fullscreen on our little touch screen we will buy (2" 320x240)
       dialog.setResizable(false);
       
       okButton.addActionListener(new OkListener());
       cancelButton.addActionListener(new CancelListener());
       buttons.add(okButton, BorderLayout.WEST);
       buttons.add(cancelButton, BorderLayout.EAST);
       dialog.add(buttons, BorderLayout.SOUTH);
       boxes.add(hrs, BorderLayout.WEST);
       boxes.add(mins, BorderLayout.CENTER);
       boxes.add(ampm, BorderLayout.EAST);
       dialog.add(boxes, BorderLayout.NORTH);
       Dimension dim = new Dimension(320,240);
       dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);
       dialog.setAutoRequestFocus(true);
       AlarmHandler.convertTime();
       
       dialog.setVisible(true);
		
	}
	
	private class OkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(ampm.getItemAt(ampm.getSelectedIndex()));
			Globals.aPM = ampm.getItemAt(ampm.getSelectedIndex()).equals("PM");
			
			Globals.aminutes = Integer.parseInt(mins.getItemAt(mins.getSelectedIndex()));
			if(!Globals.aPM && hrs.getItemAt(hrs.getSelectedIndex()) == 12)
				Globals.ahours = 0;
			else
			Globals.ahours = (Globals.aPM ? hrs.getItemAt(hrs.getSelectedIndex())+12 : hrs.getItemAt(hrs.getSelectedIndex()));
			
			
			okButton.removeActionListener(this);
			
			dialog.dispose();
			AlarmHandler.convertTime();
			//AlarmClock.updateAlarm();
			
			
			
		}
		
		
		
		
	}
	private class CancelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cancelButton.removeActionListener(this);
			dialog.dispose();
		}
		
		
		
		
	}

}
