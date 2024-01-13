package spring_mvc.login.daoImpl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring_mvc.login.model.User;

@Repository
public class UserDaoImpl {

	EntityManagerFactory entityManagerFactory=
			Persistence.createEntityManagerFactory("teja");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public String saveUser(User user) {
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user.getName()+" saved";
	}
	
	public ArrayList<User> getAllUsers(){
		
		Query createQuery = entityManager.createQuery("select u from user u");
		
		return (ArrayList<User>) createQuery.getResultList();
	}
}
