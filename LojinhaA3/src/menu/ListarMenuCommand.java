package menu;

import dao.CategoriaDAO;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Produto;

public class ListarMenuCommand extends MenuCommand {

    public ListarMenuCommand(MenuHandler menu) {
        super(menu);
    }
    public void execute() {
        super.execute();
        
        switch(opcao) {
            case 1: cidades = CidadeDAO.getCidades();
                    Cidade.listarCidades(cidades);
                    break;
            case 2: clientes = ClienteDAO.getClientes();
                    Cliente.listarClientes(clientes);
                    break;
            case 3: categorias = CategoriaDAO.getCategorias();
                    Categoria.listarCategorias(categorias);
                    break;
            case 4: produtos = ProdutoDAO.getProduto();
                    Produto.listarProdutos(produtos);
                    break;
            case 0: menu.select(opcao=-1);
                break;
        }
        
        menu.select(opcao=2);
    }
    public String mostrarTexto(){
        String texto = """
                       -----=Listar=-----
                       
                        1 - Cidades
                        2 - Clientes
                        3 - Categorias
                        4 - Produtos
                        0 - Voltar
                        
                       Digite a opção desejada: """;
        return texto;
    }

}
