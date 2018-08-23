package co.grandcircus.coffeeshop;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.entity.Item;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<User> findAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findById(Integer id) {
		return em.find(User.class, id);
	}
	
	public void create(User user) {
		em.persist(user);
	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(Integer id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		User user = em.getReference(User.class, id); //just reference, not pulling from DB
		em.remove(user);
	}
	
}
