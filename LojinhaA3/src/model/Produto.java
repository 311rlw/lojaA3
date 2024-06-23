package model;

import dao.ProdutoDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class Produto {
    public int id;
    public String nome;
    public double preco, quantidade;
    public Categoria categoria;
    
    public Produto(){
        
    }
    
    public Produto(String nome ){
        this.nome = nome;
    }
    public Produto(int id, String nome, double preco, double quantidade, Categoria categoria ){
        this.nome = nome;
        this.preco= preco;
        this.id=id;
        this.quantidade=quantidade;
        this.categoria=categoria;
    }
    
    public static void listarProdutos( List<Produto> produtos){
        String texto = "Produtos Cadastrados: ";
        if (produtos.size() ==0) {
            texto += "\nNenhum produto cadastrado!";
            JOptionPane.showMessageDialog(null, texto);
        }
        for (Produto prod: produtos){
            texto +="\n" + prod.id + " - " + prod.nome +
                    "\nPreço - R$ " + prod.preco +
                    "\nQuantidade - " + prod.quantidade +
                    "\nCategoria - " + prod.categoria.nome + 
                    "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
        
    public static void cadastrarProduto(List<Categoria> categorias){
        String nome = JOptionPane.showInputDialog("Digite o nome do Produto: ");
        
        
//      PREÇO  
        String precoDigitado = JOptionPane.showInputDialog("Digite o preço: ");
        precoDigitado= precoDigitado.replace("," , ".");
        double preco = 0;
        if (!precoDigitado.isEmpty()) {
            preco = Double.valueOf(precoDigitado);
        }
        
//      QUANTIDADE
        String qtdDigitada = JOptionPane.showInputDialog("Digite a quantidade: ");
        qtdDigitada = qtdDigitada.replace(",", ".");
        double qtd = 0;
        if (!precoDigitado.isEmpty()) {
            
            qtd = Double.valueOf(qtdDigitada);
        }
        
        
        String texto = "Categorias Cadastradas: ";
        for (Categoria cat: categorias){
            texto += "\n" + cat.id + " - " + cat.nome;
        }
        
        texto += "\n Digite o id da categoria deste produto";
        
        int idCategoria = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Categoria catSelecionada = null;
        for (Categoria cat : categorias) {
            if(cat.id==idCategoria){
                catSelecionada = cat;
            }
        }
        
        Produto novoProduto = new Produto(0,nome, preco, qtd, catSelecionada);
        ProdutoDAO.cadastrar(novoProduto);
                
    }
        
    public static void excluirProdutos(){
        List<Produto> produtos = ProdutoDAO.getProduto();
        String texto = "Produtos Cadastrados: ";
        for (Produto produto: produtos){
            texto += "\n" + produto.id + " - " + produto.nome;
        }
        
        texto += "\n Digite o ID do produto que deseja excluir";
        String idDigitado = JOptionPane.showInputDialog(texto);
        if ( idDigitado.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Digite um ID válido");
        }else{
            int idProduto = Integer.valueOf(idDigitado);
            ProdutoDAO.excluir(idProduto);
        }
    }

        
}
