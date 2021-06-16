/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author amit
 */
public class companytablist {
    
    public String  comp ;
    public String  owner ;
    public String  sub ;
    public String   type ;
    public String state  ;
    public String  tax ;
   // public String   ;
  //  public String   ;

    public companytablist(String comp, String owner, String sub, String type, String state, String tax) {
        this.comp = comp;
        this.owner = owner;
        this.sub = sub;
        this.type = type;
       // this.send1 = new Button("Paid");
        this.state = state;
        this.tax = tax;
       
    }
    /**
     * @return the comp
     */
    public String getComp() {
        return comp;
    }

    
    public void setName(String comp) {
        this.comp = comp;
    }
    
     public String getOwner() {
        return owner;
    }

   
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
     public String getSub() {
        return sub;
    }

    
    public void setSub(String sub) {
        this.sub = sub;
    }
    
     public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }
     public String getState() {
        return state;
    }

   
    public void setState(String state) {
        this.state = state;
    }
     
    
    
    public String getTax() {
        return tax;
    }

   
    public void setTax(String tax) {
        this.tax = tax;
    }
    
}

