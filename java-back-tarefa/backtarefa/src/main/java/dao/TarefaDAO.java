package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;

public class TarefaDAO {
	
	public List<Tarefa> pesquisarPorId(Integer id) {
		List<Tarefa> lista = new ArrayList<Tarefa>();
		Tarefa tarefas;
		
		String SQL = "SELECT * FROM tarefas WHERE id = ?";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tarefas = new Tarefa();
				
				tarefas.setId(rs.getInt("id"));
				tarefas.setDescricao(rs.getString("descricao"));
				tarefas.setStatus(rs.getBoolean("status"));
				
				lista.add(tarefas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return lista;
		}
	}
	
	public boolean excluirTarefa(Integer id) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "DELETE FROM tarefas WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean alterarTarefa(Tarefa tarefa) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "UPDATE tarefas SET descricao = ?, status = ? WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, tarefa.getDescricao());
			ps.setBoolean(2, tarefa.getStatus());
			ps.setInt(3, tarefa.getId());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public boolean incluirTarefa(Tarefa tarefa) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "INSERT INTO tarefas(descricao, status) VALUES(?, ?)";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, tarefa.getDescricao());
			ps.setBoolean(2, tarefa.getStatus());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public List<Tarefa> listar() {
		List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
		Tarefa tarefa;
		
		String SQL = "SELECT * FROM tarefas";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(rs.getBoolean("status"));
				
				listaDeTarefas.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listaDeTarefas;
		}
	}
}
