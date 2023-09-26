package service;

import java.util.List;

import dao.TarefaDAO;
import model.Tarefa;

public class TarefaService {
	TarefaDAO dao = new TarefaDAO();
	
	public List<Tarefa> buscaTarefaPorId(Integer id) {
		return dao.pesquisarPorId(id);
	}
	
	public List<Tarefa> listarTarefas() {
		return dao.listar();
	}
	
	public boolean incluirTarefa(Tarefa tarefa) {
		return dao.incluirTarefa(tarefa);
	}
	
	public boolean alterarTarefa(Tarefa tarefa) {
		return dao.alterarTarefa(tarefa);
	}
	
	public boolean excluirTarefa(Integer id) {
		return dao.excluirTarefa(id);
	}
}
