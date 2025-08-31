
package Classpackage;


public class ADDdesig {
    public String Desi;
    
    public ADDdesig(String Desi) {
        this.Desi = Desi;
    }

    public String getdesig() {
        return Desi;
    }

    public void setdesi(String Desi){
        this.Desi = Desi;
    }
  Filesystem fileSystem= new Filesystem("Desig.txt");

  public boolean ADDdesig(){
       if(!fileSystem.createANewFile())
        {
            String record= "New Designation:" +Desi+"\n";
            System.err.println(Desi);
            
           
            return fileSystem.writeDataToFile(record);
        }
        return false; 
    }
}

