package DAO;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //============================Comando SQL Insert======================
    public void cadastrar (User user) throws SQLException,ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "insert into User (nome, email, senha,Data_nascimento) values (?,?,?,?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, user.getNome());
        comando.setString(2, user.getEmail());
        comando.setString(3, user.getSenha());
        comando.setObject(4, user.getData_Nascimento_codigo());
        comando.execute();
        con.close();
    }

    //===========================Comando SQL Update========================
    public void update (User user) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "update User set nome = ?, email = ? where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, user.getNome());
        comando.setString(2, user.getEmail());
        comando.setInt(3, user.getId());
        comando.execute();
        con.close();
    }

    //=========================Comando SQL Exclude==========================
    public void deletar (User user) throws ClassNotFoundException, SQLException{
        Connection con = DBConnection.getConexão();
        String SQL = "delete from User where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, user.getId());
        comando.execute();
        con.close();
    }

    //========================Comando SQL Selects==========================
    public List<User> consultarTodos() throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "select * from User";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet resultSet = comando.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setNome(resultSet.getString("nome"));
            user.setEmail(resultSet.getString("email"));
            user.getData_Nascimento(resultSet.getObject("Data_nascimento",OffsetDateTime.class));
            userList.add(user);
        }
        con.close();
        return userList;
    }

    //-------------------------------------------------------------------
    public User consultarById(User user) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "select * from User where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, user.getId());
        ResultSet resultSet = comando.executeQuery();
        User u = new User();
        if (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setNome(resultSet.getString("nome"));
            user.setEmail(resultSet.getString("email"));
            user.getData_Nascimento(resultSet.getObject("Data_nascimento",OffsetDateTime.class));
        }
        con.close();
        return u;
    }
}
