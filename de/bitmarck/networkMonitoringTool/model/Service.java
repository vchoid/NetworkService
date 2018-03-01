package de.bitmarck.networkMonitoringTool.model;

import javafx.scene.control.Button;

public class Service {

	private String server;
	private Button connection;
	
	
	public Service(String server, Button connection) {
		super();
		this.server = server;
		this.connection = connection;
	}
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public Button getConnection() {
		return connection;
	}
	public void setConnection(Button connection) {
		this.connection = connection;
	}
	
	
}
