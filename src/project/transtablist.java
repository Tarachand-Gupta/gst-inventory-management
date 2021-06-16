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
public class transtablist {
    
    public String  invoice ;
    public String  partyname ;
    public String mode;
    public String tax;
    
    public String  date ;
    public String   chalan ;
    public String location ;
    
    public String   amount ;
    public String billamount ;
  //  public String  tax ;
   // public String   ;
  //  public String   ;

    public transtablist(String invoice, String partyname,String mode,String tax ,String date, String chalan, String location,String amount,String billamount) {
      this.invoice = invoice;
       this.partyname = partyname;
       this.mode=mode;
       this.tax=tax;
       this.date = date;
       this.chalan = chalan;
      // this.send1 = new Button("Paid");
        this.location = location;
       
        this.amount=amount;
        this.billamount=billamount;
       
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChalan() {
        return chalan;
    }

    public void setChalan(String chalan) {
        this.chalan = chalan;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBillamount() {
        return billamount;
    }

    public void setBillamount(String billamount) {
        this.billamount = billamount;
    }



 

       
}

