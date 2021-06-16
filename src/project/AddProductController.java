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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author TARA
 */
public class AddProductController implements Initializable {

     // Alert alert=new Alert(Alert.AlertType.WARNING);

    @FXML
    private ToggleGroup measurable;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private AnchorPane addProductPane;
    @FXML
    private RadioButton unit;
    @FXML
    private RadioButton weight;
    
    private Connection con=null;
    
    private PreparedStatement pst =null;
    private String sql;
    @FXML
    private TextField pgroup;
    @FXML
    private TextField pcode;
    @FXML
    private TextField pname;
    @FXML
    private Label alertlabel;
    @FXML
    private TextField pricein;
    @FXML
    private TextField priceout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con=dataCon.datacon();
    }    

    @FXML
    private void actionPerf(ActionEvent event) throws IOException {
        if(event.getSource()==cancel){
            
            addProductPane.setVisible(false);
            Project.flag=1;
        }
         if(event.getSource()==ok){
          //  if(Project.isNumeric(pcode.getText())){
            if(!pname.getText().isEmpty())
            {
                if(Project.isAlphaNumeric(pname.getText().trim()))
                {
                    if(Project.isNumeric(pcode.getText()))
                    {
                        if(Project.isString(pgroup.getText()))
                        {
                            if(Project.isNumeric(pricein.getText()))
                            {
                                if(Project.isNumeric(priceout.getText()))
                                {
                                   try {
                                        sql="INSERT INTO [dbo].[producttable]\n" +
                                        "           ([pname]\n" +
                                        "           ,[pcode]\n" +
                                        "           ,[ptype]\n" +
                                        "           ,[pgroup]\n" +
                                        "           ,[pin]\n" +
                                        "           ,[pout])\n" +
                                            "     VALUES\n" +
                                            "           (?,?,?,?,?,?)" ;
                                        pst = con.prepareStatement(sql);

                                        String s1=pname.getText().toString();
                                        String s2=pcode.getText().toString();
                                        String s3=unit.isSelected() ? "unit":"weight";
                                        String s4=pgroup.getText().toString();
                                        String s5=pricein.getText().toString();
                                        String s6=priceout.getText().toString();

                                        pst.setString(1, s1);
                                        pst.setString(2, s2);
                                        pst.setString(3, s3);
                                        pst.setString(4, s4);
                                        pst.setString(5, s5);
                                        pst.setString(6, s6);
                                        pst.executeUpdate();

                                        Project.status.setText("New Product added !");

                                        System.out.println("New Product added !");

                                        pname.setText("");
                                        pcode.setText("");
                                        pgroup.setText("");
                                        pricein.setText("");
                                        priceout.setText("");
                                        alertlabel.setText("Product Added Succesfully !");


                                        } catch (SQLException ex) {
                                                     Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
                                            } 
                                } 
                                else
                                {
                                    alertlabel.setText("Price in should be Numeric !");
                                }//6th else
                            } 
                            else
                            {
                                alertlabel.setText("Price out should be Numeric !");
                            }//5th else
                        } 
                        else
                        {
                            alertlabel.setText("Group should be String !");
                        }//4th else
                    } 
                    else
                    {
                        alertlabel.setText("Code should be Numeric !");
                    }//3rd else
                } 
                else
                {
                    alertlabel.setText("Name should be String !");
                }//2nd else
            }
            else
            {
                 alertlabel.setText("Name can't be Empty !");
            }// 1st else
   
         
    }//Event {}
         

    }
    
}
