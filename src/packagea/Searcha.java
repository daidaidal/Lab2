package packagea;

import com.opensymphony.xwork2.Action;
//import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Searcha implements Action {
	//author and book 直接被获取
	private Author authora;
	private Book booka;
	private List<Book> a = new ArrayList<>();
	private List<Author> b = new ArrayList<>();
	private String test;
	
	             
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<Author> getB() {
		return b;
	}

	public void setB(List<Author> b) {
		this.b = b;
	}

	public List<Book> getA() {
		return a;
	}

	public void setA(List<Book> a) {
		this.a = a;
	}

	public Author getAuthora() {
		return authora;
	}

	public void setAuthora(Author authora) {
		this.authora = authora;
	}


	public Book getBooka() {
		return booka;
	}


	public void setBooka(Book booka) {
		this.booka = booka;
	}
	public String ShowInf()
	{
		String ret = ERROR;
		
		return SUCCESS;
	}
	public String execute()  throws Exception {
		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSet rst = null;
	      int count = 0;
	      int count2 = 0;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{   
	    	  //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "daidai");
	          con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          
	          rs = stmt.executeQuery("select * from author where name = '"+ authora.getName() + "'");
	          
			  //ResultSet rst = stmt.executeQuery("select * from book where authorid='"+ rs.getString("authorid") + "'");
	          if(rs.next())
			  {
	        	  count++;
	        	  String authoridll = rs.getString("authorid");
	        	  rst = stmt.executeQuery("select * from book where authorid='"+authoridll + "'");
	        	  while(rst.next())
	        	  {
	        		  count++;
	        		  String titlell = rst.getString("title");
		              //authorids
		              String isbnl = rst.getString("isbn");
		           	
		              Book bookl = new Book();
		              bookl.setTitle(titlell);
		              bookl.setIsbn(isbnl);
		              a.add(bookl);
	        	  }
			  }
	          else
	        	  
	          if(count==0)
	        	  test = "sorry,the author you search is not exist";
	          if(count==1)
	        	  test = "sorry,the author you search has no book in library";

	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	test = "SQL ERROR!";
	            e.printStackTrace();
	        }finally{
	            try{
	            	/*if(rs!=null)
	            		rs.close();
	            	if(rst!=null)
	            		rst.close();*/
	            	if(stmt!=null)
	            		stmt.close();
	            	if(con!=null)           
	                    con.close();
	            	
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            
	            
	                
	            }
	        
	
	return ret;
}
}

