package packagea;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

public class ShowAll implements Action {
	private List<Book> aa = new ArrayList<>();
	private List<Author> bb = new ArrayList<>();
	
	
	public List<Book> getAa() {
		return aa;
	}
	public void setAa(List<Book> aa) {
		this.aa = aa;
	}
	public List<Author> getBb() {
		return bb;
	}
	public void setBb(List<Author> bb) {
		this.bb = bb;
	}
	public String Showauthor() throws Exception{
		
		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rst = null;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{   
	    	  //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "daidai");
	          con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          rst = stmt.executeQuery("select * from author");
	        	  while(rst.next())
	        	  {
	        		  String namel = rst.getString("name");
		              String countryl = rst.getString("country");
		              String authoridll = rst.getString("authorid");
		              int agel = rst.getInt("age");
		           	
		              Author authorl = new Author();
		              authorl.setName(namel);
		              authorl.setCountry(countryl);
		              authorl.setAuthorid(authoridll);
		              authorl.setAge(agel);
		              bb.add(authorl);
	        	  }

	        	  

	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
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
	        
	
	return ret;
	}
		
	public String execute() throws Exception {
		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rst = null;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{   
	    	  //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "daidai");
	          con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          rst = stmt.executeQuery("select * from book");
	        	  while(rst.next())
	        	  {
	        		  String titlell = rst.getString("title");
		              //authorids
		              String isbnl = rst.getString("isbn");
		              String authoridl = rst.getString("authorid");
		              String publisherl = rst.getString("publisher");
		              Date publishdatel =rst.getDate("publishdate");
		              int pricel =rst.getInt("price");
		           	
		              Book bookl = new Book();
		              bookl.setTitle(titlell);
		              bookl.setIsbn(isbnl);
		              bookl.setAuthorid(authoridl);
		              bookl.setPublisher(publisherl);
		              bookl.setPublishdate(publishdatel);
		              bookl.setPrice(pricel);
		              aa.add(bookl);
	        	  }

	        	  

	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
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
	        
	
	return ret;
	}

}
