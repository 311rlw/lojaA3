package model;

import dao.CidadeDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class Cidade {

    public static void cadastrarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int id;;
    public String nome;
    
//metodo construtor que nao recebe parametro
    
    public Cidade(){
        this.id=0;
        this.nome="Sem Nome";
    }
    
    public Cidade(String nome){
        this.id=0;
        this.nome= nome;
    }
    
    public Cidade(int id, String nome){
        this.id=id;
        this.nome= nome;
    }
    
    public static void listarCidades( List<Cidade> cidades){
        String texto = "Cidades Cadastradas: ";
        if (cidades.size() ==0) {
            texto += "\nNenhuma cidade cadastrada!";
        }
        
        for (Cidade cid: cidades){
            texto += "\n" + cid.id + " - " + cid.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public static void cadastrarCidade(){
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade");
        if( !nome.isEmpty() ) CidadeDAO.cadastrar(nome);
    }
    
    public static void excluirCidade(){
        List<Cidade> cidades = CidadeDAO.getCidades();
        String texto = "Cidades Cadastradas: ";
        for (Cidade cidade: cidades){
            texto += "\n" + cidade.id + " - " + cidade.nome;
        }
        
        texto += "\n Digite o ID da cidade que deseja excluir";
        String idDigitado = JOptionPane.showInputDialog(texto);
        if ( idDigitado.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Digite um ID válido");
        }else{
            int idCidade = Integer.valueOf(idDigitado);
            CidadeDAO.excluir(idCidade);
        }
    }

    
    @Override
    public String toString(){
        return "Cidade: \n  Nome: "+ this.nome + "\n  Id: " + this.id ;
    }
    
}
