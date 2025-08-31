
package Classpackage;

import java.io.*;

public class Assistant { 

     Filesystem fs = new Filesystem("Assistant.txt");
    
    private String Username;
    private String Password;
    private String fullname;

    

    public Assistant(String UserId, String Password, String fullname) {
        this.Username = UserId;
        this.Password = Password;
        this.fullname = fullname;
    }

    public Assistant() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String UserId) {
        this.Username = UserId;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getfullname() {
        return fullname;
    }

    public void setfullname(String UserId) {
        this.fullname = UserId;
    }
       
    public boolean addNewUser(){
    if(!fs.createANewFile())
    {
        String record = Username+"/"+Password+"/"+fullname+"/";
        return fs.writeDataToFile(record);
    }
    return false;
    }
    
     public boolean validateLogin() 
    {
        try {
            String[] words = null;
            BufferedReader Assistants = fs.readFile();
            String Assistant;

            while ((Assistant = Assistants.readLine()) != null) {
                words = Assistant.split("/");
                if (words[0].equals(Username) && words[1].equals(Password) && words[0].equals(fullname)) {
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
     public String viewAllAssistant() 
     {
        String Assistants, allUsers = "";
        String[] words = null;
       
        BufferedReader user = fs.readFile();
        try {
            while ((Assistants = user.readLine()) != null) {
                words = Assistants.split("/");
                
                allUsers += words[0]+"\t"+words[2]+"\n";
                
            }
        } 
        
        catch (Exception e) 
        {}
        
        
        return allUsers;
     }

    static String[] split(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void setUserId(String word) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
