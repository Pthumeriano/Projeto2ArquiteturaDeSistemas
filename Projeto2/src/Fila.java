
public class Fila {
	private class Node {
		
		private Tarefa tarefa;
		private Node proximo;
		
		public Tarefa getTarefa() {
			return this.tarefa;
		}
		
		public Node(Tarefa tarefa) {
			this.tarefa = tarefa;
			this.proximo = null;
		}
	}
	
	private Node inicio;
	private Node fim;
	private int tamanho;
	
	public Fila() {
		this.tamanho = 0;
		this.inicio = null;
		this.fim = null;
	}
	
	public boolean isEmpty() {
		return this.tamanho == 0;
	}
	
	public void enfileirar(Tarefa tarefa) {
		Node novo = new Node(tarefa);
		
		if(this.isEmpty()) {
			this.inicio = novo;
			this.fim = inicio;
		}else {
			this.fim.proximo = novo;
			this.fim = this.fim.proximo;
		}
		
		this.tamanho++;
	}
	
	public Tarefa desenfileirar() {
		if(this.isEmpty()) {
			return null;
		}
		Tarefa temp = this.inicio.getTarefa();
		this.inicio = this.inicio.proximo;
		
		this.tamanho--;
		return temp;
	}
	
	public Tarefa getAtual() {
		if(this.isEmpty()) {
			return null;
		}
		return this.inicio.getTarefa();
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	
}
