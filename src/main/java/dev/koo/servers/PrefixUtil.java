package dev.koo.servers;

import dev.koo.Luffy;
import org.javacord.api.entity.server.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrefixUtil {

    Connection connection = Luffy.getConnection();

    public void setPrefix(Server server, String prefix) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `servers` (`server_id`, `prefix`) values ('" + server.getIdAsString() + "', ''" + prefix + "')");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePrefix(Server server, String prefix) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE `servers` SET `prefix` = '" + prefix + "' WHERE `server_id` = '" + server.getIdAsString() + "'");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPrefix(Server server) {
        try {
            PreparedStatement stmnt = connection.prepareStatement("SELECT `prefix` FROM `servers` WHERE `server_id` = '" + server.getIdAsString() + "'");
            ResultSet set = stmnt.executeQuery();
            while(set.next()) {
                return set.getString("prefix");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
