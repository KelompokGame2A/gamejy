import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class main extends Application {
	
	static ArrayList<Member> mlist = new ArrayList<Member>();
	static ArrayList<Clan> clist = new ArrayList<Clan>();
	TableView<Member> table;
	//
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("GAME COC");
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20));
		
		TableColumn<Member, String> clanClm = new TableColumn<>("Clan");
		clanClm.setMinWidth(120);
		clanClm.setCellValueFactory(new PropertyValueFactory<>("clan"));
		
		TableColumn<Member, String> memberClm = new TableColumn<>("Member");
		memberClm.setMinWidth(120);
		memberClm.setCellValueFactory(new PropertyValueFactory<>("namaMbr"));
		
		TableColumn<Member, String> thClm = new TableColumn<>("TH");
		thClm.setMinWidth(50);
		thClm.setCellValueFactory(new PropertyValueFactory<>("th"));
		
		TableColumn<Member, String> lvClm = new TableColumn<>("LV");
		lvClm.setMinWidth(50);
		lvClm.setCellValueFactory(new PropertyValueFactory<>("lv"));
		
		TableColumn<Member, String> prClm = new TableColumn<>("Pr");
		prClm.setMinWidth(50);
		prClm.setCellValueFactory(new PropertyValueFactory<>("pr"));
