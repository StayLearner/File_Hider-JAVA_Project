package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean isExists(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(" select email from users");


//    executed using ps.executeQuery(), which returns a ResultSet containing all email addresses in the database.
        ResultSet rs = ps.executeQuery();


        // loop through upper result for user existence checking
        while (rs.next()) {
            String e = rs.getString(1);

            if (e.equals(email))
                return true;
        }
        return false;
    }

    public static int saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();

//            prepares an SQL query to insert a new row into the users table with a default id (assumed to be auto_increment) and placeholders for the name and email (?, ?).
        PreparedStatement ps = connection.prepareStatement("insert into users values(default, ?, ?)");

        // set values
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());

// executeUpdate() method runs the insert query and returns the number of affected rows
        return ps.executeUpdate();
    }

}


