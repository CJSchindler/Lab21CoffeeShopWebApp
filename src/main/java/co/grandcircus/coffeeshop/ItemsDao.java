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
public class ItemsDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Item> findAll() {
		return em.createQuery("FROM Item", Item.class).getResultList();
	}
	
	public Item findById(Integer id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> findByKeyword(String keyword) {
		// HQL queries can have named parameters, such as :regex here.
		return em.createQuery("FROM items WHERE LOWER(name) LIKE :regex", Item.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	public List<Item> findByCategory(String category) {
		return em.createQuery("FROM items WHERE LOWER(category) = :category", Item.class)
				.setParameter("category", category.toLowerCase())
				.getResultList();
	}
	
	public void create(Item item) {
		em.persist(item);
	}
	
	public void update(Item item) {
		em.merge(item);
	}
	
	public void delete(Integer id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Item item = em.getReference(Item.class, id); //just reference, not pulling from DB
		em.remove(item);
	}
	
	public Set<String> findAllCategories() {
		// This query returns a list of Strings, so I give it String.class
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM Items", String.class)
				.getResultList();
		// Convert the List to a Set.
		return new TreeSet<>(categoryList);
	}
	
}
