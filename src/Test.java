import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:saperp:ConnectionScheme=ApplicationServer;Host=/H/10.0.1.61/S/3300;User=DDIC;Password=c`460653078;Client=001;ReadTableFunction=RFC_READ_TABLE2");
        Statement stat = conn.createStatement();
        boolean ret = stat.execute("SELECT * FROM BUT000_BCS");
        if (ret) {
            ResultSet rs = stat.getResultSet();
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.println(rs.getMetaData().getColumnLabel(i) + "=" + rs.getString(i));
                }
            }
        }
    }
}