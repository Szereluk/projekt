package pl.kladz;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceQuery {
	static private String query;
	static private String simpleQueryAnswer;

	public static void setQuery(String queryArg) {
		query = queryArg;
	}

	public static String getQuery() {
		return query;
	}

	public static void viewQueryAnswer(ResultSet rs) {
		try {
			for (int i = 2; i <= 6; i++) {
				simpleQueryAnswer = rs.getString(i);
				System.out.println("\n " + simpleQueryAnswer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	public static Question setQuestionOfQuery(ResultSet rs) // metoda zwraca
															// obiekt Question,
															// wczytany z bazy
															// lub NULL
	{
		Question q = null;
		try {
			q = new Question();
			q.setQuestion(rs.getString(2));
			q.setAnswerA(rs.getString(3));
			q.setAnswerB(rs.getString(4));
			q.setAnswerC(rs.getString(5));
			q.setAnswerD(rs.getString(6));
			q.setCorrectAnswer(rs.getString(7));

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Mamy jakis problem z sql, funkcja setQuestionOfQuery()");
		} finally {
			return q;
		}
	}
}
