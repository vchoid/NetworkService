package de.bitmarck.networkMonitoringTool.model;

import javafx.scene.control.CheckBox;

public class Service {

	private String server;
	private CheckBox connection;
	
	
	public Service(String server, CheckBox connection) {
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
	public CheckBox getConnection() {
		return connection;
	}
	public void setConnection(CheckBox connection) {
		this.connection = connection;
	}
	
	
}
