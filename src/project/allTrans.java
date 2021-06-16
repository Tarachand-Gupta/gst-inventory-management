
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class allTrans implements Initializable {

  

   private Connection con=null;
    private PreparedStatement pst,pst1;
    private ResultSet rs,rs1;
    
        private ObservableList<transtablist> info;

    @FXML
    private AnchorPane transpane;
    @FXML
    private TableView<transtablist> transTable;
    @FXML
    private TableColumn<?, ?> transInvoice;
    @FXML
    private TableColumn<?, ?> transCompname;
    @FXML
    private TableColumn<?, ?> transSalePurchsase;
    @FXML
    private TableColumn<?, ?> transTax;
    @FXML
    private TableColumn<?, ?> transDate;
    @FXML
    private TableColumn<?, ?> transChalan;
    @FXML
    private TableColumn<?, ?> transLocation;
    @FXML
    private TableColumn<?, ?> transAmount;
    @FXML
    private TableColumn<?, ?> transBillAmount;
    @FXML
    private Button transSave;
    @FXML
    private Button transCancel;
    private int flag;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       con= dataCon.datacon();
       
               info = FXCollections.observableArrayList();

       
       loadData();
       setValueData();
       
        // TODO
    }    
     private void loadData() {
        try {
            String select="select * from saletable";
            pst = con.prepareStatement(select);
            
                rs = pst.executeQuery();
 //companyname,subgroup,ownername,address,partytype,statename,hsncode,email,taxcode
                while (rs.next()) {
                    info.add(new transtablist(rs.getString("invoice"), rs.getString("partyname"), rs.getString("mode"),rs.getString("tax"),rs.getString("date1"), rs.getString("chalan"), rs.getString("location"), rs.getString("gross"), rs.getString("billamount")));
                }
            
            
            transTable.setItems(info);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setValueData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
       transInvoice.setCellValueFactory(new PropertyValueFactory<>("invoice"));
        transCompname.setCellValueFactory(new PropertyValueFactory<>("partyname"));
        transSalePurchsase.setCellValueFactory(new PropertyValueFactory<>("mode"));
        transTax.setCellValueFactory(new PropertyValueFactory<>("tax"));
        transDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        transChalan.setCellValueFactory(new PropertyValueFactory<>("chalan"));
        transLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        transAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transBillAmount.setCellValueFactory(new PropertyValueFactory<>("billamount"));
    }


   
        
    

    @FXML
    private void onTransSave(ActionEvent event) throws FileNotFoundException, IOException {
        
       try {
           String query="select * from saletable";
           pst1=con.prepareStatement(query);
           rs1=pst1.executeQuery();
           System.out.println("shailesh1");
           XSSFWorkbook wb=new XSSFWorkbook();
           XSSFSheet sheet = wb.createSheet("TransactionDetails");
           XSSFRow header=sheet.createRow(0);
           header.createCell(0).setCellValue("partyname");
           header.createCell(1).setCellValue("invoice");
           header.createCell(2).setCellValue("chalan");
           header.createCell(4).setCellValue("ordemo");
           header.createCell(5).setCellValue("lmno");
           header.createCell(6).setCellValue("vehical");
           header.createCell(7).setCellValue("date1");
           header.createCell(8).setCellValue("mode");
           header.createCell(9).setCellValue("term");
           header.createCell(10).setCellValue("waybill");
           header.createCell(11).setCellValue("brocker");
           header.createCell(12).setCellValue("transport");
           header.createCell(13).setCellValue("location");
           header.createCell(14).setCellValue("comment");
           header.createCell(15).setCellValue("gross");
           header.createCell(16).setCellValue("discount");
           header.createCell(17).setCellValue("additional");
           header.createCell(18).setCellValue("tax");
           header.createCell(19).setCellValue("taxamount");
           header.createCell(20).setCellValue("other");
           header.createCell(21).setCellValue("billamount");
           System.out.println("shailesh");
           int index=1;
           while(rs1.next()){
           XSSFRow row=sheet.createRow(index);
           row.createCell(0).setCellValue(rs.getString("partyname"));
           row.createCell(1).setCellValue(rs.getString("invoice"));
           row.createCell(2).setCellValue(rs.getString("chalan"));
           row.createCell(3).setCellValue(rs.getString("ordemo"));
           row.createCell(4).setCellValue(rs.getString("lmno"));
           row.createCell(5).setCellValue(rs.getString("vehical"));
           row.createCell(6).setCellValue(rs.getString("date1"));
           row.createCell(7).setCellValue(rs.getString("mode"));
           row.createCell(8).setCellValue(rs.getString("term"));
           row.createCell(9).setCellValue(rs.getString("waybill"));
           row.createCell(10).setCellValue(rs.getString("brocker"));
           row.createCell(11).setCellValue(rs.getString("transport"));
           row.createCell(12).setCellValue(rs.getString("location"));
           row.createCell(13).setCellValue(rs.getString("comment"));
           row.createCell(14).setCellValue(rs.getString("gross"));
           row.createCell(15).setCellValue(rs.getString("discount"));
           row.createCell(16).setCellValue(rs.getString("additional"));
           row.createCell(17).setCellValue(rs.getString("tax"));
           row.createCell(18).setCellValue(rs.getString("taxamount"));
           row.createCell(19).setCellValue(rs.getString("other"));
           row.createCell(20).setCellValue(rs.getString("billamount"));

           }
           
           
            FileOutputStream fileOut=new FileOutputStream("TransactionDetails.xlsx");
            wb.write(fileOut);
            fileOut.close();
               
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Exported");
           alert.setContentText("Transaction Details are Exported in Excel");
           alert.showAndWait();
                        
                pst1.close();
                rs1.close();
       } catch (SQLException ex) {
           Logger.getLogger(allTrans.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @FXML
    private void onTransCancel(ActionEvent event) {
        transpane.setVisible(false);
        flag=1;
    }

    
}