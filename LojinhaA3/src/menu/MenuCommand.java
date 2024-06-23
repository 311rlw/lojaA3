package menu;

import dao.CategoriaDAO;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Pedido;
import model.Produto;

public abstract class MenuCommand {
    
    protected MenuHandler menu;
    
    protected List<Cidade> cidades;
    protected List<Cliente> clientes;
    protected List<Categoria> categorias;
    protected List<Produto> produtos;
    protected List<Pedido> pedidos;
    protected boolean isPrincipal = false;
    
    
    public MenuCommand (MenuHandler menu) {
        this.menu = menu;
        
        cidades = CidadeDAO.getCidades();
        clientes = ClienteDAO.getClientes();
        categorias = CategoriaDAO.getCategorias();
        produtos = ProdutoDAO.getProduto();
        pedidos = new ArrayList<Pedido>();
    }

    int opcao = -1;
    public void execute(){
        String opcaoDigitada = JOptionPane.showInputDialog(this.mostrarTexto());
        if (!opcaoDigitada.isEmpty()) {
            opcao= Integer.valueOf(opcaoDigitada);
        }
        
        if (this.isPrincipal) {
            menu.select(opcao);
        }
        
        
    }
    
    public abstract String mostrarTexto();
}
