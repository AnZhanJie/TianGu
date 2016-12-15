package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class BaseDao {
	private static Configuration cfg;
	private static SessionFactory sf;
	private static ThreadLocal<Session> threadLocal;
	static{
		cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		threadLocal = new ThreadLocal<Session>();
	}
	
	public Session getSession(){

		Session session = null;
		session = threadLocal.get();
		if(session == null){
			session = sf.openSession();
			threadLocal.set(session);
		}
		return session;

		//return sf.openSession();
	}
	
	public Session getSession1(){

		return sf.openSession();
	}
	
	public void closeSession(Session session){
		if(session!=null){
			session.close() ;
			threadLocal.set(null);
		}
	}
}
