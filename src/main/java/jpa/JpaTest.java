package jpa;


import dao.KahootDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		Kahoot kahoot = test.createKahoot();
		KahootDAO kahootDAO = new KahootDAO(manager);
		kahootDAO.createKahoot(kahoot);
		System.out.println(".. done");
	}

	private Kahoot createKahoot(){
		Question question = new Question();
		User user = new User();
		user.setNom(null);
		user.setPrenom(null);
		user.setPseudo("pio");
		user.setCreated_quizzs(new ArrayList<>());
		user.setResponses_kahoot(new ArrayList<>());
		question.setQuestion("Question 1 ?");
		Response response1 = new Response();
		response1.setGood(false);
		response1.setResponse("responseA");

		Response response2 = new Response();
		response2.setGood(false);
		response2.setResponse("responseB");

		Response response3 = new Response();
		response3.setGood(true);
		response3.setResponse("responseC");

		Response response4 = new Response();
		response4.setGood(true);
		response4.setResponse("responseD");

		Quizz quizz = new Quizz();
		quizz.setName("Mon super quizz a une question");
		quizz.setQuestions(Arrays.asList(question));
		quizz.setTheme("Quizz 20 questions");
		question.setNrbReponses(2);
		question.setResponses(Arrays.asList(response1,response2,response3,response4));
		quizz.setQuestions(Arrays.asList(question));
		Kahoot kahoot = new Kahoot();
		kahoot.setPlayers(Arrays.asList(user));
		kahoot.setQuizz(quizz);
		kahoot.setPin(4444);
		kahoot.setStart_time(new Date());
		Date endDate = new Date();
		endDate.setTime(endDate.getTime() + 600000);
		kahoot.setEnd_time(endDate);
		kahoot.setTimer(15);
		return kahoot;
	}

}
