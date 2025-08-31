
package Classpackage;


public class ADDDEP {
    public String Dep;
    
    public ADDDEP(String Dep) {
        this.Dep = Dep;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String Dep) {
        this.Dep = Dep;
    }
  Filesystem fileSystem= new Filesystem("Dep.txt");

  public boolean addDep(){
       if(!fileSystem.createANewFile())
        {
            String record= "New Department:" + Dep+"\n";
            System.err.println(Dep);
            
           
            return fileSystem.writeDataToFile(record);
        }
        return false; 
    }
}
