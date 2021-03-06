import java.sql.*;
public class PostgreSQLSurucu implements IVeritabaniSurucu {
	
	Connection conn;
    ResultSet rs;
    Statement stmt;
    boolean state;
    boolean role;

    @Override
    public void baglan(){
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihazSistemiDB","postgres", "12345");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean sistemeGiris(String username, String password) {
        try{
            String girisKontrol = "SELECT *  FROM \"Kullanici\" WHERE \"Kullanici_Adi\"='" + username + "' and \"Kullanici_Sifre\"='" + password + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(girisKontrol);
            if(!rs.next())
                state = false;
            else{
                state = true;
            }
            return state;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public void baglantiSonlandir() throws SQLException {
        conn.close();
        stmt.close();
        rs.close();
    }
    
    @Override
    public boolean yetkiKontrol(String username, String password) throws SQLException {
        String yetkiKontrol = "SELECT \"Role_Id\" FROM \"Kullanici\" WHERE \"Kullanici_Adi\"='" + username + "' and \"Kullanici_Sifre\"='" + password + "'";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(yetkiKontrol);
        rs.next();
        role = rs.getString(1).equals("1");
        return role;
    }
}
