package com.exercise1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;


public class PostgreSQLManager {

    private final String connectionURL;


    public PostgreSQLManager(String url, int port, String dbName, String user, String password) {
        this.connectionURL = "jdbc:postgresql://" + url + ":" + port + "/" + dbName + "?user=" + user + "&password=" + password;
    }

    /*
    public PostgreSQLManager(String connectionURL){
        this.connectionURL = connectionURL;
    }
    */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(connectionURL);
    }

    /*
     * Add new entries to the Player table.
     *
     * This function takes six variables containing player information and creates a new entry in the Player table.
     *
     * @param firstName: The player's first name
     * @param lastName: The player's last name
     * @param address: The player's mailing address
     * @param postalCode: The player's postal code
     * @param province: The player's province of residence
     * @param phone: The player's phone number
     *
     * @returns newPlayerID: The key referencing the inserted Player item
     */
    public int addPlayer(String firstName, String lastName, String address, String postalCode, String province, String phone) {
        String query = "INSERT INTO player (first_name, last_name, address, postal_code, province, phone_number) VALUES (?,?,?,?,?,?)";
        int newPlayerID;
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, postalCode);
            stmt.setString(5, province);
            stmt.setString(6, phone);
            stmt.executeUpdate();

            // Retrieve the generated PlayerID
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    newPlayerID = rs.getInt(1);
                    System.out.println("New player ID generated: " + newPlayerID);
                } else {
                    throw new SQLException("Failed to retrieve auto-generated key for new Player.");
                }
            }

            return newPlayerID;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    /*
     * Retrieves player by id
     *
     * @param playerId: The integer id of the player (unique)
     *
     * @returns player: A playerInfo object containing the player's info
     */
    public PlayerInfo getPlayerById(int playerId){
        String query = "SELECT * FROM player WHERE player_id=?";
        PlayerInfo player = null;
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                player = new PlayerInfo(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"), rs.getString("postal_code"), rs.getString("province"), rs.getString("phone_number"));
            }

            return player;
        }
        catch (SQLException e) {

            e.printStackTrace();
            return null;
        }

    }
    /*
     * Updates entries in the Player table.
     *
     * This function takes seven variables containing player information and creates a new entry in the Player table.
     *
     * @param playerID: The unique ID generated when the Player was created
     * @param firstName: The player's first name
     * @param lastName: The player's last name
     * @param address: The player's mailing address
     * @param postalCode: The player's postal code
     * @param province: The player's province of residence
     * @param phone: The player's phone number
     *
     * @returns True if update successful, False otherwise
     */
    public boolean updatePlayer(int playerID, String firstName, String lastName, String address, String postalCode, String province, String phone) {
        String query = "UPDATE player SET first_name=?, last_name=?, address=?, postal_code=?, province=?, phone_number=? WHERE player_id=?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, postalCode);
            stmt.setString(5, province);
            stmt.setString(6, phone);
            stmt.setInt(7, playerID);
            stmt.executeUpdate();
            System.out.println("Player record for " + firstName + "successfully updated");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    /*
     * Add new entries to the Game table.
     *
     * This function takes one variable containing the game's title and creates a new entry in the Game table.
     *
     * @param gameTitle: The title of the game (unique)
     *
     * @returns newGameID: The key referencing the inserted Game item
     */
    public int addGame(String gameTitle) {
        String query = "INSERT INTO game (game_title) VALUES (?)";
        int newGameID;
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, gameTitle);
            stmt.executeUpdate();

            // Retrieve the generated GameID
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    newGameID = rs.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve auto-generated key for new Game.");
                }
            }
            System.out.println("New game ID generated: " + newGameID);
            return newGameID;
        } catch (SQLException e) {

            if (e.getErrorCode() == 1062 || e.getErrorCode() == 2627 || e.getErrorCode() == 2601) {
                System.out.println("Duplicate Game detected: " + e.getMessage());
            }
            e.printStackTrace();
            return 0;
        }

    }
    /*
     * Retrieves game title by id
     *
     * @param gameId: The integer id of the game (unique)
     *
     * @returns gameTitle: The title of the game as a string
     */
    public String getGameById(int gameId){
        String query = "SELECT game_title FROM game WHERE game_id=?";
        String gameTitle = "";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, gameId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gameTitle =  rs.getString("game_title");
            }

            return gameTitle;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /*
     * Adds new entries to the Player-Game table when a Player adds info
     *
     *
     * @param gameTitle: The title of the game (unique)
     *
     * @returns newGameID: The key referencing the inserted Game item
     */
    public boolean addPlayerGame(int gameID, int playerID, Date playingDate, int score) {
        String query = "INSERT INTO player_and_game (game_id, player_id, playing_date, score) VALUES (?,?,?,?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, gameID);
            stmt.setInt(2, playerID);
            stmt.setDate(3, playingDate);
            stmt.setInt(4, score);
            stmt.executeUpdate();
            System.out.println("New player-game entry generated");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    // get reports by player id
    public List<GameInfo> getRecords(int playerID){

        String query = "SELECT * FROM player_and_game WHERE player_id=?";
        List<GameInfo> records = new ArrayList<>();

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, playerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                records.add(new GameInfo(getGameById(rs.getInt("game_id")), rs.getDate("playing_date"), rs.getInt("score")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return records;
    }

}
