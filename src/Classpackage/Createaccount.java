
package Classpackage;

import java.io.BufferedReader;

public class Createaccount {
  
    Filesystem fs = new Filesystem("Createaccount.txt");
    
    private String UserId;
    private String Password;
    private String fullname;

    

    public Createaccount (String UserId, String Password, String fullname) {
        this.UserId = UserId;
        this.Password = Password;
        this.fullname = fullname;
    }

    public Createaccount () {
    }

    public String getfullname() {
        return fullname;
    }

    public void setUfullname(String UserId) {
        this.fullname = UserId;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }
       
    public boolean addNewUser(){
    if(!fs.createANewFile())
    {
        String record = UserId+"/"+fullname+"/"+Password+"/";
        return fs.writeDataToFile(record);
    }
    return false;
    }
    
     public boolean validateLogin() {
        try {
            String[] words = null;
            BufferedReader Createaccounts = fs.readFile();
            String Createaccount;

            while ((Createaccount = Createaccounts.readLine()) != null) {
                words = Createaccount.split("/");
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
 public String viewAllCreateaccoun() 
     {
        String Createaccouns, allUsers = "";
        String[] words = null;
       
        BufferedReader user = fs.readFile();
        try {
            while ((Createaccouns = user.readLine()) != null) {
                words = Createaccouns.split("/");
                
                allUsers += words[0]+"\t"+words[2]+"\n";
                
            }
        } 
        
        catch (Exception e) 
        {}
        
        
        return allUsers;
     }

    private void setfullname(String word) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
   


}
