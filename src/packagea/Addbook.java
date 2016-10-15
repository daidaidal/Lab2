package packagea;

import com.opensymphony.xwork2.Action;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Addbook implements Action {
	private String checkl = "add author";
	private Book bookadd;
	private Author authoradd;
	private Author authoraddl;
	private String m;
	private String m1;
	private String showauthorid;
	

	
	public String getM1() {
		return m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	public String getShowauthorid() {
		return showauthorid;
	}

	public void setShowauthorid(String showauthorid) {
		this.showauthorid = showauthorid;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public Author getAuthoraddl() {
		return authoraddl;
	}

	public void setAuthoraddl(Author authoraddl) {
		this.authoraddl = authoraddl;
	}

	public String getCheckl() {
		return checkl;
	}

	public void setCheckl(String checkl) {
		this.checkl = checkl;
	}

	public Book getBookadd() {
		return bookadd;
	}

	public void setBookadd(Book bookadd) {
		this.bookadd = bookadd;
	}

	public Author getAuthoradd() {
		return authoradd;
	}

	public void setAuthoradd(Author authoradd) {
		this.authoradd = authoradd;
	}
	public String Jump()
	{
		return SUCCESS;
	}
	public String CheckAuthor()  throws Exception 
	{
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSet rst = null;
	      int count = 0;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{     
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          
	          rs = stmt.executeQuery("select * from author where name = '"+ authoradd.getName() + "'");
	          
			  //ResultSet rst = stmt.executeQuery("select * from book where authorid='"+ rs.getString("authorid") + "'");
	          if(rs.next())
	          {
	        	  count++;
	        	  showauthorid = rs.getString("authorid");
	          }
	          if(count==0)
	        	  checkl = "the author is not aisist,click here to add author";
	          else
	        	  checkl = "the author is in the library and it's authorid is :";
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            try{
	            	if(rs!=null)
	            		rs.close();
	            	if(stmt!=null)
	            		stmt.close();
	            	if(con!=null)           
	                    con.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }                           
	            }
	        
		return SUCCESS;
}
	public String Addauthor() throws  Exception 
	{
		  Connection con = null;
	      Statement stmt = null;
	      String sql = "insert into author(authorid,name,age,country) values('"+authoraddl.getAuthorid()+"','"+authoraddl.getName()+"',"+authoraddl.getAge()+",'"+authoraddl.getCountry()+"')";
	      int count = 0;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{    
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          
	          int i = stmt.executeUpdate(sql);
	          if(i!=0)
	        	  m = "add success!";
	          else
	        	  m = "add fail!";
	          	          
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	m = "SQL ERROR";
	            e.printStackTrace();
	        }finally{
	            try{
	            	if(stmt!=null)
	            		stmt.close();
	            	if(con!=null)           
	                    con.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }                           
	            }
	        
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		  Connection con = null;
	      Statement stmt = null;
	      String sql = "insert into book(isbn,title,authorid,publisher,publishdate,price) values('"+bookadd.getIsbn()+"','"+bookadd.getTitle()+"','"+bookadd.getAuthorid()+"','"+bookadd.getPublisher()+"','"+bookadd.getPublishdate()+"',"+bookadd.getPrice()+")";
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{    
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          
	          int i = stmt.executeUpdate(sql);
	          if(i!=0)
	        	  m1 = "add success!";
	          else
	        	  m1 = "add fail!";
	          	          
	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
	        	m1 = "SQL ERROR";
	            e.printStackTrace();
	        }finally{
	            try{
	            	if(stmt!=null)
	            		stmt.close();
	            	if(con!=null)           
	                    con.close();
	                } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }                           
	            }
	        
		return SUCCESS;
	}

}
