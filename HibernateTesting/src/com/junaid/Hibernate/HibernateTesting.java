package com.junaid.Hibernate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateTesting

{	

	public static void main(String[] args) {
	   
		  //addUser();
		//showAllUsers();
	//	addUser();
		 // loadUser(2);
		List<UserBean> users  = getUser(null);
		
		
		for(UserBean user : users) { 
			
			
			System.out.println(user.getUsername());
		}
		  
		
	  }

	
//Show me all users wuth username staring with A , followed by anthing
	public static List<UserBean> getUser(String name) { 
		 SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
		 Session   session =sessionFactory.openSession();
	      
		Criteria criteria = session.createCriteria(UserBean.class)
				   .add(Restrictions.like("username", "A%")).add(Restrictions.like("password", "H%"));
		   
		      List<UserBean> userbeans = (List<UserBean>) criteria.list();
		      return userbeans;
		
	
		
	}
	
	
	  /**
	   * 
	   * @param i
	   */
	private static void loadUser(int i) {
		  Session session = null;

		    try {
		    	// SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		       SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
		      session =sessionFactory.openSession();
		        // How to load the Objects 
		        UserBean userBean = (UserBean) session.load(UserBean.class, 6);
		        System.out.println(userBean.getId()+ " " + userBean.getPassword()+ " " +userBean.getUsername());
		       }
		     catch(Exception e){
		      System.out.println(e.getMessage());
		    }finally{
		      // Actual contact insertion will happen at this step
		      session.flush();
		      session.close();

		      }
		    

		    
		    
		    
		
		
		

		
		
	}

	
	
	
	
	
	
	/**
	 * 
	 */
	private static void showAllUsers() {
	
		
		 Session session = null;

		    try {
		    	// SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		       SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
		      session =sessionFactory.openSession();
		     
		        //how to Load All Objects 
		        
		        Query result = session.createQuery("from UserBean");
		        
		         List<UserBean>  userbeanList= result.list();
		       
		         
		        
		        
		         for (UserBean usr : userbeanList) { 
		        	 System.out.println(usr.getId());
		        	 System.out.println(usr.getUsername());
		        	 System.out.println(usr.getPassword());
		         }
		         
		    }
		    
		    
		    catch(Exception e){
		      System.out.println(e.getMessage());
		    }finally{
		      // Actual contact insertion will happen at this step
		      session.flush();
		      session.close();

		      }
		    

		
	
	}

	/**
	 * 
	 */
	private static void addUser() {

		  Session session = null;

		    try {
		    	SessionFactory sessionFactory=HibernateSessionFactory.getSessionFactory();
		      session =sessionFactory.openSession();
		       org.hibernate.Transaction sinanTx = 
		    	   session.beginTransaction();
		         System.out.println("Inserting Record");
		        UserBean HB = new UserBean();
		        HB.setUsername("Shehriyer");
		        HB.setPassword("J2ee Trainee");
		        session.save(HB);	 
		        sinanTx.commit();
		        System.out.println("Done");
		        
		     }
		    
		    
		    catch(Exception e){
		      System.out.println(e.getMessage());
		    }finally{
		      // Actual contact insertion will happen at this step
		      session.flush();
		      session.close();

		      }
		    

		
		
		
	}
	  
	  
	  
	  
	} 
	

