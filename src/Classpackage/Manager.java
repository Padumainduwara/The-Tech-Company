
package Classpackage;

import java.io.BufferedReader;


public class Manager {
    Filesystem fs = new Filesystem("Manager.txt");
    
    private String UserId;
    private String Password;
    private String fullname;

    public Manager(String UserId, String Password,String fullname) {
        this.UserId = UserId;
        this.Password = Password;
        this.fullname = fullname;
    }
    
    public Manager() {
    }

    public Manager(String userid, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getfullname() {
        return fullname;
    }

    public void setfullname(String UserId) {
        this.fullname = UserId;
    }
    public String getUserId() {
        return UserId;
    }
    
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
   public boolean addNewUser(){
    if(!fs.createANewFile())
    {
        String record = UserId+"/"+fullname+"/"+Password+"/";
        return fs.writeDataToFile(record);
    }
    return false;
    }
public boolean validateLogin() 
    {
        try {
            String[] words = null;
            BufferedReader Managers = fs.readFile();
            String Manager;

            while ((Manager = Managers.readLine()) != null) {
                words = Assistant.split("/");
                if (words[0].equals(UserId) && words[1].equals(Password) && words[0].equals(fullname)) {
                    this.setUserId(words[0]);
                    this.setPassword(words[1]);       
                    this.setfullname(words[0]);
                    return true;
                }
            }
            
        }
catch (Exception e) 
        {
            System.out.println("Something went wrong creating file"+e);
        }

        return false;
    }
     public String viewAllManager() 
     {
        String Assistants, allUsers = "";
        String[] words = null;
       
        BufferedReader user = fs.readFile();
        try {
            String Managers;
            while ((Managers = user.readLine()) != null) {
                words = Assistant.split("/");
                
                allUsers += words[0]+"\t"+words[2]+"\n";
                
            }
        } 
        
        catch (Exception e) 
        {}
        
        
        return allUsers;
    }
     
}

