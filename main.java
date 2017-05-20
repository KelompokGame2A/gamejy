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
		
		Text text = new Text("PERTANDINGAN");
		text.setFont(Font.font("THOMA", FontWeight.NORMAL, 20));
		grid.setHalignment(text, HPos.CENTER);
		grid.add(text, 1, 2);
		
		
		
		plhTable.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(plhTable.getValue() == "Table Member"){
				table.setVisible(true);
				table2.setVisible(false);
				}else{
				table.setVisible(false);
				table2.setVisible(true);
				}
			}
		});

		mulai.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) { 
				
				if(namaClan().size()<3){
					JOptionPane.showMessageDialog(null,"Masukkan Data Clan Minimal 3!!");
				}else if(combox.getValue() == null || combox2.getValue() == null){
					combox.setDisable(false);
					combox2.setDisable(false);
					combox.getItems().addAll(namaClan());
					combox2.getItems().addAll(namaClan());
					JOptionPane.showMessageDialog(null,"Data Clan + Member Sudah Siap");
					JOptionPane.showMessageDialog(null,"Silahkan Pilih Clan Untuk Bertanding!");
					mulai.setText("START FIGHT");
				}else{
					String Clan1 = (String) combox.getValue();
					String Clan2 = (String) combox2.getValue();
					int th1 = 0;
					int th2 = 0;
					int lv1 = 0;
					int lv2 = 0;
					int pr1 = 0;
					int pr2 = 0;
					int jmh1 = 0;
					int jmh2 = 0;
				if(Clan1 != Clan2){
						ArrayList<String> list = new ArrayList<String>();
						for(int i = 0; i < clist.size(); i++){
							if(clist.get(i).getClan() ==  Clan1){
								th1 = clist.get(i).getTh();
								lv1 = clist.get(i).getLv();
								pr1 = clist.get(i).getPr();
							}else if(clist.get(i).getClan() == Clan2){
								th2 = clist.get(i).getTh();
								lv2 = clist.get(i).getLv();
								pr2 = clist.get(i).getPr();								
							}
						}
						jmh1 = (th1*10)+(lv1*2)+(pr1);
						jmh2 = (th2*10)+(lv2*2)+(pr2);
						
						if(jmh1 > jmh2){
							JOptionPane.showMessageDialog(null,"Selamat Clan '"+Clan1+"' sebagai pemenang atas pertandingan"
															 + " antara Clan '"+Clan1+" VS '"+Clan2+"' dengan total score "+jmh1);
						}else{
							JOptionPane.showMessageDialog(null,"Selamat Clan '"+Clan2+"' sebagai pemenang atas pertandingan"
															 + " antara 'Clan "+Clan1+" VS 'Clan "+Clan2+"' dengan total score "+jmh2);
						}
						JOptionPane.showMessageDialog(null,"STATISTIK PERTANDINGAN:\n"
														 + "Clan "+Clan1+" -> TH: "+th1+" LV: "+lv1+" PR: "+pr1+" Total: "+jmh1+"\n"
														 + "Clan "+Clan2+" -> TH: "+th2+" LV: "+lv2+" PR: "+pr2+" Total: "+jmh2+"\n");
						mulai.setText("PRE-FIGHT");
						combox.getSelectionModel().select(-1);
						combox2.getSelectionModel().select(-1);
						combox.setDisable(true);
						combox2.setDisable(true);
						
					}else JOptionPane.showMessageDialog(null,"Pilih Clan Yang Berbeda Saat Bertanding");
				}
				
			}
		});
					
		
		btnData.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				int cth = 0;
				int clv = 0;
				int cpr = 0;
				
				try{			
				String clan = InputText("Masukkan Nama Clan (3 Character) :");
				
				int jmhMbr = JmhMember();
			
				for(int i=1; i<=jmhMbr; i++){
				Member mb = new Member();
					mb.setClan(clan);
				String member = InputText("Masukkan Nama Member "+i+" :");
				mb.setNamaMbr(member);
				Random rth = new Random();
				Random rlv = new Random();
				Random rpr = new Random();

				int th = rth.nextInt(10-1)+1;
				int lv = rlv.nextInt(50-1)+1;
				int pr = rpr.nextInt(100-1+1);
				
				cth += th;
				clv += lv;
				cpr += pr;
				
				mb.setTh(th);
				mb.setLv(lv);
				mb.setPr(pr);
				
				mlist.add(mb);
		        }
				
