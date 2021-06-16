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
    public class productList
    {

        private String pname;
        private String pcode;
        private String ptype;
         private String pquantity;
        private String pper;
        private String prate;
        private String pamount;

         public productList(String pname, String pcode, String ptype, String pquantity, String pper, String prate, String pamount) {
        this.pname = pname;
        this.pcode = pcode;
        this.ptype = ptype;
        this.pquantity = pquantity;
        this.pper = pper;
        this.prate = prate;
        this.pamount = pamount;
    }
        
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPquantity() {
        return pquantity;
    }

    public void setPquantity(String pquantity) {
        this.pquantity = pquantity;
    }

    public String getPper() {
        return pper;
    }

    public void setPper(String pper) {
        this.pper = pper;
    }

    public String getPrate() {
        return prate;
    }

    public void setPrate(String prate) {
        this.prate = prate;
    }

    public String getPamount() {
        return pamount;
    }

    public void setPamount(String pamount) {
        this.pamount = pamount;
    }

   


   

    }
