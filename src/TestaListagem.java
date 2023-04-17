import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
		Connection connection1 = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "93902212");

		System.out.println("Fechando conexão!!");
		
		
	PreparedStatement stm = connection1.prepareStatement("SELECT IND, NOME, DESCRICAO FROM PRODUTO");
	stm.execute();
		
	ResultSet rst =  stm.getResultSet();
	
	while(rst.next()) {
		Integer id = rst.getInt("ID");
		System.out.println(id);
		String nome = rst.getString("NOME");
		System.out.println(nome);
		String descricao = rst.getString("DESCRICAO");
		System.out.println(descricao);
		
	}

		connection1.close();

	}

	

}
