import java.sql.*;
public class AkilliCihazSistemi {

	public static void main(String[] args) throws SQLException, InterruptedException {
		AkilliCihaz akilliCihaz = new AkilliCihaz(
                new Ekran(),
                new Algilayici(),
                new SogutucuA("Sogutucu A", "ABC Sogutma",1,"Evet"),
                new Observer(),
                new PostgreSQLSurucu());

        akilliCihaz.basla();

	}

}
