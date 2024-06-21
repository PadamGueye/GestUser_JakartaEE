package dao;

import java.util.List;

import beans.Utilisateur;
import db.DatabaseManager;

public class DaoMysqlImpl implements Dao<Utilisateur> {
	
	private static final List<Utilisateur> users = DatabaseManager.getAllUtilisateurs();
	
	public void add(Utilisateur utilisateur) {
		DatabaseManager.addUtilisateur(utilisateur);
	}
	
	public List<Utilisateur> getAll() {
		return DatabaseManager.getAllUtilisateurs();
	}
	
	public void remove(int id) {
		DatabaseManager.deleteUtilisateur(id);
	}
	
	public void update(int id, Utilisateur modifiedUser) {
		DatabaseManager.updateUtilisateur(id, modifiedUser);
	}
	
	public Utilisateur findById(int id) {
		return DatabaseManager.getUtilisateurById(id);
	}
	
	public Utilisateur findByUsername(String username) {
		return DatabaseManager.getUtilisateurByUsername(username);
	}
	
	public Utilisateur login(String username, String password) {
		for (Utilisateur user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
