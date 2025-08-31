
package Classpackage;


import java.io.*;


public class Filesystem {
      private static String FILE_PATH = "C:\\Users\\induw\\OneDrive\\Documents\\NetBeansProjects\\The Tech Company\\The Tech Company\\";
    File file;
    private String fileName;

    public Filesystem(String fileName) 
    {
        this.fileName = fileName;
        createANewFile();
    }

    public boolean createANewFile() 
    {
        try 
        {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()) 
            {
                System.out.println("File Created: " + file.getName());
                return true;
            }
            
            System.out.println("File Alredy Exisit !");
            return false;
        } 
        
        catch (IOException e)
        {
            System.out.println("Something went wrowng with creating file" + e);
            return false;
        }
    }
    public boolean writeDataToFile(String record) 
    {
        try {
            file.createNewFile();
            FileWriter newWrite = new FileWriter(file, true);
            BufferedWriter newBuffer = new BufferedWriter(newWrite);

            newBuffer.write(record);
            newBuffer.newLine();
            newBuffer.close();
            newWrite.close();
            return true;
        } 
        catch (IOException e) 
        {
            System.out.println("Something went wrowng with writing file" + e);
            return false;
        }
    }
    public BufferedReader readFile() 
    {
        if (!createANewFile())
        {
            try 
            {
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);
                return buffer;
            } 
            
            catch (IOException e) 
            {
                System.out.println("Something went wrowng with reading file" + e);
            }
        }
        return null;
    }
}
