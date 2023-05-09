import java.io.IOException;
import java.util.Scanner;

public class Menu {
	Controlador controlador;
	
	public Menu(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public void menu() throws IOException {
		Scanner ler = new Scanner(System.in);
		int entrada = -1;
		while(entrada != 6) {
			System.out.println("    Fila de Tarefas");
			System.out.println("------------------------");
			System.out.println("| 1 - Adicionar Tarefa |");
			System.out.println("| 2 - Concluir Tarefa  |");
			System.out.println("| 3 - Ver Tarefa       |");
			System.out.println("| ---------------------|");
			System.out.println("| 4 - Salvar Tarefas   |");
			System.out.println("| 5 - Carregar Tarefas |");
			System.out.println("| ----------------------");
			System.out.println("| 6 - Sair             |");
			System.out.println("------------------------");
			entrada = ler.nextInt();
			controlador.escutar(entrada);
		}
		ler.close();
	}
	

}