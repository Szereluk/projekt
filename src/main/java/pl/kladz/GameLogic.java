package pl.kladz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {

	static Question q;
	static int points = 0;
	private Scanner odczyt;
	private ArrayList<Integer> lista = new ArrayList<Integer>();

	// ponizsza funkcja bierze z bazy danych pytanie o numerze ID przekazanym w
	// argumencie
	// tworzy obiekt typu Question q i implementuje go danymi z bazy danych.

	public void getQuestionFromSQL(int argID) {
		ServiceQuery.setQuery("SELECT * FROM pytania WHERE id=" + argID);
		ConnectSQL.connectToSQL();
		try {
			ResultSet rs = ConnectSQL.stmt.executeQuery(ServiceQuery.getQuery());
			while (rs.next()) {
				q = ServiceQuery.setQuestionOfQuery(rs);
				ServiceQuery.viewQueryAnswer(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public boolean checkAnswer(String userAnswer) {
		if ((q.getCorrectAnswer()).equals(userAnswer))
			return true;
		else
			return false;
	}

	public void viewScore() {
		System.out.println("Twoj wynik : " + points + "/5");
	}

	public void questionToNull() {
		q = null;
	}

	public int randomInt() {
		Random r = new Random();
		boolean isFailure = true;
		int liczba;

		do {
			liczba = r.nextInt(20) + 1;
			if (!lista.contains(liczba)) {
				lista.add(liczba);
				isFailure = false;
			}
		} while (isFailure);
		return liczba;
	}

	public void play() {
		odczyt = new Scanner(System.in);
		for (int i = 1; i <= 5; i++) {
			getQuestionFromSQL(randomInt());
			System.out.println("\n twoja odpowiedz : ");
			String userAnswer = odczyt.nextLine();
			if (Validator.isAnswerValid(userAnswer)) {
				if (checkAnswer(userAnswer))
					points++;
				questionToNull();
			}
			else System.out.println("do wyboru odp: a,b,c,d... Pamietaj o tym przy następnym pytaniu.!");
		}
		viewScore();
	}
}
