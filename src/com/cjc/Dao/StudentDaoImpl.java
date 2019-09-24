package com.cjc.Dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cjc.model.Student;









@Repository
public class StudentDaoImpl implements StudentDao{

	
	
	
	
	
 @Autowired
 public SessionFactory sessionFactory;
	Session session=null;

 public void setSessionFactory(SessionFactory sessionFactory){
     this.sessionFactory = sessionFactory;
  }





/*public class StudentDaoImpl implements StudentDao{
	@Autowired
	//@Qualifier("sessionfactory")
	private SessionFactory sessionfactory1;
	Session session=null;
	public void setSessionFactory(SessionFactory sessionfactory){
	     this.sessionfactory1 = sessionfactory;
	  }
	*/
	@Override
	public int registerdata(Student s) {
		session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		int id=(int) session.save(s);
		ts.commit();
		return id;
	}
	@Override
	public List<Student> loginCheck(String username, String password) {
		List<Student> list=null;
		if(username.equals("admin") && password.equals("admin")){
		String hql="from Student";
		session=sessionFactory.openSession();
		Query<Student> q=session.createQuery(hql);
		list=q.getResultList();
		System.out.println("list");
		return list;
		}
		else{
			String hql1="from Student where user name='"+username+"' and password= '"+password+"'";
			session=sessionFactory.openSession();
			Query<Student> q=session.createQuery(hql1);
			list=q.getResultList();
			System.out.println("Show list");
			return list;
		}
	}
	@Override
	public Student showData(int id) {
		session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Student s=session.get(Student.class, id);
		
		return null;
	}
}
