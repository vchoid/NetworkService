package de.bitmarck.networkMonitoringTool.application;

import java.net.URL;
import java.util.ResourceBundle;

import de.bitmarck.networkMonitoringTool.Controller.ButtonEventHandler;
import de.bitmarck.networkMonitoringTool.model.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewController implements Initializable   {
	
	@FXML
	private TableView<Service> tv;
	@FXML
	private TableColumn<Service, String> serverCol;
	@FXML
	private TableColumn<Service, Button> connCol;
	
	private ButtonEventHandler beh = new ButtonEventHandler();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setTableColumnValue();
		tv.setItems(getConnectionList());
		
	}
		
	public ObservableList<Service> getConnectionList(){
		ObservableList<Service> os = FXCollections.observableArrayList();
		os.add(new Service("Auslieferung", getTomConnection()));
		os.add(new Service("Test", getTomConnection()));
		os.add(new Service("Stage", getTomConnection()));
		os.add(new Service("PreProd", getTomConnection()));
		os.add(new Service("Auslieferung", getFirstConnection()));
		os.add(new Service("Test", getFirstConnection()));
		os.add(new Service("Stage", getFirstConnection()));
		os.add(new Service("PreProd", getFirstConnection()));
		
		return os;
	}
	
	public Button getTomConnection() {
		Button btn = new Button("Tomcat");
		btn.setId(btn.getText());
		btn.setMaxWidth(150);
		btn.setOnAction(beh);
		
		return btn;
	}
	
	public Button getFirstConnection() {
		Button btn = new Button("FirstSpirit");
		btn.setId(btn.getText());
		btn.setMaxWidth(150);
		btn.setOnAction(beh);
		
		return btn;
	}
	
	public void setTableColumnValue() {
		serverCol.setCellValueFactory(new PropertyValueFactory<Service, String>("server"));
		connCol.setCellValueFactory(new PropertyValueFactory<Service, Button>("connection"));
	}

	
	
}
