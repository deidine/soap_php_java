package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.db.DbConnection;
import com.example.model.Personne;

public class PersonneDao implements Dao<Personne> {
	// variables
	Connection connection = null;
	Statement statement = null;
	PreparedStatement ps;
	String requet = null;
	Personne personne = null;

	public PersonneDao() {
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Personne> getAll() {

		return null;
	}

	@Override
	public Personne getById(int id) {
		requet = "SELECT * FROM PERSONNE WHERE nni =" + id + " ;";
		System.out.println(requet);
		try {
			ResultSet resultSet = statement.executeQuery(requet);
			resultSet.next();
			int nni = resultSet.getInt("nni");
			String nom = resultSet.getString("nom");
			personne = new Personne(nni, nom);
			System.out.println(personne.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personne;
	}

	@Override
	public void save(String nom,int nni) {
		requet = "insert into personne values(" + nni + ",'" + nom + "');";
		System.out.println(requet);

		try {
			int resultat = statement.executeUpdate(requet);
			if (resultat != 0) {
				System.out.println("Insertion effectuée");
			} else {
				System.out.println("Erreur d'insertion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Personne t, int[] params) {
		try {
            String query = "UPDATE personne SET nni=?,nom=? WHERE nni=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, t.getNni());
			ps.setInt(2, t.getNni());

            ps.setString(3,t.getNom() );

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
	}

	@Override
	public void delete(int t) {
	
		 try {
            String query = "DELETE FROM personne WHERE nni=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, t);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "le produit est suprimer.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
public static void main(String args[]){
	System.out.println("bonjour");
}

}
