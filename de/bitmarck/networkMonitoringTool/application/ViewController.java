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
		os.add(new Service("PreProd", getTomConnection()));
		os.add(new Service("Auslieferung", getFirstConnection()));
		os.add(new Service("Test", getFirstConnection()));
		os.add(new Service("Stage", getFirstConnection()));
		os.add(new Service("PreProd", getFirstConnection()));
		
		return os;
	}
	
	CheckBox cTom;
	public CheckBox getTomConnection() {
		cTom = new CheckBox("Tomcat");
		cTom.setId(cTom.getText());
		cTom.setMaxWidth(150);
		// Werte verändern
		cTom.setSelected(true);
		
		cTom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
					System.out.println("isSelected: " + cTom.isSelected());
					System.out.println("Der Button: " + cTom.getId());				
			}
		});
		return cTom;
	}
	CheckBox cFirst;
	public CheckBox getFirstConnection() {
		 cFirst = new CheckBox("FirstSpirit");
		 cFirst.setId(cFirst.getText());
		 cFirst.setMaxWidth(150);
		 cFirst.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Der Button: " + cFirst.getId());				
			}
		});
		return cFirst;
	}
	
	public void setTableColumnValue() {
		serverCol.setCellValueFactory(new PropertyValueFactory<Service, String>("server"));
		connCol.setCellValueFactory(new PropertyValueFactory<Service, Button>("connection"));
	}

	
	
}
