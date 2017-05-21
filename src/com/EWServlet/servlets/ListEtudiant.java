package com.EWServlet.servlets;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListEtudiant 
{
	List<Etudiant> listEtudiant = new ArrayList<Etudiant>();
	
	
	public void getList()
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e)
		{
			System.out.println("Where is your PostgreSQL JDBC Driver? "+ "Include in your library path!");
			e.printStackTrace();
			return;
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try 
		{
			connection = DriverManager.getConnection(
							"jdbc:postgresql://db-pg-herimanitra.ciqwjcutxnr2.us-west-2.rds.amazonaws.com:5432/dbstats",
							"herimanitra","stat2016");
			Statement stmt = null;
			ResultSet rs =null;
			stmt = connection.createStatement();
			rs=stmt.executeQuery("select * from etudiant");
			while (rs.next())
			{
				Etudiant etudiant = new Etudiant(rs.getString("nom"),rs.getString("prenom"));
				listEtudiant.add(etudiant);
			}
			connection.close();

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
	}
	
}
