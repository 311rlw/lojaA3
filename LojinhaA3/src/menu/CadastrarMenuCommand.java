package menu;

import dao.CategoriaDAO;
import dao.CidadeDAO;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Produto;

public class CadastrarMenuCommand extends MenuCommand{

    public CadastrarMenuCommand(MenuHandler menu) {
        super(menu);
    }
    
    public void execute() {
        super.execute();
        
        switch(opcao) {
            case 1: Cidade.cadastrarCidade();
                break;
            case 2: cidades = CidadeDAO.getCidades();

                    if (cidades.size() == 0 ){
                        JOptionPane.showMessageDialog(null, "Necessário cadastrar cidade!");
                        Cidade.cadastrarCidade();
                        cidades = CidadeDAO.getCidades();
                        Cliente.cadastrarCliente(cidades);
                    }else{
                        Cliente.cadastrarCliente(cidades);
                    }    
                    break;
            case 3: Categoria.cadastrarCategoria();
                break;
            case 4: categorias = CategoriaDAO.getCategorias();

                    if (categorias.size() == 0 ){
                        JOptionPane.showMessageDialog(null, "Necessário cadastrar categoria!");
                        Categoria.cadastrarCategoria();
                        categorias = CategoriaDAO.getCategorias();
                        Produto.cadastrarProduto(categorias);
                        break;
                    }else{
                        Produto.cadastrarProduto(categorias);
                        break;
                    }
            case 0: menu.select(opcao=-1);
                break;
        }
        
        menu.select(opcao=1);
    }

    public String mostrarTexto(){
        String texto = """
                       -----=Cadastro=-----
                       
                        1 - Cidade
                        2 - Cliente
                        3 - Categoria
                        4 - Produto
                        0 - Voltar
                        
                       Digite a opção desejada: """;
        return texto;
    }
}
