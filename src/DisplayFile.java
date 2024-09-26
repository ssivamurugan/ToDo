import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Motive of this class is to Display the created ToDo notes.
public class DisplayFile {

    // fn variable is for storing the PATH of the notes file.
    // Value assigned by the constructor.
    private String fn = "";
    public DisplayFile(String fn){
        this.fn = fn;
    }

    // display method to display the file in ToDo notes format
    public void display(){

        File f = new File(fn);
        // Getting the list of file objects in array format.
        File[] ff = f.listFiles();

        for(File file : ff){
            System.out.println("------------------------------");
            try {

                // ObjectInputStream for handling serialized object data form the file.
                ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
                // Type conversion from serialized object data to ToDo Object data.
                Todo td = (Todo) oin.readObject();
                System.out.println("Title: " + td.title + "\n" +
                        "Subject: " + td.subject);

            } catch (ClassNotFoundException | IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("------------------------------");
                System.out.println("*\n*\n*\n");
        }
    }
}
