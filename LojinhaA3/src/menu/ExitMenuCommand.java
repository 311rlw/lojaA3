package menu;

public class ExitMenuCommand extends MenuCommand{

    public ExitMenuCommand(MenuHandler menu) {
        super(menu);
    }
    
    public void execute() {            
        this.opcao = 0;
    }
    
    @Override
    public String mostrarTexto() {
        return null;
    }

}
