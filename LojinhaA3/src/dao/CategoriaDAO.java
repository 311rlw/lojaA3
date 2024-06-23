package dao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

public class CategoriaDAO {
    public static void cadastrar(String nome){
        String sql = "INSERT INTO categoria (nome) VALUES ( ? )";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1,nome);
            ps.execute();
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static void editar(Categoria categoria){
        String sql = "UPDATE categoria SET nome = ? WHERE id = ? ";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1,categoria.nome);
            ps.setInt(2, categoria.id);
            ps.execute();
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static void excluir(int  idCategoria){
        String sql = "DELETE FROM categoria WHERE id = ? ";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            ps.execute();
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
    }
    
    public static List<Categoria> getCategorias(){
        List<Categoria> lista = new ArrayList<Categoria>();
        
        String sql = "SELECT id, nome FROM categoria ORDER BY nome";
        PreparedStatement ps = null;
        
        try {
            Connection conn= Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery(sql);
            
            if(rs != null){
            while (rs.next() ) {                
                Categoria cat = new Categoria();
                cat.id = rs.getInt(1);
                cat.nome = rs.getString(2);
                lista.add(cat);
                }
            }
//            Conexao.fecharConn(conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString() );
        }
        
        return lista;
    }
}
