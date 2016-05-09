package dao.super_user;

import java.util.List;

import beans.super_user.SuperUser;
import beans.trainee.Trainee;
import dao.DaoException;

public interface UsersManagementDao {
    List<SuperUser> getSuperUsers(SuperUser superUser) throws DaoException;
    List<Trainee> getTrainees() throws DaoException;
    void dropTrainee(String email) throws DaoException;
    void dropSuperSuper(String email) throws DaoException;
}