import java.io.Serializable;

// Todo class to give "title" and "subject" structure to an file.
public class Todo implements Serializable {

    // title to store the one-word of the subject
    // title is same as the file name <file_name>.txt
    String title = "";
    // subject to store the subject
    String subject = "";
    // Constructor to initialize the title and subject variable.
    public Todo(String title, String subject){
        this.title = title;
        this.subject = subject;
    }
}
