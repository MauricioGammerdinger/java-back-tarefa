import java.sql.Connection;
import java.util.List;

import dao.Dao;
import dao.TarefaDAO;
import model.Tarefa;

public class App {

	public static void main(String[] args) {
		System.out.println(Dao.getStatusConexao());
		Connection conexao = Dao.getConexao();
		System.out.println(Dao.getStatusConexao());
		
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.listar();
		
//		lista.forEach(tarefa -> System.out.println(tarefa));
		
		if(lista.isEmpty()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar para a prova");
			tarefa.setStatus(false);
			
			if(dao.incluirTarefa(tarefa)) {
				System.out.println("Tarefa incluída com sucesso!");
			} else {
				System.out.println("Não foi possível incluir a tarefa.");
			}
			
		}
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(2);
		tarefa.setDescricao("Comprar Jornal");
		tarefa.setStatus(false);
		
		List<Tarefa> listaId = dao.pesquisarPorId(2);
		listaId.forEach(tarefas -> System.out.println(tarefas));
		
//		if(dao.alterarTarefa(tarefa)) {
//			System.out.println("Tarefa alterada com sucesso!");
//		} else {
//			System.out.println("Não foi possível alterar a tarefa.");
//		}
		
//		if(dao.excluirTarefa(2)) {
//			System.out.println("Tarefa excluída com sucesso!");
//		} else {
//			System.out.println("Não foi possível excluir a tarefa.");
//		}
	}
}
