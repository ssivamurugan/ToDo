import java.io.File;

// If the create ToDo task was completed "DeleteFile" class is used to delete the task
public class DeleteFile {

    public boolean delete(String file){
        String ffile = file + ".txt";
        File f = new File(ffile);
        if(f.exists())
            return f.delete();
        else{
            System.out.println("File does not exist: "+ ffile);
            return false;
        }
    }
}
