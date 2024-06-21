package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDAO implements Dao<Utilisateur> {
	
	private static final List<Utilisateur> users = new ArrayList<>();
	private static int lastId = 1;
	
	static {
		users.add(new Utilisateur("Papa Adama", "Gueye", "papaadamagueye@esp.sn", "Passer123"));
		users.add(new Utilisateur("John", "Doe", "jonhdoe@esp.sn", "Passer123"));
		users.add(new Utilisateur("Mary", "Jane", "maryjane@esp.sn", "Passer123"));
	}
	
	public void add(Utilisateur utilisateur) {
		utilisateur.setId(lastId++);
		users.add(utilisateur);
	}
	
	public List<Utilisateur> getAll() {
		return users;
	}
	
	public void remove(int id) {
		users.removeIf(user -> user.getId() == id);
	}
	
	public void update(int id, Utilisateur modifiedUser) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				modifiedUser.setId(id);
				users.set(i, modifiedUser);
				break;
			}
		}
	}
	
	public Utilisateur findById(int id) {
		return users.stream()
		             .filter(user -> user.getId() == id)
		             .findFirst()
		             .orElse(null);
	}
	
	public Utilisateur findByUsername(String username) {
		return users.stream()
		             .filter(user -> user.getUsername().equals(username))
		             .findFirst()
		             .orElse(null);
	}
	
	public Utilisateur login(String username, String password) {
		return users.stream()
		             .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
		             .findFirst()
		             .orElse(null);
	}
}
