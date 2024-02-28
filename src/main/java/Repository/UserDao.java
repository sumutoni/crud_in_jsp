package Repository;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;

import Model.User;
public class UserDao {
	public static int save(User u){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(u);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;

	}
	public static int update(User u){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Query query= session.createQuery("update User set name=:name, password=:password, email=:email, sex=:sex, country=:country where id =: id");
			query.setParameter("name", u.getName());
			query.setParameter("id", u.getId());
			query.setParameter("password", u.getPassword());
			query.setParameter("email", u.getEmail());
			query.setParameter("country", u.getCountry());
			query.setParameter("sex", u.getSex());
			int rowCount = query.executeUpdate(); // Execute the update operation
			transaction.commit(); // Commit the transaction
			return rowCount; 
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;

	}
	public static int delete(User u){
		int rows;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Query query = session.createQuery("delete from User where id=:id");
		query.setParameter("id",u.getId());
		rows = query.executeUpdate();
		transaction.commit();
		return rows; 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}


	public static List<User> getAllRecords(){
		List<User> list=new ArrayList<User>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		Query<User> query = session.createQuery("FROM User", User.class);
		list = query.getResultList();
		transaction.commit();
			}catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				session.close();
			}

		return list;
	}
	public static User getRecordById(int id){
		User u=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Query<User> query = session.createQuery("FROM User WHERE id = :id", User.class);
			query.setParameter("id", id);
			u= (User) query.getSingleResult();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return u;
	}
}
