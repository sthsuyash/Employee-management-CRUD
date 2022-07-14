package com.employee;

import java.util.*;
import java.sql.*;

//String url = "jdbc:mysql://localhost:3306/practice"; // database name
//String uname = "root";
//String pass = "suyashstha";

public class EmployeeDAO {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "suyashstha");
        return con;
    }

    public static int save(Employee e) {
        int status = 0;
        try {
            Connection con = EmployeeDAO.getConnection();
            String query = "INSERT INTO users(id, name, password, email, country) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getPassword());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getCountry());

            status = ps.executeUpdate();

            con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Employee e) {
        int status = 0;
        try {
            Connection con = EmployeeDAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE users set name=?,password=?,email=?,country=? where id=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = EmployeeDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM users where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Employee getEmployeeById(int id) {
        Employee e = new Employee();

        try {
            Connection con = EmployeeDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<Employee>();

        try {
            Connection con = EmployeeDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                list.add(e);
            }
            con.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
