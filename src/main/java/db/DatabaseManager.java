package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.Utilisateur;

public class DatabaseManager {
    private static final List<Utilisateur> utilisateurs = new ArrayList<>();
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudjeedb";
    private static final String DATABASE_USERNAME = "crud_jee";
    private static final String DATABASE_PASSWORD = "passer";
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur de chargement du driver: " + e.getMessage());
        }
    }

    public static List<Utilisateur> getAllUtilisateurs() {
        try {
            utilisateurs.clear();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("prenom"),
                    resultSet.getString("nom"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
                );
                utilisateurs.add(utilisateur);
            }
            return utilisateurs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Utilisateur getUtilisateurById(int id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + id);
            if (resultSet.next()) {
                return new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("prenom"),
                    resultSet.getString("nom"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Utilisateur getUtilisateurByUsername(String username) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE username='" + username + "'");
            if (resultSet.next()) {
                return new Utilisateur(
                    resultSet.getInt("id"),
                    resultSet.getString("prenom"),
                    resultSet.getString("nom"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUtilisateur(Utilisateur utilisateur) {
        try {
            String sql = "INSERT INTO users (prenom, nom, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, utilisateur.getPrenom());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getUsername());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUtilisateur(int id, Utilisateur utilisateur) {
        try {
            String sql = "UPDATE users SET prenom=?, nom=?, username=?, password=? WHERE id=" + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, utilisateur.getPrenom());
            preparedStatement.setString(2, utilisateur.getNom());
            preparedStatement.setString(3, utilisateur.getUsername());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteUtilisateur(int id) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM users WHERE id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
