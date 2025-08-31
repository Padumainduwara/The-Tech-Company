
package Classpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Employee {
     private String EmpEPF;
    private String EmpName;
    private int EmpAge;
    private String EmpAddress;
    private String Dep;
    private String Desig;
    
    
    Filesystem fileSystem= new Filesystem("Emp.txt");

    public Employee() {
    }

    public Employee(String EmpEPF, String EmpName, int EmpAge, String EmpAddress, String Dep, String Desig) {
        this.EmpEPF = EmpEPF;
        this.EmpName = EmpName;
        this.EmpAge = EmpAge;
        this.EmpAddress = EmpAddress;
        this.Dep = Dep;
        this.Desig = Desig;
       
    }

    public String getEmpEPF() {
        return EmpEPF;
    }

    public void setEmpEPF(String EmpEPF) {
        this.EmpEPF = EmpEPF;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public int getEmpAge() {
        return EmpAge;
    }

    public void setEmpAge(int EmpAge) {
        this.EmpAge = EmpAge;
    }

    public String getEmpAddress() {
        return EmpAddress;
    }

    public void setEmpAddress(String EmpAddress) {
        this.EmpAddress = EmpAddress;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String Dep) {
        this.Dep = Dep;
    }

    public String getDesig() {
        return Desig;
    }

    public void setDesig(String Desig) {
        this.Desig = Desig;
    }

    public Filesystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(Filesystem fileSystem) {
        this.fileSystem = fileSystem;
    }
    
    

    
public boolean isValidDep(String department) {
    try {
        // Read valid departments from a file (e.g., Departments.txt)
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\induw\\OneDrive\\Documents\\NetBeansProjects\\The Tech Company\\The Tech Company\\Dep.txt"));
            
        String line;
        Set<String> validDepartments = new HashSet<>();

        while ((line = reader.readLine()) != null) {
            validDepartments.add(line.trim());
        }
        reader.close();

        // Check if the entered department exists in the set of valid departments
        return validDepartments.contains(department);
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
public boolean isEPFNoExists(String epfNumberToCheck) {
    try {
        BufferedReader bufferedReader = fileSystem.readFile();
        String employee;
        
        while ((employee = bufferedReader.readLine()) != null) {
            String[] words = employee.split(" ");
            
            // Check if the EPF number in the file matches the EPF number to check
            if (words.length >= 1 && words[0].equals(epfNumberToCheck)) {
                return true; // EPF number already exists
            }
        }
        
        // If the loop finishes and no matching EPF number is found, return false
        return false;
    } catch (IOException e) {
        e.printStackTrace();
        return false; // Handle the exception appropriately
    }
}

    public boolean addEmp(){
        if(!fileSystem.createANewFile())
        {
            String record= EmpEPF+" "+EmpName+" "+EmpAge+" "+EmpAddress+" "+Dep+" "+Desig+"\n";
            System.err.println(EmpEPF+" "+EmpName+" "+EmpAge+" "+EmpAddress+" "+Dep+" "+Desig);
            
            return fileSystem.writeDataToFile(record);
        }
        return false;
    }
    public boolean  searchEmp(String keyword)
    {
        boolean isFound=false;
        
        try{
            String[] words=null;
            BufferedReader bufferedReader = fileSystem.readFile();
            String employee;
            outerloop:
            while((employee = bufferedReader.readLine())!=null)
            {
                words = employee.split(" ");
                for(String word:words)
                {
                    if(word.equals(keyword))
                    {
                        isFound=true;
                        isFound = true;
                    this.setEmpEPF(words[0]);
                    this.setEmpName(words[1]);                    
                this.setDep(words[4]);
               this.setDesig(words[words.length - 1].trim());

                     
                                
                                break outerloop;
                    }
                    
                }
            }
              
               }
        catch (Exception e){
            System.err.println("Something went wrong searching Employee"+e);
        }
        return isFound;
    }
    
}
