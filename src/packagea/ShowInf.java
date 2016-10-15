package packagea;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import com.opensymphony.xwork2.Action;

public class ShowInf implements Action {
	private Book books;
	private Author authors = new Author();
	
	public Author getAuthors() {
		return authors;
	}

	public void setAuthors(Author authors) {
		this.authors = authors;
	}

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	public String execute()  throws Exception  {
		
		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSet rst = null;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{     
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          
	          rs = stmt.executeQuery("select * from book where isbn = '"+ books.getIsbn() + "'");
	          
			  //ResultSet rst = stmt.executeQuery("select * from book where authorid='"+ rs.getString("authorid") + "'");
	          if(rs.next())
			  {
	        	  String authoridll = rs.getString("authorid");
	        	  books.setAuthorid(authoridll);
	              books.setTitle(rs.getString("title"));
                  books.setPublishdate(rs.getDate("publishdate"));
                  books.setPrice(rs.getInt("price"));
	              books.setPublisher(rs.getString("publisher"));
	              
	        	  rst = stmt.executeQuery("select * from author where authorid='"+authoridll + "'");
	        	  if(rst.next())
	        	  {
	        		  authors.setAge(rst.getInt("age"));
			          authors.setAuthorid(authoridll);
			          authors.setCountry(rst.getString("country"));
			          authors.setName(rst.getString("name"));
	        	  }
			  }

	        }catch (SQLException e) {
	            // TODO Auto-generated catch block
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


