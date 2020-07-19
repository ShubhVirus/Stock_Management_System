package login;


import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shubham
 */
class User {
    private int Serial_No;
    private String Component_id, Lab_No, PC_No;
    private Date Date_Of_Installation, Date_Of_Replacement;
    
    public User(int Serial_No, String Component_id, String Lab_No, String PC_No, Date Date_Of_Installation, Date Date_Of_Replacement)
    {
        
        this.Serial_No=Serial_No;
        this.Component_id=Component_id;
        this.Lab_No=Lab_No;
        this.PC_No=PC_No;
        this.Date_Of_Installation=Date_Of_Installation;
        this.Date_Of_Replacement=Date_Of_Replacement;
        
    }
    public String getComponent_id(){
        return Component_id;
    }
    public int getSerial_No(){
        return Serial_No;
    }
    public String getLab_No(){
        return Lab_No;
    }
    public String getPC_No(){
        return PC_No;
    }
    public Date getDate_Of_Installation(){
        return Date_Of_Installation;
    }
    public Date getDate_Of_Replacement(){
        return Date_Of_Replacement;
    }

    
}
