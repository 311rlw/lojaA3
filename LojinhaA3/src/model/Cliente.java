package model;

import dao.ClienteDAO;
import java.util.List;
import javax.swing.JOptionPane;

public class Cliente {
    
    public int id;
    public String nome, endereco, telefone, cpf;
    public Cidade cidade;
    
    public Cliente(){
        this.nome="Sem Nome";
    }
    
    public Cliente(String nome){
        this.nome=nome;
    }
    public Cliente(int id, String nome, String endereco, String telefone, String cpf, Cidade cidade){
        this.id=id;
        this.nome=nome;
        this.endereco=endereco;
        this.telefone=telefone;
        this.cpf=cpf;
        this.cidade=cidade;
    }
    
    public static void listarClientes( List<Cliente> clientes){
        String texto = "Clientes Cadastrados: ";
        if (clientes.size() ==0) {
            texto += "\nNenhum cliente cadastrado!";
        }
        for (Cliente cli: clientes){
            texto += "\n" + cli.id + " - " + cli.nome +
                    "\nEndereço: " + cli.endereco +
                    "\nTelefone: " + cli.telefone +
                    "\nCPF: " + cli.cpf +
                    "\nCidade - " + cli.cidade.nome + "\n------------------" ;
        }
        JOptionPane.showMessageDialog(null, texto);        
    }
    
    public static void cadastrarCliente(List<Cidade> municipios){
        
        String nome = JOptionPane.showInputDialog("Digite o nome do Cliente: ");
        String tel = JOptionPane.showInputDialog("Digite o telefone do Cliente: ");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do Cliente: ");
        String end = JOptionPane.showInputDialog("Digite o endereço do Cliente: ");
        
        String texto = "Cidades Cadastradas: ";
        for (Cidade cidade: municipios){
            texto += "\n" + cidade.id + " - " + cidade.nome;
        }
        texto += "\n Digite o id da cidade deste cliente";
        int idCidade = Integer.valueOf(JOptionPane.showInputDialog(texto));
        Cidade cidSelecionada = null;
        for (Cidade cidade : municipios) {
            if(cidade.id==idCidade){
                cidSelecionada = cidade;
            }
        }
        Cliente novoCliente = new Cliente(0, nome, end, tel, cpf, cidSelecionada);
        ClienteDAO.cadastrar(novoCliente);       
    }

    public static void excluirCliente(){
        List<Cliente> clientes = ClienteDAO.getClientes();
        String texto = "Clientes Cadastrados: ";
        for (Cliente cliente: clientes){
            texto += "\n" + cliente.id + " - " + cliente.nome;
        }
        
        texto += "\n Digite o ID do cliente que deseja excluir";
        String idDigitado = JOptionPane.showInputDialog(texto);
        if ( idDigitado.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Digite um ID válido");
        }else{
            int idCliente = Integer.valueOf(idDigitado);
            ClienteDAO.excluir(idCliente);
        }
    }

    
    @Override
    public String toString(){
        String texto = "Cliente: " + this.nome +
                       "\nEndereço: " + this.endereco +
                       "\nTelefone: " + this.telefone +
                       "\nCPF: " + this.cpf +
                       "\nCidade: " + this.cidade.nome;
        return texto;
    }
}
