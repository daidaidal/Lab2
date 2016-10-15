package packagea;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import com.opensymphony.xwork2.Action;

public class Delete implements Action {

	private Book bookd;
	
	public Book getBookd() {
		return bookd;
	}

	public void setBookd(Book bookd) {
		this.bookd = bookd;
	}

	public String execute()  throws Exception  {
		
		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      ResultSet rst = null;
	      String sql="delete from book where isbn='"+bookd.getIsbn()+"'";
	      int count = 0;
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try { 
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
		        stmt=con.createStatement();  
	            int i=stmt.executeUpdate(sql);
	            if(i==0){
	                ret=ERROR;
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


