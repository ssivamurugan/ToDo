import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class TodoMain {
    static String FILE_PATH = "src/Files/";


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        char yes_no = 'n';
        char y_n;
        System.out.print("Do you want to add Todo task:(y/n) ");
        y_n = sc.next().trim().toLowerCase().charAt(0);
        sc.nextLine();

        while(y_n == 'y'){
            System.out.print("Enter Motive: ");
            String head = sc.nextLine();
            System.out.print("Enter Subject: ");
            String sub = sc.nextLine();

            CreateFiles cf = new CreateFiles(head);
            cf.content(sub);
            cf.createFile();

            DisplayFile df = new DisplayFile(FILE_PATH);
            df.display();

            System.out.print("\nDo you want to add " +
                    "one more Todo task:(y/n) ");
            y_n = sc.next().charAt(0);
            sc.nextLine();
        }

        System.out.println("Your already existing Todo notes: ");
        File f = new File(FILE_PATH);

        try{

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

        }catch(RuntimeException e){
            System.out.println("There is no ToDo notes not yet created...");
        }

        // If the create ToDo task was completed "DeleteFile" class is used to delete the task
        System.out.print("\nDo you want to delete a Todo note:(y/n) ");
        y_n = sc.next().trim().toLowerCase().charAt(0);
        sc.nextLine();
        if(y_n == 'y'){
            System.out.println("Enter the note name to delete: ");
            String name = sc.nextLine().trim();
            DeleteFile df = new DeleteFile();
            if(df.delete(name))
                System.out.println(name+".txt was deleted...");
            else
                System.out.println(name+".txt was not deleted...");

        }
        System.out.println("\nWaiting to save to Thoughts. See you later...");
    }
}
