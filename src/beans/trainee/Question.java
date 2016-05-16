package beans.trainee;

import java.util.ArrayList;

public class Question {	
	private String value;
	private int orderNumber;
	private boolean active;
	private ArrayList<Answer> answers;
	private boolean activable;
	private boolean deletable;
	private int questionnaireId;
	
	public Question(String value, int orderNumber, boolean active, ArrayList<Answer> answers, boolean activable, boolean deletable, int questionnaireId){
		this.setValue(value);
		this.setOrderNumber(orderNumber);
		this.setActive(active);
		this.setAnswers(answers);
		this.setActivable(activable);
		this.setDeletable(deletable);
		this.setQuestionnaireId(questionnaireId);
	}
	
	public Question(String value, int orderNumber, boolean active, boolean activable, boolean deletable, int questionnaireId){
		this.setValue(value);
		this.setOrderNumber(orderNumber);
		this.setActive(active);
		this.answers = new ArrayList<Answer>();
		this.setActivable(activable);
		this.setDeletable(deletable);
		this.setQuestionnaireId(questionnaireId);
	}
	
	public Question(){
		this.value = null;
		this.orderNumber = 0;
		this.active = false;
		this.answers = new ArrayList<Answer>();
		this.activable = false;
		this.deletable = false;
		this.questionnaireId = 0;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	public boolean isActivable() {
		return activable;
	}
	public void setActivable(boolean activable) {
		this.activable = activable;
	}
	public boolean isDeletable() {
		return deletable;
	}
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}
	public int getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
}
