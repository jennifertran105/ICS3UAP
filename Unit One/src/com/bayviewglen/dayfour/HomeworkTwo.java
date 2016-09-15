package com.bayviewglen.dayfour;

public class HomeworkTwo {

	public static void main(String[] args) {
		int questionsAnswered = 8;
		int totalQuestions = 10;
		int percentage = (int) ((questionsAnswered /(double) totalQuestions) * 100);
		
		System.out.println("If the student got " + questionsAnswered + "/" + totalQuestions + ", he or she got " + percentage + "%.");
		

	}

}