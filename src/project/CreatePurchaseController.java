/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static project.Project.zero;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class CreatePurchaseController implements Initializable {

    private final ObservableList<productList> obl = FXCollections.observableArrayList();
    @FXML
    private ComboBox<?> spartyname;
    @FXML
    private TextField sinvoiceno;
    @FXML
    private TextField schalanno;
    @FXML
    private TextField sorderno;
    @FXML
    private TextField slmno;
    @FXML
    private TextField svehicalno;
    @FXML
    private DatePicker sdate1;
    @FXML
    private DatePicker sdate3;
    @FXML
    private DatePicker sdate4;
    @FXML
    private DatePicker sdate2;
    @FXML
    private TextField smode;
    @FXML
    private Button spartynameadd;
    @FXML
    private TextField sterm;
    @FXML
    private TextField swaybill;
    @FXML
    private TextField sbroker;
    @FXML
    private TextField stransport;
    @FXML
    private TextField slocation;

    @FXML
    private TextField sgrossamount;
    int  id;
    @FXML
    private TextField sdiscount;
    @FXML
    private TextField spkgandothers;
    @FXML
    private TextField ssgst;
    @FXML
    private TextField scgst;
    @FXML
    private TextField sigst;
    @FXML
    private ComboBox<?> staxcode;
    @FXML
    private TextField staxamount;
    @FXML
    private TextField sothercharges;
    @FXML
    private Label sdiscountlabel;
    @FXML
    private Label spkglabel;
    @FXML
    private Label staxamountlabel;
    @FXML
    private Label sotherchargeslabel;
    @FXML
    private TextField sbillamount;
    @FXML
    private Button ssave;
    @FXML
    private Button sclose;
    @FXML
    private Button sprint;
    private final ObservableList gst = FXCollections.observableArrayList("IGST 12% ", "IGST & SGST 12%");
    private final ObservableList partyname = FXCollections.observableArrayList();// = FXCollections.observableArrayList("Jethalal books ","Ujjwal book Depot" ,"Socity book Center");
    SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy HH:mm:ss");   

    private Connection con = null;

    private PreparedStatement pst = null;
    @FXML
    private TextField scomment;
    String str,str1,str2,str3;
    private ResultSet rs,rs1,rs2,rs3,rs4;
    String abc;
     private PreparedStatement ps,ps1,ps2,ps3,ps4;
    @FXML
    private AnchorPane createSalesPane;
    @FXML
    private TextField selpro;
    @FXML
    private Button addpro;
    private TableColumn<productList, String> Type;
    @FXML
    private TableView<productList> pTable;
    @FXML
    private TableColumn<?, ?> code;
    @FXML
    private TableColumn<?, ?> itemName;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TextField quant;
    @FXML
    private TextField per;
    @FXML
    private TextField rate;
    @FXML
    private TableColumn<?, ?> Quantitycolumn;
    @FXML
    private TableColumn<?, ?> percolumn;
    @FXML
    private TableColumn<?, ?> Ratecolumn;
    @FXML
    private TableColumn<?, ?> Amountcolumn;

    int totalGross=0;
    int discount=0,pkg_Other=0,otherCharge=0,tax=0,total_amt=0;
    @FXML
    private Button scalculate;
    @FXML
    public void init_1() throws SQLException {
        staxcode.setItems(gst);
        staxcode.setPromptText("select");
        spartyname.setItems(partyname);
        spartyname.setPromptText("Select Party");
        str = "select * from comptable where partytype='Debit'";
        ps = con.prepareStatement(str);
        rs = ps.executeQuery();
        
        while (rs.next()) {
            partyname.add(rs.getString("companyname"));
        }
        String party = (String) spartyname.getValue();
        str1 = "select * from comptable where companyname=?";
        ps1 = con.prepareStatement(str1);
        ps1.setString(1, party);
        rs1 = ps1.executeQuery();
        if (rs1.next()) {
            System.out.println("shailesh");
            smode.setText(rs1.getString("partytype"));
            //smode.setText("Credit");
            slocation.setText(rs1.getString("statename"));
            System.out.println("shailesh");
            staxcode.setPromptText(rs1.getString("taxcode"));
            
        }
        auto_Gen1();
    }
    
    public void auto_Gen1() throws SQLException{
        sterm.setText("0");
        swaybill.setText("0");
        sbroker.setText("0");
        stransport.setText("0");
        slmno.setText("0");
        svehicalno.setText("0");
        str2="SELECT TOP 1 * FROM saletable ORDER BY invoice desc";
        ps2=con.prepareStatement(str2);
        rs2=ps2.executeQuery();
        if(rs2.next()){
        String ino=Integer.toString(Integer.parseInt(rs2.getString("invoice"))+1);
        
        sinvoiceno.setText(ino);
        schalanno.setText(ino);
        sorderno.setText(ino);
//        sdate1.setPromptText(today);
//        sdate2.setPromptText(today);
//        sdate3.setPromptText(today);
//        sdate4.setPromptText(today);
        sdate1.setValue(LocalDate.now());
        sdate2.setValue(LocalDate.now());
        sdate3.setValue(LocalDate.now());
        sdate4.setValue(LocalDate.now());
        
        //Date.valueOf(today));
        //sdate1.setValue(LOCAL_DATE("2016-05-01"));
      //  sdate1.setValue(LocalDate.parse(today, formatter));  
      //  LocalDate.parse(dateString, formatter);
        }
        

        
        
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = dataCon.datacon();
        
            Date date=new Date(2018-11-23);
            System.out.println(df.format(date));
            date.toLocalDate();
            System.out.println(df.format(date));
        try {
            init_1();
           // auto_Gen1();
            // InputMethodRequests inputMethodRequests = staxcode.getInputMethodRequests();
        } catch (SQLException ex) {
            Logger.getLogger(CreateSalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void buttonaction(ActionEvent event) throws IOException {

        if (event.getSource() == spartynameadd) {
            // System.exit(0);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("addCompany.fxml"));
            // Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            Stage stage = new Stage();

            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Add Company");
            stage.show();

        }
        //   if(event.getSource()==staxcodeadd){
        //System.exit(0);
        //    }
        //   if(event.getSource()==snew){
        //System.exit(0);
        //  }

        if (event.getSource() == sclose) {
            // System.exit(0);
            createSalesPane.setVisible(false);
            Project.flag=1;
        }

    }

    //@FXML
    /**
     *
     * @param event
     */
    @FXML
    public void saveaction(ActionEvent event) {
        
         
       
        String sql = "INSERT INTO saletable ([partyname],[invoice],[chalan],[orderno],[lmno],[vehical],[date1],[date2],[date3],[date4],[mode],[term],[waybill],[brocker],[transport],[location],[comment],[gross],[discount],[additional],[tax],[taxamount],[other],[billamount]) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String s1 = (String) spartyname.getValue();
        String s2 = sinvoiceno.getText();
        String s3 = schalanno.getText();
        String s4 = sorderno.getText();
        String s5 = slmno.getText();
        String s6 = svehicalno.getText();
        // int d1=date.getDate();
        // String sysDate= ;
        String s7=   sdate1.getValue().toString()  ;
        String s8=   sdate2.getValue().toString()  ;
        String s9=   sdate3.getValue().toString()  ;
        String s10=  sdate4.getValue().toString()  ;
        String s11 = smode.getText();
        String s12 = sterm.getText();
        String s13 = swaybill.getText();
        String s14 = sbroker.getText();
        String s15 = stransport.getText();
        String s16 = slocation.getText();
        String s17 = scomment.getText();
        float s18 = Float.parseFloat(sgrossamount.getText());
        float s19 = Float.parseFloat(sdiscount.getText());
        float s20 = Float.parseFloat(spkgandothers.getText());
        String s21 = (String) staxcode.getValue();
        float s22 = Float.parseFloat(staxamount.getText());
        float s23 = Float.parseFloat(sothercharges.getText());
        float s24 = Float.parseFloat(sbillamount.getText());
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, s1);
            pst.setString(2, s2);
            pst.setString(3, s3);
            pst.setString(4, s4);
            pst.setString(5, s5);
            pst.setString(6, s6);
            pst.setString(7, s7);
            pst.setString(8, s8);
            pst.setString(9, s9);
            pst.setString(10, s10);
            pst.setString(11, s11);
            pst.setString(12, s12);
            pst.setString(13, s13);
            pst.setString(14, s14);
            pst.setString(15, s15);
            pst.setString(16, s16);
            pst.setString(17, s17);
            pst.setFloat(18, s18);
            pst.setFloat(19, s19);
            pst.setFloat(20, s20);
            pst.setString(21, s21);
            pst.setFloat(22, s22);
            pst.setFloat(23, s23);
            pst.setFloat(24, s24);
            
            pst.executeUpdate();
            
            Project.status.setText("Data added to database !");
            System.out.println("data added !!");
//
        } catch (SQLException ex) {
            Logger.getLogger(CreateSalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
  

    @FXML
    private void onProductAdd(ActionEvent event) throws SQLException {
        
        loadData();
         setProductData();
          
            staxamount.setText(String.valueOf((Integer.parseInt(sgrossamount.getText())*12)/100));
            staxamountlabel.setText("+ "+staxamount.getText());
            sdiscount.setText("0");
            spkgandothers.setText("0");
            sothercharges.setText("0");
            
    }
     private void loadData(){
        try {
            ps3=con.prepareStatement("select * from productsale ORDER BY id desc");
        rs4=ps3.executeQuery();
        if(rs4.next()){
             id=Integer.parseInt(rs4.getString("id"))+1;
        }
            int tamount=(Integer.parseInt(rate.getText())/Integer.parseInt(per.getText())*Integer.parseInt(quant.getText()));
            ps2=con.prepareStatement("insert into productsale(code,quantity,per,rate,amount,id) values (?,?,?,?,?,?)");
            ps2.setString(1,selpro.getText());
            ps2.setString(2, quant.getText());
            ps2.setString(3,per.getText());
            ps2.setString(4,rate.getText());
            ps2.setString(5,String.valueOf(tamount));
            System.out.println(id);
            ps2.setInt(6,id);
            ps2.executeUpdate();
            ps3=con.prepareStatement("select * from productsale where id="+(id)+"");
               // ps3.setString(1,selpro.getText());
                rs3=ps3.executeQuery();
                System.out.print("chu1");
             
                pst=con.prepareStatement("select * from producttable where pcode="+selpro.getText()+"");
                //pst.setString(1, selpro.getText().toString());
                rs=pst.executeQuery();
                while(rs.next()&&rs3.next()){
                    System.out.println(rs.getString("pname"));
                    System.out.println(rs3.getString("amount"));
                     obl.add(new productList(rs.getString("pname"), rs.getString("pcode"), rs.getString("ptype"),rs3.getString("quantity"),rs3.getString("per"),rs3.getString("rate"),rs3.getString("amount")));  
                }
                
//                if(rs.next()){
//                   
//                }
                
            
            
            String calc="select * from ";

            pTable.setItems(obl);
            
            
            String sql1="select * from productsale where id="+(id)+"";
            ps4=con.prepareStatement(sql1);
            rs4=ps4.executeQuery();
            while(rs4.next()){
                totalGross+=Integer.parseInt(rs4.getString("amount"));
                sgrossamount.setText(String.valueOf(totalGross));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateSalesController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
     }
       private void setProductData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        code.setCellValueFactory(new PropertyValueFactory<>("pcode"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("pname"));
        type.setCellValueFactory(new PropertyValueFactory<>("ptype"));
        Quantitycolumn.setCellValueFactory(new PropertyValueFactory<>("pquantity"));
        percolumn.setCellValueFactory(new PropertyValueFactory<>("pper"));
        Ratecolumn.setCellValueFactory(new PropertyValueFactory<>("prate"));
        Amountcolumn.setCellValueFactory(new PropertyValueFactory<>("pamount"));
       }
//        while (rs.next()) {
//            partyname.add(rs.getString("companyname"));
//        }
//        String party = (String) spartyname.getValue();
//        str1 = "select * from comptable where companyname=?";
//        ps1 = con.prepareStatement(str1);
//        ps1.setString(1, party);
//        rs1 = ps1.executeQuery();
//        if (rs1.next()) {
//            smode.setText(rs1.getString("partytype"));
//            slocation.setText(rs1.getString("statename"));
//            staxcode.setPromptText(rs1.getString("taxcode"));
//            
//        }

    @FXML
    private void calc_action(ActionEvent event) {
        sdiscountlabel.setText("- "+sdiscount.getText());
            spkglabel.setText("+ "+spkgandothers.getText());
            sotherchargeslabel.setText("- "+sothercharges.getText());
                        sbillamount.setText(String.valueOf(Integer.parseInt(spkgandothers.getText())-Integer.parseInt(sdiscount.getText())+Integer.parseInt(staxamount.getText())-Integer.parseInt(sothercharges.getText())+Integer.parseInt(sgrossamount.getText())));
   
    }

    @FXML
    private void onPrint(ActionEvent event) {
        
        
    }
        
    
  /*  public void getDataForUpdate(int invoice){
         try {
             System.out.println("select * from saletable where invoice="+invoice+"");
             PreparedStatement ps10;
            ps10=con.prepareStatement("select * from saletable where invoice="+invoice+"");
            System.out.println("select * from saletable where invoice="+invoice+"");
             
            rs4=ps10.executeQuery();
            if(rs4.next()){
                System.out.println("select * from saletable where invoice="+invoice+"");
             
             sinvoiceno.setText(rs4.getString("invoice"));
             schalanno.setText(rs4.getString("chalan"));
             sorderno.setText(rs4.getString("ordermo"));
             slmno.setText(rs4.getString("lmno"));
             svehicalno.setText(rs4.getString("vehical"));
            sdate1.setPromptText(rs4.getString("date1"));
            sdate2.setPromptText(rs4.getString("date2"));
            sdate3.setPromptText(rs4.getString("date3"));
            sdate4.setPromptText(rs4.getString("date4"));
            smode.setText(rs4.getString("mode"));
            swaybill.setText(rs4.getString("waybill"));
            sbroker.setText(rs4.getString("brocker"));
            stransport.setText(rs4.getString("transport"));
            slocation.setText(rs4.getString("location"));
            sgrossamount.setText(rs4.getString("gross"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateSalesController.class.getName()).log(Level.SEVERE, null, ex);
            
        }*/
        
    }
       
       
       


