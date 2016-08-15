package com.ReadSqlData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadsqlData {

	public List<List<String>> ReadData() throws Throwable {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection m_Connection = DriverManager
				.getConnection("jdbc:sqlserver://SESOCO1648:1433;"
						+ "databaseName=SP_INT_TEST;user=Salesportal;password=Spb425ffeF3ve");

		Statement m_Statement = m_Connection.createStatement();
		String query = "select * from PriceCategoryGroup";

		ResultSet m_ResultSet = m_Statement.executeQuery(query);

		int numcols = m_ResultSet.getMetaData().getColumnCount();
		List<List<String>> result = new ArrayList<>();

		while (m_ResultSet.next()) {
			System.out.println(m_ResultSet.getString(1) + ", "
					+ m_ResultSet.getString(2) + ", "
					+ m_ResultSet.getString(3));

			List<String> row = new ArrayList<>(numcols); // new list per row

			for (int i = 1; i <= numcols; i++) { // don't skip the last column,
													// use <=
				row.add(m_ResultSet.getString(i));
				System.out.print(m_ResultSet.getString(i) + "\t");
			}
			result.add(row); // add it to the result

			System.out.print("\n");

		}
		return result;

	}

}
