package menu;

import dao.CategoriaDAO;
import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Produto;

public class ExcluirMenuCommand extends MenuCommand {

    public ExcluirMenuCommand(MenuHandler menu) {
        super(menu);
    }
public void execute() {
        super.execute();
        
        switch(opcao) {
            case 1: Cidade.excluirCidade();
                break;
            case 2: Cliente.excluirCliente();
                break;
            case 3: Categoria.excluirCategoria();
                break;
            case 4: Produto.excluirProdutos();
                break;
            case 0: menu.select(opcao=-1);
                break;
        }
        
        menu.select(opcao=3);
    }
    public String mostrarTexto(){
        String texto = """
                       -----=Excluir=-----
                       
                        1 - Cidades
                        2 - Clientes
                        3 - Categorias
                        4 - Produtos
                        0 - Voltar
                        
                       Digite a opção desejada: """;
        return texto;
    }
}
