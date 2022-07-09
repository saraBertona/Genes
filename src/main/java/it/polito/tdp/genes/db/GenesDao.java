package it.polito.tdp.genes.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.genes.model.Coppia;
import it.polito.tdp.genes.model.Genes;
import it.polito.tdp.genes.model.Interactions;


public class GenesDao {
	
	public List<Genes> getAllGenes(){
		String sql = "SELECT DISTINCT GeneID, Essential, Chromosome FROM Genes";
		List<Genes> result = new ArrayList<Genes>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				Genes genes = new Genes(res.getString("GeneID"), 
						res.getString("Essential"), 
						res.getInt("Chromosome"));
				result.add(genes);
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	public List<String> getAllLocalizations(){
		String sql = "SELECT distinct localization "
				+ "FROM classification "
				+ "ORDER BY localization";
		List<String> result = new ArrayList<>();
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				
				result.add(res.getString("localization"));
			}
			res.close();
			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	public int getArchi(String l1, String l2){
		String sql = "SELECT count(DISTINCT type) as tipo FROM (SELECT c.localization AS Localization1, c2.Localization AS Localization2 , c.GeneID AS Gene1, c2.GeneID AS Gene2, i.`Type` FROM classification c, classification c2, interactions i WHERE c.Localization=? AND c2.Localization=? AND((i.GeneID1=c.GeneID AND i.GeneID2=c2.GeneID) OR (i.GeneID1=c2.GeneID AND i.GeneID2=c.GeneID)) GROUP BY c.Localization, c2.Localization, c.GeneID, c2.GeneID ORDER BY 'Gene2') AS a2";
		
		int peso=0;
		Connection conn = DBConnect.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, l1);
			st.setString(2, l2);
			ResultSet res = st.executeQuery();
			if(res.next()) {
				peso=res.getInt("tipo");
			}
			res.close();
			st.close();
			conn.close();
			if(peso>0)
			return peso;
			else return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}
	
	
	
	


	
}
