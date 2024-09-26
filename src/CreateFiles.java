import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

/* CreateFiles class plays a major role in this ToDo
application project it will creates an file for every
ToDo note. Files of this ToDo application exactly works
as an Storage it prevents ToDo data without deletion
after the execution of the program. */
public class CreateFiles {

    // fileName to create file in this name.
    // value assigned by the constructor.
    private String fileName = "";
    // fn for concatenate the directory path with fileName to create file in exact location.
    public String fn = "";
    // it holds the content of notes.
    private String sub = "";
    private Todo todo;
    public CreateFiles(String fileName){
        this.fileName = fileName;
        this.fn = "src/Files/" + this.fileName + ".txt";
    }

    // File will be created by this function.
    public void createFile(){
        try {
            // dir File object created to check the directory is exit or not.
            File dir = new File("src/Files");
            // To create directory if it was not created.
            if(!dir.exists()){
                boolean b;
                System.out.println("The directory was not yet created. " +
                        "so, we are creating it please wait...");
                b = dir.mkdir();
                if(b)
                    System.out.println("Directory was created...");
            }

            // To write a serialized class data into the created file.
            File file = new File(fn);
            if (file.createNewFile() && !Objects.equals(fn, "")) {

                System.out.println("ToDo space was created...");

                FileOutputStream fout = new FileOutputStream(file);
                ObjectOutputStream oout = new ObjectOutputStream(fout);
                oout.writeObject(todo);
                oout.flush();
                oout.close();
                fout.close();
            }
            else{

                System.out.println("I think your file was not created or " +
                        "file name or sub not entered...");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // This method is for adding content into the subject
    // And also to share the title name and subject to the ToDo class through the constructor.
    public void content(String sub){
        this.sub = sub;
        this.todo = new Todo(fileName, sub);
    }
}
