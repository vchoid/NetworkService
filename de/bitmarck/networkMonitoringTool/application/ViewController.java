package de.bitmarck.networkMonitoringTool.application;

import java.net.URL;
import java.util.ResourceBundle;

import de.bitmarck.networkMonitoringTool.model.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	
	public CheckBox getTomConnection() {
		CheckBox btn = new CheckBox("Tomcat");
		btn.setId(btn.getText());
		btn.setMaxWidth(150);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn.setPickOnBounds(true);
				System.out.println("Der Button: " + btn.getId());				
			}
		});
		return btn;
	}
	
	public CheckBox getFirstConnection() {
		CheckBox btn = new CheckBox("FirstSpirit");
		btn.setId(btn.getText());
		btn.setMaxWidth(150);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Der Button: " + btn.getId());				
			}
		});
		return btn;
	}
	
	public void setTableColumnValue() {
		serverCol.setCellValueFactory(new PropertyValueFactory<Service, String>("server"));
		connCol.setCellValueFactory(new PropertyValueFactory<Service, Button>("connection"));
	}

	
	
}
