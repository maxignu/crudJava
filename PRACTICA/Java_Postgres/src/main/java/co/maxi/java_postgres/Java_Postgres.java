package co.maxi.java_postgres;

import java.sql.*;

/**
 *
 * @author maxi
 */
public class Java_Postgres {

    public static void main(String[] args) throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/mensajes_db",
                "postgres",
                "admin"
        );
        System.out.println("Conexion Exitosa");
        String sql = "SELECT * FROM mensajes";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_mensaje");
            String mensaje = rs.getString("mensaje");
            String autor = rs.getString("autor");
            String fecha = rs.getString("fecha");

            System.out.printf("%d %s %s s%\n",
                    id, mensaje, autor, fecha);
        }
        rs.close();
        ps.close();
        conectar.close();
    }

}
