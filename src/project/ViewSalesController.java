
package project;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class ViewSalesController implements Initializable {

    @FXML
    private AnchorPane salesViewPane;
    @FXML
    private Button close;
    @FXML
    private Button save;
    @FXML
    private Button edit;
    @FXML
    private TableColumn<?, ?> sinvoicecol;
    @FXML
    private TableColumn<?, ?> spartynamecol;
    @FXML
    private TableColumn<?, ?> sdatecol;
    @FXML
    private TableColumn<?, ?> schalancol;
    @FXML
    private TableColumn<?, ?> slocationcol;
    @FXML
    private TableColumn<?, ?> sitemcol;
    @FXML
    private TableColumn<?, ?> samountcol;
    @FXML
    private TableColumn<?, ?> sbillamountcol;
   private Connection con=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private TableView<salestablist> detail;
        private ObservableList<salestablist> info;

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
                    info.add(new salestablist(rs.getString("invoice"), rs.getString("partyname"), rs.getString("date1"), rs.getString("chalan"), rs.getString("location"), rs.getString("gross"), rs.getString("billamount")));
                }
            
            
            detail.setItems(info);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setValueData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
       sinvoicecol.setCellValueFactory(new PropertyValueFactory<>("invoice"));
        spartynamecol.setCellValueFactory(new PropertyValueFactory<>("partyname"));
        sdatecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        schalancol.setCellValueFactory(new PropertyValueFactory<>("chalan"));
        slocationcol.setCellValueFactory(new PropertyValueFactory<>("location"));
        samountcol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        sbillamountcol.setCellValueFactory(new PropertyValueFactory<>("billamount"));
    }

@FXML
    private void onAction(ActionEvent event) throws IOException {
        
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
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("createSalesEdit.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage stage = new Stage();
            stage.setTitle("Update Sales");
            stage.setScene(new Scene(root));
            stage.show();
            
            UpdateSales CreateSales = new UpdateSales();
          // int tara=Integer.parseInt(detail.getSelectionModel().getSelectedItem().getInvoice());
            //System.out.println("invoice "+tara);
          // CreateSales.getDataForUpdate(Integer.parseInt(detail.getSelectionModel().getSelectedItem().getInvoice()));
        }
        
    }

    @FXML
    private void buttonOnAction(ActionEvent event) {
    }

    
}