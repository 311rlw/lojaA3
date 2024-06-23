package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import model.Categoria;

public class ProdutoDAO {
    public static void cadastrar(Produto produto){
        String sql = "INSERT INTO produto (nome, preco, quantidade, codCategoria) VALUES ( ? , ? , ? , ?)";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1,produto.nome);
            ps.setDouble(2,produto.preco);
            ps.setDouble(3,produto.quantidade);
            ps.setInt(4,produto.categoria.id);
            ps.execute();
//          Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static void editar(Produto produto){
        String sql = "UPDATE produto SET nome = ? , preco = ? , quantidade = ? , codCategoria = ? , WHERE id = ? ";
        PreparedStatement ps = null;
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1,produto.nome);
            ps.setDouble(2,produto.preco);
            ps.setDouble(3,produto.quantidade);
            ps.setInt(4,produto.categoria.id);
            ps.setInt(5,produto.id);
            ps.execute();
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static void excluir(int idProduto){
        String sql = "DELETE FROM produto WHERE id = ? ";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            ps.execute();
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static List<Produto> getProduto(){
        List<Produto> lista = new ArrayList<Produto>();
        String sql = " SELECT p.id, p.nome, p.preco, p.quantidade, c.id, c.nome " +
                     " FROM produto p " +
                     " INNER JOIN categoria c ON c.id = p.codCategoria " +
                     " ORDER BY p.nome";
        PreparedStatement ps = null;
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
            while (rs.next() ) {                
                Categoria cat = new Categoria();
                cat.id = rs.getInt(5);
                cat.nome = rs.getString(6);
                
                Produto prod = new Produto();
                prod.id= rs.getInt(1);
                prod.nome= rs.getString(2);
                prod.preco= rs.getDouble(3);
                prod.quantidade= rs.getDouble(4);
                prod.categoria = cat;
                lista.add(prod);
                }
            }
//            Conexao.fecharConn(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
        
        return lista;
    }
}
