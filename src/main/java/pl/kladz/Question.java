package pl.kladz;

public class Question {
	private String question, answerA, answerB, answerC, answerD, correctAnswer;

	public Question(String q, String a, String b, String c, String d, String correct) {
		setQuestion(q);
		setAnswerA(a);
		setAnswerB(b);
		setAnswerC(c);
		setAnswerD(d);
		setCorrectAnswer(correct);
	}

	public Question() {

	}

	public String toString() {
		return getQuestion() + "\n" + getAnswerA() + "\n" + getAnswerB() + "\n" + getAnswerC() + "\n" + getAnswerD()
				+ "\n" + getCorrectAnswer();
	}

	public void setQuestion(String argQuestion) {
		question = argQuestion;
	}

	public void setAnswerA(String argAnswerA) {
		answerA = argAnswerA;
	}

	public void setAnswerB(String argAnswerB) {
		answerB = argAnswerB;
	}

	public void setAnswerC(String argAnswerC) {
		answerC = argAnswerC;
	}

	public void setAnswerD(String argAnswerD) {
		answerD = argAnswerD;
	}

	public void setCorrectAnswer(String argCorrectAnswer) {
		correctAnswer = argCorrectAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
