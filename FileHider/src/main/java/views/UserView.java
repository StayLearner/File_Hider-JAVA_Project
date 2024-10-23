package views;

import dao.DataDAO;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {

    // constructor of email
    private String email;
    UserView(String email){
        this.email= email;
    }
    public void home(){

// Display all hidden files.
//Hide a new file.
//
//Exit the program.

    do {
        System.out.println("Welcome "+ this.email);
        System.out.println("Press 1 to Show Hidden Files");
        System.out.println("Press 2 to Hide a New File");
        System.out.println("Press 3 to Show a File");
        System.out.println("Press 0 to exit");

        Scanner sc= new Scanner(System.in);
        int ch = Integer.parseInt(sc.nextLine());


        switch(ch){


            //Show hidden files

         case 1 -> {
             try{

                 // store all files in user email => files variable
                 List<Data> files = DataDAO.getAllFiles(this.email);

//    List<Data>, where each Data object represents a file.
                 System.out.println("ID - FILE Name");

              for (Data file : files){
                  System.out.println(file.getId() + " - " + file.getFileName());
              }

             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }


         //Hide a new File
         case 2-> {
             System.out.println("Enter the file path");
             String path = sc.nextLine();
             File f = new File(path);


             //File Object Creation:
             Data file = new Data(0, f.getName(),path,this.email);

             try {
                 DataDAO.hideFile(file);
             }catch (SQLException | IOException e) {
                 e.printStackTrace();
             }
         }



          case 3 -> {
              List<Data> files = null;
              try {
                  files = DataDAO.getAllFiles(this.email);

                  System.out.println("ID - File Name");
                  for (Data file : files) {
                      System.out.println(file.getId() + " - " + file.getFileName());
                  }
                  System.out.println("Enter the id of file to unhide");

                  int id = Integer.parseInt(sc.nextLine());

                  // file valid or not
                  boolean isValidID = false;
                  for (Data file : files) {
                      if (file.getId() == id) {
                          isValidID = true;
                          break;
                      }
                  }
                  if (isValidID) {
                      DataDAO.show(id);
                  } else {
                      System.out.println("Wrong ID");
                  }

              } catch (SQLException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }

          }
              case 0 ->{
                 System.out.println(0);

          }

        }
    } while (true);
    }
}
