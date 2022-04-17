package dev.koo.servers;

import dev.koo.Luffy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerUtil {
    /*
    private static final Connection connection = Luffy.getConnection();

    public static void setStatus(String id, String prefix, boolean status) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `servers` (`server_id`, `prefix`) values ('" + id + "', '" + prefix + "', '" + status + "')");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean getStatus(String id) {
        try {
            PreparedStatement stmnt = connection.prepareStatement("SELECT `status` FROM `servers` WHERE `server_id` = '" + id + "'");
            ResultSet set = stmnt.executeQuery();
            while(set.next()) {
                return set.getBoolean("prefix");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
     */

}
