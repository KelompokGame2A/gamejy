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
		table = new TableView<>();
		
		table.getColumns().addAll(clanClm,memberClm,thClm,lvClm,prClm);
		grid.add(table, 0, 8, 3,1);
		
		
		TableColumn<Clan, String> cnClan = new TableColumn<>("Clan");
		cnClan.setMinWidth(120);
		cnClan.setCellValueFactory(new PropertyValueFactory<>("clan"));
		
		TableColumn<Clan, String> cnJmhMbr = new TableColumn<>("Jumlah");
		cnJmhMbr.setMinWidth(120);
		cnJmhMbr.setCellValueFactory(new PropertyValueFactory<>("jmhMbr"));
		
		TableColumn<Clan, String> cnTh = new TableColumn<>("TH");
		cnTh.setMinWidth(50);
		cnTh.setCellValueFactory(new PropertyValueFactory<>("th"));
		
		TableColumn<Clan, String> cnLv = new TableColumn<>("LV");
		cnLv.setMinWidth(50);
		cnLv.setCellValueFactory(new PropertyValueFactory<>("lv"));
		
		TableColumn<Clan, String> cnPr = new TableColumn<>("Pr");
		cnPr.setMinWidth(50);
		cnPr.setCellValueFactory(new PropertyValueFactory<>("pr"));
		
		TableView<Clan> table2 = new TableView<Clan>();
		table2.getColumns().addAll(cnClan,cnJmhMbr,cnTh,cnLv,cnPr);
		grid.add(table2, 0, 8, 3,1);
		table2.setVisible(false);
		
		ComboBox<Object> plhTable = new ComboBox<>();
		
		plhTable.setPromptText("Pilih Table");
		grid.setHalignment(plhTable, HPos.RIGHT);
		plhTable.getItems().addAll("Table Member","Table Clan");
		grid.add(plhTable, 2, 7);
		
		Button btnData = new Button("Tambah CLAN + MEMBER");
		Button mulai = new Button("PRE-FIGHT");
		grid.setHalignment(mulai, HPos.CENTER);
		grid.add(btnData, 0, 7);
		grid.add(mulai, 1, 3);
		
		ComboBox<Object> combox = new ComboBox<>();
		ComboBox<Object> combox2 = new ComboBox<>();
		
		combox.setDisable(true);
		combox2.setDisable(true);
		combox.setPromptText("CLAN I");
		combox2.setPromptText("CLAN II");
		grid.add(combox, 0, 2);
		grid.setHalignment(combox2, HPos.RIGHT);
		grid.add(combox2, 2, 2);
