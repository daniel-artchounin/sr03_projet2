package beans.trainee;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Attempt {
	private int id;
	private String topicName;
	private String questionnaireName;
	private int questionnaireId;
	private int score;
	private Timestamp begining;
	private Timestamp end;
	private int durationInSeconds;
	private double scoreDivByDurationTimes100;
	private ArrayList<Answer> attemptedAnswers;

    public Attempt(int id, String topicName, String questionnaireName, int score, Timestamp begining, Timestamp end, int durationInSeconds, double scoreDivByDurationTimes100){
        this.setId(id);
    	this.setTopicName(topicName);
        this.setQuestionnaireName(questionnaireName);
        this.setScore(score);
        this.setBegining(begining);
        this.setEnd(end);
        this.setDurationInSeconds(durationInSeconds);
        this.setScoreDivByDurationTimes100(scoreDivByDurationTimes100);
    }
    
    public Attempt(){
    	this.setId(0);
        this.topicName = null;
        this.questionnaireName = null;
        this.score = 0;
        this.begining = new Timestamp(new Date().getTime());
        this.end = new Timestamp(new Date().getTime());
        this.durationInSeconds = 0;
        this.scoreDivByDurationTimes100 = 0.0;
        this.setAttemptedAnswers(new ArrayList<Answer>());
    }
    
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getQuestionnaireName() {
		return questionnaireName;
	}
	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void increaseScore(){
		this.score += 1;
	}
	public void decreaseScore(){
		this.score -= 1;
	}
	public String getBegining() {
		String formattedAccountCreation = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.begining);
		return formattedAccountCreation;
	}
	public void setBegining(Timestamp begining) {
		this.begining = begining;
	}
	public String getBeginingSql() {
		String formattedAccountCreation = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.end);
		return formattedAccountCreation;
	}
	public String getEndSql() {
		String formattedAccountCreation = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.end);
		return formattedAccountCreation;
	}
	public String getEnd() {
		String formattedAccountCreation = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.end);
		return formattedAccountCreation;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public int getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}
	public void setDurationInSeconds() {
		Duration duration = Duration.between(this.begining.toLocalDateTime(), this.end.toLocalDateTime()) ;
		this.durationInSeconds = (int) duration.getSeconds();
	}
	public double getScoreDivByDurationTimes100() {
		return (double)Math.round(scoreDivByDurationTimes100 * 1000d) / 1000d;
	}
	public void setScoreDivByDurationTimes100(double scoreDivByDurationTimes100) {
		this.scoreDivByDurationTimes100 = scoreDivByDurationTimes100;
	}

	public ArrayList<Answer> getAttemptedAnswers() {
		return attemptedAnswers;
	}

	public void setAttemptedAnswers(ArrayList<Answer> attemptedAnswers) {
		this.attemptedAnswers = attemptedAnswers;
	}
	
	//To delete doublon
	public void setAnswersUnique() { 
		Set<Answer> hs = new HashSet<>();
		hs.addAll(this.attemptedAnswers);
		this.attemptedAnswers.clear();
		this.attemptedAnswers.addAll(hs);		
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	
	public Map<String, Answer> compareAnswer(Question q){
		Map<String, Answer> answerList = new HashMap<String, Answer>();
		ArrayList<Answer> answers = q.getAnswers();
		
		for(Answer attemptedAnswer : this.attemptedAnswers){
			if(attemptedAnswer.getQuestionId() == q.getId()){
				if(attemptedAnswer.getClass() == GoodAnswer.class){
					answerList.put("trueAnswer", attemptedAnswer);
				}
				else{
					answerList.put("zfalseAnswer", attemptedAnswer);
					for(Answer answer : answers){
						if(answer.getClass() == GoodAnswer.class){
							answerList.put("answerGood", answer);
							break;
						}
					}
				}
				break;
			}
		}
		return answerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
