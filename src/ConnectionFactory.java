import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDateSource;


public class ConnectionFactory {
	


	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("93902212");
		
		this.dataSource = comboPooledDataSource;
		
	}

	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	
	
	}
	
}
