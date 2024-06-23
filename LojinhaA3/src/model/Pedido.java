package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Pedido {
    
    public static double TAXA_DE_ENTREGA=8.99;
    
    public int id;
    public String endereco;
    public List <Produto> produtos;
    public Cliente cliente;
    private double valorTotal;
    
    
//    metodo construtor
    public Pedido(){
        this.produtos = new ArrayList<Produto>();
    }
    
    public Pedido(String endereco, Cliente cli){
        this.endereco = endereco;
        this.cliente = cli;
        this.produtos = new ArrayList<Produto>();
    }
    
//    metodo acessor (GET)
    public double getvalorTotal(){
        return this.valorTotal;
    }
    
//    metodo modificador (SET)
    public void setvalorTotal(double valor){
        if (valor >=TAXA_DE_ENTREGA)
        this.valorTotal=valor;
        else 
            System.out.println("Valor não permitido");
    }
    
    
//    alguma coisa  seila
    public void addProduto(Produto prod){
        if (this.produtos.size() == 0){
        this.valorTotal += TAXA_DE_ENTREGA;
    }
        this.produtos.add(prod);
        this.valorTotal+=prod.preco;
    }
    
/*    public void addProduto(Produto[] listaDeProdutos){
        for (Produto pr : listaDeProdutos){
            this.produtos.add(pr);
        }
*/    
    
    public void addProduto(Produto...p){
        if (this.produtos.size() == 0){
        this.valorTotal += TAXA_DE_ENTREGA;
    }
        for (Produto produto : p){
            this.produtos.add(produto);
            this.valorTotal+=produto.preco;
        }
        
        
            
    }
    
    public void imprimirPedido(){
        System.out.println("\n-------------Pedido------------ ");
        System.out.println("Pedido no endereço: " + this.endereco );
        System.out.println("Nome da Cidade do Cliente: " + this.cliente.cidade.nome);
        System.out.println("Nome do Cliente: " + this.cliente.nome );
        if(this.produtos.size()==0 ){
            System.out.println("Pedido Vazio");
        }else{
            System.out.println("Produtos do Pedido");
            for(Produto prod : this.produtos){
                System.out.println(prod.nome + " - " + prod.preco);
            }
            System.out.println("Valor total do pedido: R$ " + String.format("%.2f", valorTotal));
        }
    }
    
    public static void listarPedidos(List<Pedido> pedidos){
        String texto = "Pedidos Registrados: ";
        if (pedidos.size() == 0) {
            texto += "Nenhum pedido registrado!";
            JOptionPane.showMessageDialog(null, texto);
            
        }else{
            for (Pedido ped : pedidos) {
                texto += "\n----------------Pedido----------------";
                texto += "\nID do Pedido: " + ped.id;
                texto += "\nPedido no endereço: " + ped.endereco;
                texto += "\nNome da Cidade do Cliente: " + ped.cliente.cidade.nome;
                texto += "\nNome do Cliente: " + ped.cliente.nome ;
                texto += "\nTotal do Pedido: R$ +"
                + String.format("%.2f", ped.getvalorTotal());
            }
        JOptionPane.showMessageDialog(null, texto);
        }
    }
    
    public static Pedido cadastrarPedido(List<Pedido> pedidos, List<Cliente> clientes){
        String idDigitado = JOptionPane.showInputDialog("Digite o ID da Pedido: ");
		int id = 0;
		if( ! idDigitado.isEmpty() ){
			id = Integer.valueOf( idDigitado );
		}
		String end = JOptionPane.showInputDialog("Digite o endereço de entrega: ");
		String texto = "Clientes cadastrados:";
		for (Cliente cli : clientes) {
			texto += "\n " + cli.id +  " - " + cli.nome;
		}
		texto += "\n  Digite o id do cliente deste Pedido: ";
		int idCliente = Integer.valueOf(  JOptionPane.showInputDialog(texto) );
		Cliente cliSelecionado = null;
		for (Cliente cli : clientes) {
			if( cli.id == idCliente ){
				cliSelecionado = cli;
			}
		}
		Pedido novoPedido = new Pedido();
		novoPedido.id = id;
		novoPedido.endereco = end;
		novoPedido.cliente = cliSelecionado;
		return novoPedido;
                
    }
    
    public static void addProdutoAoPedido(List<Produto> produtos, Pedido pedido){
		String texto = "Produtos cadastrados:";
		if( produtos.size() == 0 ){
			texto += "\n\nNenhum produto cadastrado";
		}
		for ( Produto prod: produtos ) {
			texto += "\n " + prod.id +  " - " + prod.nome + 
				 "\nPreço: R$ " + prod.preco +
				 "\nQuantidade: " + prod.quantidade +
				 "\nCategoria: " + prod.categoria.nome + 
				 "\n-------------------------" ;
		}
		texto += "\n\nDigite o id do Produto";
		String idDigitado = JOptionPane.showInputDialog(null, texto);
		int idProduto = 0;
		if( !idDigitado.isEmpty() ){
			idProduto = Integer.valueOf( idDigitado ) ;
		}

		Produto prodSelecionado = null;
		for (Produto produto : produtos) {
			if( produto.id == idProduto){
				prodSelecionado = produto;
			}
		}
		pedido.addProduto( prodSelecionado );

		
	} 
    
    public static void visualizarPedido(List<Pedido> pedidos){
		int idPedido = Integer.valueOf( JOptionPane.showInputDialog("Id do Pedido:") );
		Pedido pedSelecionado = null;
		for (Pedido pedido : pedidos) {
			if( pedido.id == idPedido){
				pedSelecionado = pedido;
			}
		}
		String texto = "";
		texto += "Pedido no end: " + pedSelecionado.endereco ;
		texto += "\nNome do Cliente: " + pedSelecionado.cliente.nome;
		texto += "\nNome da cidade do Cliente: " + pedSelecionado.cliente.cidade.nome;
		texto += "\nTotal do Pedido: R$ " + 
			 String.format("%.2f",  pedSelecionado.getvalorTotal());
		if( pedSelecionado.produtos.size() == 0 ){
			texto += "\nPedido Vazio";
		}else{
			texto += "\nProdutos do Pedido";
			for (Produto prod : pedSelecionado.produtos ) {
				texto += "\n" + prod.nome + " - " + prod.preco + " - " + prod.categoria.nome;
			}
		}
		JOptionPane.showMessageDialog(null, texto);
        }  
}
