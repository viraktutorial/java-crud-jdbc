package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.ConnectionUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User getUser(int id) {

        try {
        	Connection connection=ConnectionUtils.getMyConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);

            if(rs.next())
            {
            	return extractUserFromResultSet(rs);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
	}

	@Override
	public List<User> getAllUsers() {
		try {
			Connection connection=ConnectionUtils.getMyConnection();
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

	        List users = new ArrayList<User>();

	        while(rs.next())
	        {
	            User user = extractUserFromResultSet(rs);
	            users.add(user);
	        }

	        return users;

	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Connection connection=ConnectionUtils.getMyConnection();
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();

	        if(rs.next())
	        {
	        	return extractUserFromResultSet(rs);
	        }

	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }
		return null;
	}

	@Override
	public boolean insertUser(User user) {
		try {
			Connection connection=ConnectionUtils.getMyConnection();
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (NULL, ?, ?, ?,?)");
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getFullname());
	        ps.setString(4, user.getEmail());
	        int i = ps.executeUpdate();

	      if(i == 1) {
	        return true;
	      }

	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	    }

	    return false;
	
	}

	@Override
	public boolean updateUser(User user) {

			
		    try {
		    	Connection connection=ConnectionUtils.getMyConnection();
		        PreparedStatement ps = connection.prepareStatement("UPDATE users SET username=?, password=?, fullname=?, email=? WHERE user_id=?");
		        ps.setString(1, user.getUsername());
		        ps.setString(2, user.getPassword());
		        ps.setString(3, user.getFullname());
		        ps.setString(4, user.getEmail());
		        int i = ps.executeUpdate();

		       if(i == 1) {
		    	  return true;
		       }

		    } catch (SQLException | ClassNotFoundException ex) {
		        ex.printStackTrace();
		    }

		    return false;
	}

	@Override
	public boolean deleteUser(int id) {

		    try {
		     	Connection connection=ConnectionUtils.getMyConnection();
		        Statement stmt = connection.createStatement();
		        int i = stmt.executeUpdate("DELETE FROM users WHERE user_id=" + id);

		      if(i == 1) {
		    return true;
		      }

		    } catch (SQLException | ClassNotFoundException ex) {
		        ex.printStackTrace();
		    }

		    return false;
	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
	    User user = new User();

	    user.setId( rs.getInt("user_id") );
        user.setUsername( rs.getString("username") );
        user.setPassword( rs.getString("password") );
        user.setFullname(rs.getString("fullname") ); 
        user.setEmail(rs.getString("email"));

	    return user;
	}
}
