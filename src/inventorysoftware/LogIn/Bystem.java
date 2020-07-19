/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorysoftware.LogIn;

import login.*;
import java.sql.Date;

/**
 *
 * @author Nilesh Naik
 */
class Bystem {
    private int Bills_id;//int
    private String Shop_Name, Category, Quantity,Total_Amount,Remark;
    private Date Date_Of_Given, Date_Of_Received;
    
    public Bystem(int Bills_id, String Shop_Name, String Quantity, String Category, String Total_Amount, Date Date_Of_Given,Date Date_Of_Received, String Remark)
    {
        
        this.Bills_id=Bills_id;
        this.Shop_Name=Shop_Name;
        this.Quantity=Quantity;
        this.Category=Category;
        this.Total_Amount=Total_Amount;
        this.Date_Of_Given=Date_Of_Given;
        this.Date_Of_Received=Date_Of_Received;
        this.Remark=Remark;
        
    }
    public int getBills_id(){
        return Bills_id;//int
    }
    public String getShop_Name(){
        return Shop_Name;
    }
    public String getQuantity(){
        return Quantity;
    }
    public String getCategory(){
        return Category;
    }
    public String getTotal_Amount(){
        return Total_Amount;
    }
    public Date getDate_Of_Given(){
        return Date_Of_Given;
    }
    public Date getDate_Of_Received(){
        return Date_Of_Received;
    }
    public String getRemark(){
        return Remark;
    }

    
}
