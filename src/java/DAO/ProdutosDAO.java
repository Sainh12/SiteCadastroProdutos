package DAO;
//========================Imports==========================
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;
import model.Produtos;

public class ProdutosDAO {

    //============================Comando SQL Insert======================
    public void cadastrar (Produtos prod) throws ClassNotFoundException,SQLException{
        Connection con = DBConnection.getConexão();
        String SQL = "insert into produtos (nome,marca,categoria,preco,quantidade,cor,peso,descricao,dataCadastro) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, prod.getNome());
        comando.setString(2, prod.getMarca());
        comando.setString(3, prod.getCategoria());
        comando.setDouble(4, prod.getPreco());
        comando.setInt(5, prod.getQuantidade());
        comando.setString(6, prod.getCor());
        comando.setDouble(7, prod.getPeso());
        comando.setString(8, prod.getDescricao());
        comando.setString(9, prod.getDataCadastro());
        comando.execute();
        con.close();
    }

    //===========================Comando SQL Update========================
    public void update (Produtos prod) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "update produtos set nome = ?, marca = ?, categoria = ?, preco = ?, quantidade = ?, cor = ?, peso = ?, descricao = ?, dataCadastro = ? where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, prod.getNome());
        comando.setString(2, prod.getMarca());
        comando.setString(3, prod.getCategoria());
        comando.setDouble(4, prod.getPreco());
        comando.setInt(5, prod.getQuantidade());
        comando.setString(6, prod.getCor());
        comando.setDouble(7, prod.getPeso());
        comando.setString(8, prod.getDescricao());
        comando.setString(9, prod.getDataCadastro());
        comando.setInt(10, prod.getId());
        comando.execute();
        con.close();
    }

    //=========================Comando SQL Exclude==========================
    public void deletar (Produtos prod) throws ClassNotFoundException, SQLException{
        Connection con = DBConnection.getConexão();
        String SQL = "delete from produtos where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, prod.getId());
        comando.execute();
        con.close();
    }

    //========================Comando SQL Selects==========================
    public List<Produtos> consultarTodos() throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "select * from produtos";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet resultSet = comando.executeQuery();
        List<Produtos> produtosList = new ArrayList<Produtos>();
        while (resultSet.next()){
            Produtos prod = new Produtos();
            prod.setId(resultSet.getInt("id"));
            prod.setNome(resultSet.getString("descricao"));
            prod.setMarca(resultSet.getString("marca"));
            prod.setCategoria(resultSet.getString("categoria"));
            prod.setPreco(resultSet.getDouble("preco"));
            prod.setQuantidade(resultSet.getInt("quantidade"));
            prod.setCor(resultSet.getString("cor"));
            prod.setPeso(resultSet.getDouble("peso"));
            prod.setDescricao(resultSet.getString("descricao"));
            prod.setDataCadastro(resultSet.getString("dataCadastro"));
            produtosList.add(prod);
        }
        return produtosList;
    }

    //-------------------------------------------------------------------
    public Produtos consultarById(Produtos prod) throws SQLException, ClassNotFoundException{
        Connection con = DBConnection.getConexão();
        String SQL = "select * from produtos where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, prod.getId());
        ResultSet resultSet = comando.executeQuery();
        Produtos p = new Produtos();
        if (resultSet.next()){
            p.setId(resultSet.getInt("id"));
            p.setNome(resultSet.getString("descricao"));
            p.setMarca(resultSet.getString("marca"));
            p.setCategoria(resultSet.getString("categoria"));
            p.setPreco(resultSet.getDouble("preco"));
            p.setQuantidade(resultSet.getInt("quantidade"));
            p.setCor(resultSet.getString("cor"));
            p.setPeso(resultSet.getDouble("peso"));
            p.setDescricao(resultSet.getString("descricao"));
            p.setDataCadastro(resultSet.getString("dataCadastro"));
        }
        return p;
    }
    

}