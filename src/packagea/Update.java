package packagea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.Action;

public class Update implements Action {
	private Book booku;
	private String checku;

	public String getChecku() {
		return checku;
	}
	public void setChecku(String checku) {
		this.checku = checku;
	}
	public Book getBooku() {
		return booku;
	}
	public void setBooku(Book booku) {
		this.booku = booku;
	}
	public String Jump()
	{
		return SUCCESS;
	}
	public String execute() throws Exception {

		  String ret = SUCCESS;
	      Connection con = null;
	      Statement stmt = null;
	      String sql = "update book set authorid='"+booku.getAuthorid()+"',"+"publisher='"+booku.getPublisher()+"',"+"publishdate='"+booku.getPublishdate()+"',"+"price="+booku.getPrice()+" where title='"+booku.getTitle()+"'";
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	      try{   
	    	  con=DriverManager.getConnection("jdbc:mysql://gwjxwpfynkqj.rds.sae.sina.com.cn:10588/bookdb", "daidaidal", "daidai");
	          stmt=con.createStatement();   
	          int i=stmt.executeUpdate(sql);
	          if(i==0)
	        	  checku = "the book you want to update is not exist";
	          else
	        	  checku = "update success!";
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
