/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @auther shailesh
 */
public  class Project extends Application {
//    public Stage window;
    public Scene scene,scene1;
    public static BorderPane bp;
    public static int flag=1;
    
   
      public static Label status;
    public static Node node;
  Alert alert=new Alert(Alert.AlertType.WARNING);
  
    // Display a date in day, month, year format
 public static Date date = Calendar.getInstance().getTime();
  public static  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

   static String today = formatter.format(date);
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // window=primaryStage ;
        // Creating Menu 
        // primaryStage.setResizable(false);
        // primaryStage.setFullScreen(true);
      // FXMLLoader.load(getClass().getResource("createSales.fxml"));
       Menu Mastermenu  =new Menu("_Master") ;
       Menu Salemenu  =new Menu("_Sale") ;
       Menu Purchasemenu  =new Menu("_Purchase") ;
       Menu Showmenu  =new Menu("Show _Transaction") ;
       Menu Search =new Menu("Search") ;
       
       
       //Creating menu items           
        
        MenuItem addCompany =new MenuItem("Add Company");
        MenuItem addProduct =new MenuItem("Add Product");
        MenuItem editCompany =new MenuItem("Edit Company");
        MenuItem editProduct =new MenuItem("Edit Product");  
        MenuItem exit=new MenuItem("Exit");
        
        Mastermenu.getItems().add(addCompany);
        Mastermenu.getItems().add(addProduct);
        Mastermenu.getItems().add(editCompany);
        Mastermenu.getItems().add(editProduct);
        Mastermenu.getItems().add(new SeparatorMenuItem());
        Mastermenu.getItems().add(exit);
     

    
        MenuItem newSales =new MenuItem("New Sales");
            Salemenu.getItems().add(newSales);
        MenuItem editSales =new MenuItem("Edit Sales");
            Salemenu.getItems().add(editSales);
        MenuItem viewSales =new MenuItem("View Sales");
            Salemenu.getItems().add(viewSales);
        MenuItem salesParties =new MenuItem("Sales Parties");
            Salemenu.getItems().add(salesParties);
        MenuItem generateBill =new MenuItem("Generate Bill");
            Salemenu.getItems().add(generateBill);
           
            
            
        MenuItem newPurchase =new MenuItem("New Purchase");
            Purchasemenu.getItems().add(newPurchase);
        MenuItem editPurchase =new MenuItem("Edit Purchase");
            Purchasemenu.getItems().add(editPurchase);
        MenuItem viewPurchase =new MenuItem("View Purchase");
            Purchasemenu.getItems().add(viewPurchase);
        MenuItem purchaseParties =new MenuItem("Purchase Parties");
            Purchasemenu.getItems().add(purchaseParties);
        //MenuItem generateBill =new MenuItem("Generate Bill");
            Purchasemenu.getItems().add(generateBill);
         
        MenuItem showAll =new MenuItem("All Transaction");
            Showmenu.getItems().add(showAll);        
        MenuItem daily =new MenuItem("Daily Transaction");
            Showmenu.getItems().add(daily);
        //Creating MenuBar & adding menus to it.
        MenuItem searchItem = new  MenuItem("Search Transaction");
            Search.getItems().add(searchItem);
         
        MenuBar menuBar =new MenuBar();
        menuBar.getMenus().addAll(Mastermenu,Salemenu,Purchasemenu,Showmenu,Search );
              
          bp = new BorderPane();
        bp.setTop(menuBar);
        
        //  root.setCenter();
        status =new Label();
        status.setAlignment(Pos.CENTER);

        
        
        


        
//                AnchorPane pane=FXMLLoader.load(getClass().getResource("login.fxml"));
//                scene1=new Scene(pane);
                

          scene = new Scene(bp,1280,700);
         //s1=scene;
      //  scene.getStylesheets().add("fxmain.css");
        primaryStage.setTitle("Stock Management");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//       login.setOnAction((ActionEvent e) -> {
//           
//           
//       });
        
//              Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
//                
                
//                stage.setScene(scene);
//                stage.show();
       
        //Creating menu functions
        
        addCompany.setOnAction((ActionEvent e) -> {
            try {
                bp.setCenter(FXMLLoader.load(Project.this.getClass().getResource("addCompany.fxml")));
                flag=0;
            }catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
       });    
        addProduct.setOnAction((ActionEvent e) -> {
            try {
                //System.out.println("addProduct");
                bp.setCenter(FXMLLoader.load(Project.this.getClass().getResource("addProduct.fxml")));
                flag=0;
            }catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
       });    
        
        editCompany.setOnAction((ActionEvent e) -> {
            //System.out.println("editCompany");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewCompany.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       });  
        
        editProduct.setOnAction((ActionEvent e) -> {
            //System.out.println("viewProduct");
            try {
                bp.setCenter(FXMLLoader.load(Project.this.getClass().getResource("viewProduct.fxml")));
                flag=0;
            }catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
       });  
        
        newSales.setOnAction((ActionEvent e) -> {
            //System.out.println("createSales / New Sales");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("createSales.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       });  
        
        editSales.setOnAction((ActionEvent e) -> {
            //System.out.println("editSales ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("createSalesEdit.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        viewSales.setOnAction((ActionEvent e) -> {
           // System.out.println("editSales ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewSales.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        salesParties.setOnAction((ActionEvent e) -> {
            //System.out.println("viewSalesParty ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewSalesParty.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        ///bro
        
        newPurchase.setOnAction((ActionEvent e) -> {
          //  System.out.println("createPurchase / New Purchase");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("createPurchase.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       });  
        
        editPurchase.setOnAction((ActionEvent e) -> {
           // System.out.println("editPurchase ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewPurchase.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        viewPurchase.setOnAction((ActionEvent e) -> {
            //System.out.println("editSales ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewPurchase.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        purchaseParties.setOnAction((ActionEvent e) -> {
            //System.out.println("viewPurchaseParty ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("viewPurchaseParty.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
        
        
        generateBill.setOnAction((ActionEvent e) -> {
           // System.out.println("bill ");
            
            status.setText("This Module is not Created Yet !!");
       });
      showAll.setOnAction((ActionEvent e) -> {
            //System.out.println("viewPurchaseParty ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("alltrans.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
           daily.setOnAction((ActionEvent e) -> {
            //System.out.println("viewPurchaseParty ");
           try {
               bp.setCenter(FXMLLoader.load(getClass().getResource("daily.fxml")));
               flag=0;
           } catch (IOException ex) {
               Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
           }
       }); 
           
       //    MenuItem s;
       //  s = (MenuItem)Search;
        
           searchItem.setOnAction((ActionEvent e) -> {
            try {
                bp.setCenter(FXMLLoader.load(Project.this.getClass().getResource("searchtrans.fxml")));
                flag=0;
            }catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
         });

            


        
        
        exit.setOnAction((ActionEvent e) -> {
          //  Node getBorder=bp.getCenter();
           // System.out.println(getBorder.toString());
            try{
                if(flag==1){
                    //System.out.print(bp.getCenter());
                    System.exit(0);
                }
                else{
                
                        alert.setTitle("Alert !!");
                        alert.setContentText("Close All Windows Before EXIT !!");
                        alert.showAndWait();
                }
                    
                    }catch(Exception ex){}
            
         });
        
        bp.setBottom(status);
        
    }
    
    //
    //
    //  *******  Validator FUNCTIONS  ********
    //          Regex expression
    //
    
   public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  
    }
   public static boolean isString(String str){
       
        return str.matches("[a-zA-Z ]*");
   }
   public static boolean isAlphaNumeric(String str){
    
        return str.matches("^[a-zA-Z0-9 ]*$");
    }
   public static String zero(){
       
       return "0.0";
   }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println("Today : " + today);
    }
  
    
}
