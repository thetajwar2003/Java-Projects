package Machine;
import java.io.IOException;
import java.sql.SQLException;

public class ATM extends OptionMenu{

	public static void main(String[] args) throws IOException, SQLException {
		OptionMenu om = new OptionMenu();
		om.login();
	}

}
