package model;

import dao.CategoriaDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class Categoria {
    public int id;;
    public String nome;
    
    
    public Categoria(){
        this.id=0;
        this.nome="Sem Nome";
    }
    
    public Categoria(String nome){
        this.id=0;
        this.nome= nome;
    }
    
    public Categoria(int id, String nome){
        this.id= id;
        this.nome= nome;
    }
    
    public static void listarCategorias( List<Categoria> categorias){
        String texto = "Categorias Cadastradas: ";
        if (categorias.size() ==0) {
            texto += "\nNenhuma categoria cadastrada!";
        }
        for (Categoria cat: categorias){
            texto += "\n" + cat.id + " - " + cat.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
    
    public static void cadastrarCategoria(){
        
        String nome = JOptionPane.showInputDialog("Digite o nome da categoria");
        if( !nome.isEmpty() ) CategoriaDAO.cadastrar(nome);
    }

    public static void excluirCategoria(){
        List<Categoria> categorias = CategoriaDAO.getCategorias();
        String texto = "Categorias Cadastradas: ";
        for (Categoria categoria: categorias){
            texto += "\n" + categoria.id + " - " + categoria.nome;
        }
        
        texto += "\n Digite o ID da cidade que deseja excluir";
        String idDigitado = JOptionPane.showInputDialog(texto);
        if ( idDigitado.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Digite um ID válido");
        }else{
            int idCategoria = Integer.valueOf(idDigitado);
            CategoriaDAO.excluir(idCategoria);
        }
    }

}
