package de.bitmarck.networkMonitoringTool.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonEventHandler implements EventHandler<ActionEvent>{

	Button b;
	
	@Override
	public void handle(ActionEvent e) {
		b = (Button)e.getSource();
		if(b.getText().equalsIgnoreCase("Tomcat")) {
			System.out.println(b.getText());;
		} else if(b.getText().equalsIgnoreCase("FirstSpirit")) {
			System.out.println(b.getText());
		}
		
	}

}
