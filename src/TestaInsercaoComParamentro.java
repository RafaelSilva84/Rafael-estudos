import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class TestaInsercaoComParamentro {

	public static void main(String[] args) {
		
		String nome = "Mouse";
		String descricao = "Mouse sem fio";

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		PreparedStatement stm =
		connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)"
				, Statement.RETURN_GENERATED_KEYS);
		
		adicionarVariavel("Smart TV", "45 polegadas", stm);
		adicionarVariavel("Radio", "Radio de bateria", stm);
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet rst =  stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi:" + id);
		}
		rst.close();
	}

}
