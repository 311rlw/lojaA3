package menu;

import java.util.HashMap;
import java.util.Map;


// classe que cuida da criação de menus
public class MenuHandler {
    
    private Map<Integer, MenuCommand> menuMap = new HashMap<Integer, MenuCommand>();

    public MenuHandler() {
        menuMap.put(-1, new PrincipalMenuCommand(this));
        menuMap.put(1, new CadastrarMenuCommand(this));
        menuMap.put(2, new ListarMenuCommand(this));
        menuMap.put(3, new ExcluirMenuCommand(this));
        menuMap.put(4, new PedidoMenuCommand(this));
        menuMap.put(0, new ExitMenuCommand(this));
        
    }
    
    public void select(int opcao) {
        menuMap.get(opcao).execute();
    }
   
}
