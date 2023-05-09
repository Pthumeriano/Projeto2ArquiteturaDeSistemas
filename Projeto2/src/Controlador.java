import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Controlador {
	Fila tarefas;
	Scanner ler;
	
	
	private static Controlador instance = null;
	
	private Controlador(Fila tarefas){
		this.tarefas = tarefas;
		this.ler = new Scanner(System.in);

	}
	
	public static Controlador getInstance(Fila tarefas){
		if(instance==null) {
			instance = new Controlador(tarefas);
		}
		return instance;
	}
	
	public void salvar() throws IOException{
		JSONObject json = new JSONObject();
		
		for(int i=0; i<tarefas.getTamanho() + 1; i++) {
			String nome = tarefas.getAtual().getNome();
			String descricao = tarefas.getAtual().getDescricao();
			
			json.put(nome, descricao);
			
			tarefas.desenfileirar();
		}
		
		String jsonString = json.toJSONString();
		
		// Define a URL do servidor Express
        String url = "http://localhost:3000/";

        // Cria a conexão HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        // Envia o JSON na requisição
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(jsonString);
        wr.flush();
        wr.close();

        // Lê a resposta do servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Imprime a resposta do servidor
        System.out.println(response.toString());
    }
	
	public void carregar() {
		
		
		
	}
	
	public void escutar(int entrada) throws IOException {
		String nome = "";
		String descricao = "";
		Tarefa temp = new Tarefa(null,null);
		
		switch(entrada) {
		
		case 1:
			
			System.out.println("Digite o nome da tarefa: ");
			nome = ler.nextLine();
			
			System.out.println("Digite a descrição da tarefa");
			descricao = ler.nextLine();
			
			temp = new Tarefa(nome, descricao);
			tarefas.enfileirar(temp);
			
			System.out.println("Adicinando tarefa " + temp.getNome() + " à fila");
			
			break;
		case 2:
			
			System.out.println("Concluindo tarefa atual...");
			tarefas.desenfileirar();
			
			break;
		case 3:
			
			temp = tarefas.getAtual();
			System.out.println();
			System.out.println("Tarefa atual");
			System.out.println("Nome: " + temp.getNome());
			System.out.println("Descricao: " + temp.getDescricao());
			
			break;

		case 4:
			salvar();
			break;
		case 5:
			carregar();
			break;
		case 6:
			System.out.println("Saindo...");
			
			break;
		}
	}
}