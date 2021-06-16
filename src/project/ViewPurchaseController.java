
package project;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class ViewPurchaseController implements Initializable {

    private AnchorPane salesViewPane;
    @FXML
    private Button close;
    @FXML
    private Button save;
    @FXML
    private Button edit;

   private Connection con=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private TableView<purchasetablist> detail;
        private ObservableList<purchasetablist> info;
    @FXML
    private AnchorPane purchaseViewPane;
    @FXML
    private TableColumn<?, ?> pinvoicecol;
    @FXML
    private TableColumn<?, ?> ppartynamecol;
    @FXML
    private TableColumn<?, ?> pdatecol;
    @FXML
    private TableColumn<?, ?> pchalancol;
    @FXML
    private TableColumn<?, ?> plocationcol;
    @FXML
    private TableColumn<?, ?> pamountcol;
    @FXML
    private TableColumn<?, ?> pbillamountcol;

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
            String select="select * from saletable where mode='Debit'";
            pst = con.prepareStatement(select);
            
                rs = pst.executeQuery();
 //companyname,subgroup,ownername,address,partytype,statename,hsncode,email,taxcode
                while (rs.next()) {
                    info.add(new purchasetablist(rs.getString("invoice"), rs.getString("partyname"), rs.getString("date1"), rs.getString("chalan"), rs.getString("location"), rs.getString("gross"), rs.getString("billamount")));
                }
            
            
            detail.setItems(info);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setValueData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
       pinvoicecol.setCellValueFactory(new PropertyValueFactory<>("invoice"));
        ppartynamecol.setCellValueFactory(new PropertyValueFactory<>("partyname"));
        pdatecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        pchalancol.setCellValueFactory(new PropertyValueFactory<>("chalan"));
        plocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        pamountcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        pbillamountcol.setCellValueFactory(new PropertyValueFactory<>("billamount"));
    }


    private void onAction(ActionEvent event) {
        
        if(event.getSource()==close)   
        {
            //System.exit(0);
            salesViewPane.setVisible(false);
            Project.flag=1;
        }
        if(event.getSource()==save)   
        {
           

        }
        if(event.getSource()==edit)   
        {
           

        }
        
    }

    @FXML
    private void buttonOnAction(ActionEvent event) {
    }

    
}