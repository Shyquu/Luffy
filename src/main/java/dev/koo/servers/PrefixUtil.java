package dev.koo.servers;

import dev.koo.Luffy;
import org.javacord.api.entity.server.Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrefixUtil {

    Connection connection = Luffy.getConnection();
    Server server;

    public PrefixUtil(Server server) {
        this.server = server;
    }

    public void newServer() {
        setPrefix("L.");
    }

    public void setPrefix(String prefix) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO `servers` (`server_id`, `prefix`, `premium_status`) values ('" + server.getIdAsString() + "', '" + prefix + "', false)");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Luffy.updateMap(server.getIdAsString(), prefix);
    }

    public void updatePrefix(String prefix) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE `servers` SET `prefix` = '" + prefix + "' WHERE `server_id` = '" + server.getIdAsString() + "'");
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Luffy.updateMap(server.getIdAsString(), prefix);
    }

    public String getPrefix() {
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
