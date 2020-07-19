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
 * @author Shubham
 */
class Rystem {
    private int Serial_No;
    private String Component_id, Category, Lab_No, PC_No,Remark;
    private Date Date_Of_Fault;
    
    public Rystem(int Serial_No, String Component_id, String Lab_No,String Category, String PC_No, Date Date_Of_Fault,String Remark)
    {
        
        this.Serial_No=Serial_No;
        this.Component_id=Component_id;
        this.Lab_No=Lab_No;
        this.Category=Category;
        this.PC_No=PC_No;
        this.Date_Of_Fault=Date_Of_Fault;
        this.Remark=Remark;
        
    }
    public int getSerial_No(){
        return Serial_No;
    }
    public String getComponent_id(){
        return Component_id;
    }
    public String getLab_No(){
        return Lab_No;
    }
    public String getCategory(){
        return Category;
    }
    public String getPC_No(){
        return PC_No;
    }
    public Date getDate_Of_Fault(){
        return Date_Of_Fault;
    }
    public String getRemark(){
        return Remark;
    }
}
