/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class AddCompanyController implements Initializable {

            
     
    @FXML
    private RadioButton MODebit;

    
    @FXML
    private RadioButton MOCredit;

    ObservableList state = FXCollections.observableArrayList("Maharashtra", "Gujrat","Madhya Praesh","Rajsthan");
    ObservableList gst = FXCollections.observableArrayList("CGST 12% ","I&S GST 12%");
    //ObservableList subgroup = FXCollections.observableArrayList("jigneh ","tara" ,"rsiak");

    @FXML
    private ToggleGroup a;
    @FXML
    private Button cmpnysave;
    @FXML
    private Button cmpnycancel;
    @FXML
    public AnchorPane addCompanyPane;
    private Object stage;
    @FXML
    private TextField companyname;
    @FXML
    private TextArea address;
    @FXML
    private TextField subgroup;
    @FXML
    private TextField ownername;
    @FXML
    private ComboBox<?> statename;
    @FXML
    private TextField hsncode;
    @FXML
    private TextField email;
    @FXML
    private ComboBox<?> taxcode;
    
    private Connection con=null;
    
    private PreparedStatement pst =null;
//    String companyName;
//    String Address;
//    String ownerName;
//    String subGroup;
//    String stateName;
//    String hsnCode;
//    String eMail;
//    String taxCode;
//    String partyType;
//    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       con=dataCon.datacon();
        statename.setItems(state);
        taxcode.setItems(gst);
       // subgroup.setText("Jignesh");
        
    }
//        AnchorPane pane=FXMLLoader.load(getClass().getResource("addProduct.fxml"));
//                Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
//                
//                Scene scene=new Scene(pane);
//                stage.setScene(scene);
//                stage.show();

    @FXML
    public void save(ActionEvent event) throws IOException, SQLException {
     
        String sql="insert into comptable(companyname,subgroup,ownername,address,partytype,statename,hsncode,email,taxcode) values(?,?,?,?,?,?,?,?,?)";
//         companyName= companyname.getText();
//        Address=address.getText();
//        ownerName=ownername.getText();
//        subGroup=subgroup.getText();
//        stateName="maharashtra";
//        hsnCode=hsncode.getText();
//        eMail=email.getText();
//        taxCode="CGST";
//        ;
String s1=companyname.getText().toString();
String s2=subgroup.getText().toString();
String s3=ownername.getText().toString();
String s4=address.getText().toString();
String s5=MODebit.isSelected() ? "Debit":"Credit";
String s6 = (String) statename.getValue();
String s7=hsncode.getText().toString();
String s8=email.getText().toString();
String s9=(String) taxcode.getValue();
    

        
        try {
                pst = con.prepareStatement(sql);

           // pst.setString(9, taxCode);
            
            pst.setString(1, s1);
            pst.setString(2, s2);
            pst.setString(3, s3);
            pst.setString(4, s4);
            pst.setString(5, s5);
            pst.setString(6, s6);
            pst.setString(7, s7);
            pst.setString(8, s8);
            pst.setString(9, s9);
            
          //  pst.executeQuery();
            
            pst.executeUpdate();
            
                Project.status.setText("New Company added !");
                System.out.println("New Company added !");
                        
            } catch (SQLException ex) {
            Logger.getLogger(AddCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void cancel(ActionEvent event) throws InterruptedException {
      addCompanyPane.setVisible(false); 
      Project.flag=1;
      
    }

}
