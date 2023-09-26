<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.TarefaService" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Tarefa" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tarefas</title>
</head>

<body>
	<div class="interface">
		<h1> Tarefas </h1>
	
		<%
			TarefaService service = new TarefaService();
		
			List<Tarefa> lista = service.listarTarefas();
			
			out.println("<table style='margin-bottom: 2rem; border: solid 2px'>");
				out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID </th>");
				out.println("<th style='width: 20%; border-right: solid 1px; border-bottom: solid 1px'> Descrição </th>");
				out.println("<th style='width: 15%; border-bottom: solid 1px'> Status </th>");

			for(Tarefa tarefa: lista) {
				out.println("<tr>");
					out.println("<td>" + tarefa.getId() + "</td>");
					out.println("<td>" + tarefa.getDescricao() + "</td>");
					out.println("<td>" + tarefa.getStatus() + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
		%>
	
		<a href="index.html" style="padding: .5rem; background-color: black; color: #fff; border-radius: 2rem; text-decoration: none"> Voltar </a>
	</div>
</body>

</html>