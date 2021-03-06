package dao.super_user;

import java.util.List;

import beans.trainee.Topic;
import dao.DaoException;

public interface TopicsManagementDao {
	List<Topic> getTopics() throws DaoException;
	void addTopic(String newTopicName) throws DaoException;
	void addQuestionnaire(String topicName, String questionnaireName) throws DaoException;
	void activateQuestionnaire(String topicName, String questionnaireName) throws DaoException;
	void deleteTopic(String topicName) throws DaoException;
	void deleteQuestionnaire(String topicName, String questionnaireName) throws DaoException;
	void updateTopic(String oldTopicName, String newTopicName) throws DaoException;
	void updateQuestionnaire(String topicName, String oldQuestionnaireName, String newQuestionnaireName) throws DaoException;
}