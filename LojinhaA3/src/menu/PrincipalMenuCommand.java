package menu;

public class PrincipalMenuCommand extends MenuCommand {

    public PrincipalMenuCommand(MenuHandler menu) {
        super(menu);
        this.isPrincipal = true;
    }

    @Override
    public String mostrarTexto() {
        String texto = """
                       -----=Loja=-----
                       
                        1 - Cadastrar
                        2 - Listar
                        3 - Excluir
                        4 - Pedido
                        
                       Digite a opção desejada: """;
        
        return texto;
    }

}
