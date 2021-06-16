/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ViewProductController implements Initializable {

    @FXML
    private AnchorPane productDetailsPane;
    @FXML
    private Button edit;
    @FXML
    private Button save;
    @FXML
    private Button close;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> code;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> group;
    
    
    //<<<===== DB conn ====>>>
    
    
    private Connection con=null;
    private PreparedStatement pst;
    private ResultSet rs;
    @FXML
    private TableView<producttablist> detail;
    private ObservableList<producttablist> info;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        con= dataCon.datacon();
        info = FXCollections.observableArrayList();

       
       loadData();
       setValueData();
        
        
    }    
    
    private void loadData() {
        try {
            String select="select * from producttable";
            pst = con.prepareStatement(select);
            
                rs = pst.executeQuery();
 
                while (rs.next()) {
                    info.add(new producttablist(rs.getString("pname"), rs.getString("pcode"), rs.getString("ptype"), rs.getString("pgroup")));
                }
            
            
            detail.setItems(info);
        } catch (SQLException ex) {
            Logger.getLogger(ViewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void setValueData() {
//      tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        group.setCellValueFactory(new PropertyValueFactory<>("group"));
        
    }

    @FXML
    private void onEdit(ActionEvent event) {
    }

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClose(ActionEvent event) {
        productDetailsPane.setVisible(false);
        Project.flag=1;
    }
    
}
