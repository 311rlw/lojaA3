package menu;

import dao.ClienteDAO;
import javax.swing.JOptionPane;
import model.Pedido;

public class PedidoMenuCommand extends MenuCommand{

    public PedidoMenuCommand(MenuHandler menu) {
        super(menu);
    }
    
    public void execute() {
        super.execute();
        
        switch(opcao) {
            case 1: clientes = ClienteDAO.getClientes();
                    pedidos.add(Pedido.cadastrarPedido(pedidos,clientes));
                    break;
            case 2: Pedido.listarPedidos(pedidos);
                    if ( pedidos.size() > 0){
                        if (produtos.size()  == 0 ){
                            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                            break;
                        }else{
                                String idPedDigitado = JOptionPane.showInputDialog("Digite o ID do pedido: ");
                                if (idPedDigitado.isEmpty() ){
                                    break;
                                }else{
                                    try {
                                        int idPed = Integer.valueOf(idPedDigitado);
                                    Pedido pedSelected = null;
                                    for (Pedido pedido : pedidos) {
                                        if( pedido.id == idPed){
                                            pedSelected = pedido;
                                        }
                                    }
                                    Pedido.addProdutoAoPedido(produtos, pedSelected);
                                    break;

                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, e.toString() );
                                        break;
                                        }
                                    }
                            }
                        }else{
                            break;
                        }
            case 3: Pedido.visualizarPedido(pedidos);
                    break;
            case 4: Pedido.listarPedidos(pedidos);
                    break;
            case 0: menu.select(opcao=-1);
                break;
        }
        
        menu.select(opcao=4);
    }
    
    @Override
    public String mostrarTexto() {
        String texto = """
                       -----=Pedido=-----
                       
                        1 - Novo Pedido
                        2 - Adicionar Produto ao Pedido
                        3 - Visualizar Pedido
                        4 - Listar Pedidos
                        0 - Voltar
                        
                       Digite a opção desejada: """;
        return texto;
    }

}
