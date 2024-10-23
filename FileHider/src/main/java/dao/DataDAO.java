package dao;

import db.MyConnection;
import model.Data;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {


    // retrieves all file records associated with a user's email from the database
    public static List<Data> getAllFiles(String email) throws SQLException {

        // same as alwyas database connection first
        Connection connection= MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "select * from data where email = ?");
        ps.setString(1, email);

       // get the result data from table
        ResultSet rs = ps.executeQuery();

        List<Data> files= new ArrayList<>();


        //SQL table access to declare id, name, path and add file in database
        while (rs.next()){
            int id= rs.getInt(1);
            String name= rs.getString(2);
            String path= rs.getString(3);
            files.add(new Data(id,name,path));
        }

        return files;
    }

    // implement hide file
    public  static  int hideFile(Data file) throws SQLException, IOException {
        Connection connection= MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "insert into data(name, path, email, bin_data) values(?,?,?,?)");
        ps.setString(1,file.getFileName());
        ps.setString(2,file.getPath());
        ps.setString(3, file.getEmail());


        //path access
        File f = new File(file.getPath());
        FileReader fr = new FileReader(f);


        // stored file in Bin_data coloumn
        ps.setCharacterStream(4, fr,f.length());


//        ps.executeUpdate(), which inserts the file metadata and binary content into the database.
        int ans = ps.executeUpdate();


        // close the filereader and delete file from user
        // for Hiding

           fr.close();
           f.delete();
           return ans;
    }



    public static void show(int id) throws SQLException, IOException{
        Connection connection= MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "select path, bin_data from data where id = ?");
        ps.setInt(1,id);

        ResultSet rs= ps.executeQuery();;

        rs.next();

        String path = rs.getString("path");
        Clob c = rs.getClob("bin_data");


        Reader r= c.getCharacterStream();
        FileWriter fw = new FileWriter(path);

        int i;

        // i= r.read() for save and get output view

        while((i = r.read()) != -1){
            fw.write((char) i);
        }

     fw.close();
        ps = connection.prepareStatement("delete from data where id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();

        System.out.println("Successfully Unhidden");
    }

}
