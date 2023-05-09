import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		Fila tarefas = new Fila();
		Controlador controlador = Controlador.getInstance(tarefas);
		new Menu(controlador).menu();
	}

}
