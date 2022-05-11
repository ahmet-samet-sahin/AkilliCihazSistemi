import java.sql.SQLException;

interface IVeritabaniSurucu{
    void baglan();
    boolean sistemeGiris(String username, String password);
    void baglantiSonlandir() throws SQLException;
    boolean yetkiKontrol(String username, String password) throws SQLException;
}
