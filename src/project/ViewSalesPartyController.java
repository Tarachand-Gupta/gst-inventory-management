/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author TARA
 */
public class ViewSalesPartyController implements Initializable {

    @FXML
    private AnchorPane salesPartiesPane;
    @FXML
    private Button edit;
    @FXML
    private Button save;
    @FXML
    private Button close;
    @FXML
    private TableView<?> salespartyiestable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onEdit(ActionEvent event) {
    }

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClose(ActionEvent event) {
        
        if(event.getSource()==close){
            salesPartiesPane.setVisible(false);
        Project.flag=1;
        }
    }
    
}
