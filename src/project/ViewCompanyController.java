/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import static java.awt.SystemColor.info;
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
public class ViewCompanyController implements Initializable {

    @FXML
    private Button edit;
    @FXML
    private Button save;
    @FXML
    private Button close;
    @FXML
    private AnchorPane companyDetailsPane;
    @FXML
    private TableColumn<?, ?> compcol;
    @FXML
    private TableColumn<?, ?> ownercol;
    @FXML
    private TableColumn<?, ?> subcol;
    @FXML
    private TableColumn<?, ?> typecol;
    @FXML
    private TableColumn<?, ?> statecol;
    @FXML
    private TableColumn<?, ?> taxcol;
    private Connection con=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private TableView<companytablist> detail;
        private ObservableList<companytablist> info;

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
            String select="select * from comptable";
            pst = con.prepareStatement(select);
            
                rs = pst.executeQuery();
 //companyname,subgroup,ownername,address,partytype,statename,hsncode,email,taxcode
                while (rs.next()) {
                    info.add(new companytablist(rs.getString("companyname"), rs.getString("ownername"), rs.getString("subgroup"), rs.getString("partytype"), rs.getString("statename"), rs.getString("taxcode")));
                }
            
            
            detail.setItems(info);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setValueData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        compcol.setCellValueFactory(new PropertyValueFactory<>("comp"));
        ownercol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        subcol.setCellValueFactory(new PropertyValueFactory<>("sub"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        statecol.setCellValueFactory(new PropertyValueFactory<>("state"));
        taxcol.setCellValueFactory(new PropertyValueFactory<>("tax"));
    }


    @FXML
    private void onAction(ActionEvent event) {
        
        if(event.getSource()==close)   
        {
            //System.exit(0);
            companyDetailsPane.setVisible(false);
            Project.flag=1;
        }
        if(event.getSource()==save)   
        {
           

        }
        if(event.getSource()==edit)   
        {
           

        }
        
    }

    
}
