package servlets.super_user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOConfigurationException;
import dao.DaoException;
import dao.DaoFactory;
import dao.super_user.QuestionsManagementDao;

public class QuestionsManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String QUESTIONNAIRES_MANAGEMENT_JSP = "/super_user/questionnaires_management.jsp";   
	private static final String ANSWER_JSP = "/super_user/answer.jsp";
	
    private QuestionsManagementDao questionnairesManagementDao;
	    
    public void init() throws ServletException {
        DaoFactory daoFactory;
		try {
			daoFactory = DaoFactory.getInstance();
			this.questionnairesManagementDao = daoFactory.getQuestionsManagementDao();
		} catch (DAOConfigurationException e) {
			e.printStackTrace();
		}        
    }
	
    public QuestionsManagement() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String topicName = request.getParameter("topic_name");
		String questionnaireName = request.getParameter("questionnaire_name");
		String errorMessage = null;
		int questionnaireId = 0;
		int questionOrderNumber = 0;
		int questionId = 0;
		int answerOrderNumber = 0;
		String action =  request.getParameter("action");
		request.setAttribute("topicName", topicName);
		request.setAttribute("questionnaireName", questionnaireName);
		if(action != null){
			switch (action) {
			case "delete_question":
				// System.out.println("Supprimer une question"); // Test
				questionnaireId = Integer.parseInt(request.getParameter("questionnaire_id"));
				questionOrderNumber = Integer.parseInt(request.getParameter("question_order_number"));
				try {
					this.questionnairesManagementDao.deleteQuestion(questionnaireId, questionOrderNumber);
				} catch (DaoException e) {
					errorMessage = e.getMessage();
					// System.out.println(errorMessage); // Test
					request.setAttribute("errorMessage", errorMessage);
				}
				break;
			case "activate_question":
				// System.out.println("Activer une question"); // Test
				questionnaireId = Integer.parseInt(request.getParameter("questionnaire_id"));
				questionOrderNumber = Integer.parseInt(request.getParameter("question_order_number"));
				try {
					this.questionnairesManagementDao.activateQuestion(questionnaireId, questionOrderNumber);
				} catch (DaoException e) {
					errorMessage = e.getMessage();
					// System.out.println(errorMessage); // Test
					request.setAttribute("errorMessage", errorMessage);
				}				
				break;
			case "delete_answer":
				// System.out.println("Supprimer une réponse"); // Test
				questionId = Integer.parseInt(request.getParameter("question_id"));
				answerOrderNumber = Integer.parseInt(request.getParameter("answer_order_number"));
				try {
					this.questionnairesManagementDao.deleteAnswer(questionId, answerOrderNumber);
				} catch (DaoException e) {
					errorMessage = e.getMessage();
					// System.out.println(errorMessage); // Test
					request.setAttribute("errorMessage", errorMessage);
				}
				break;
			case "activate_answer":
				// System.out.println("Activer une réponse"); // Test
				questionId = Integer.parseInt(request.getParameter("question_id"));
				answerOrderNumber = Integer.parseInt(request.getParameter("answer_order_number"));
				try {
					this.questionnairesManagementDao.activateAnswer(questionId, answerOrderNumber);
				} catch (DaoException e) {
					errorMessage = e.getMessage();
					// System.out.println(errorMessage); // Test
					request.setAttribute("errorMessage", errorMessage);
				}
				break;
			case "add_answer":		
				System.out.println("Ajouter une réponse"); // Test
				questionId = Integer.parseInt(request.getParameter("question_id"));
				request.setAttribute("questionId", questionId);
				this.getServletContext().getRequestDispatcher(ANSWER_JSP).forward(request, response);				
			default:
				break;
			}
		}
		if(action == null || !action.equals("add_answer")){
			try {
				request.setAttribute("questionnaire", this.questionnairesManagementDao.getQuestionnaire(topicName, questionnaireName));
			} catch (DaoException e) {
				errorMessage = e.getMessage();
				request.setAttribute("errorMessage", errorMessage);
			}		
			this.getServletContext().getRequestDispatcher(QUESTIONNAIRES_MANAGEMENT_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String newAnswerValue = null;
		String errorMessage = null;
		int questionId = 0;
		String action =  request.getParameter("paction");
		if(action != null){
			switch (action) {
			case "add_answer":
				System.out.println("Ajouter une réponse"); // Test
				questionId = Integer.parseInt(request.getParameter("question_id"));
				newAnswerValue = request.getParameter("answserValue");
				System.out.println(newAnswerValue);
				try {
					this.questionnairesManagementDao.addAnswer(questionId, newAnswerValue);
				} catch (DaoException e) {
					errorMessage = e.getMessage();
					request.setAttribute("errorMessage", errorMessage);
				}
				break;
			case "add_question":
				System.out.println("Ajouter une question"); // Test
				break;				
			default:
				break;
			}
		}
		doGet(request, response);
	}

}