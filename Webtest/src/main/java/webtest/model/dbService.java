package webtest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dbService {
	

	    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu08";

	    private String username = "cs3220stu08";

	    private String password = "CXefNpX3Q3Dx";

	    private Connection connection;

	    public dbService()
	    {
	        try
	        {
	            connection = DriverManager.getConnection( url, username, password );
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
	    }

	    public void close()
	    {
	        if( connection != null )
	        {
	            try
	            {
	                connection.close();
	            }
	            catch( SQLException e )
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public List<Article> getSubmittedArticles(){
	    	List<Article> articles = new ArrayList<>();
	    	
	    	 try
	         {
	    		 String sql = "SELECT a.id, title, excerpt, content, authorName, time_Submitted, time_published, c.name FROM articles2 AS a, categories AS c WHERE a.category_id = c.id AND time_submitted IS NOT NULL GROUP BY a.id";
	    		 PreparedStatement pstmt = connection.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery();
	             while( rs.next() )
	             {
	         
	                 
	                 String title = rs.getString( "title" );
	                 String excerpt = rs.getString( "excerpt" );
	                 String content = rs.getString("content");
	                 String category = rs.getString("name");
	                 String authorName = rs.getString("authorName");
	                 Date timeSubmitted = rs.getTimestamp("time_submitted");
	                 Date timePublished = rs.getTimestamp("time_published");
	                 Article entry = new Article(title, excerpt, category, content, authorName);
	                 entry.setId(rs.getInt( "id" ));
	                 entry.setTimeSubmitted(timeSubmitted);
	                 entry.setTimePublished(timePublished);
	                 articles.add( entry );
	             }
	             pstmt.close();
	         }
	         catch( SQLException e )
	         {
	             e.printStackTrace();
	         }

	         return articles;
	    }
	    
	    public List<Article> getPublishedAndAuthorArticles(String fullName){
	    	List<Article> articles = new ArrayList<>();
	    	try {
	    		String sql = "SELECT a.id, title, excerpt, content, time_Submitted, time_published, c.name FROM articles2 AS a, categories AS c\r\n"
	    				+ "   WHERE a.category_id = c.id AND (time_published IS NOT NULL OR authorName = ?)\r\n"
	    				+ "   GROUP BY a.id";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setString(1, fullName);
	    		ResultSet rs = pstmt.executeQuery();
	    		
	    		while( rs.next() ) {
	            	 String title = rs.getString( "title" );
	                 String excerpt = rs.getString( "excerpt" );
	                 String content = rs.getString("content");
	                 String category = rs.getString("name");
	                 Date timeSubmitted = rs.getTimestamp("time_submitted");
	                 Date timePublished = rs.getTimestamp("time_published");
	                 Article entry = new Article(title, excerpt, category, content, fullName);
	                 entry.setId(rs.getInt( "id" ));
	                 entry.setTimeSubmitted(timeSubmitted);
	                 entry.setTimePublished(timePublished);
	                 articles.add( entry );
	             }
	             
	             pstmt.close();
	    	}catch( SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return articles;
	    }
	    
	    public List<Article> getPublishedArticles() {
	    	List<Article> articles = new ArrayList<>();
	    	
	    	try {
	    		String sql = "SELECT a.id, title, excerpt, content, authorName, time_Submitted, time_published, c.name FROM articles2 AS a, categories AS c \r\n"
	    				+ "    WHERE a.category_id = c.id AND time_published IS NOT NULL\r\n"
	    				+ "    GROUP BY a.id";
	    		 PreparedStatement pstmt = connection.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery();
	             while( rs.next() ) {
	            	 String title = rs.getString( "title" );
	                 String excerpt = rs.getString( "excerpt" );
	                 String content = rs.getString("content");
	                 String category = rs.getString("name");
	                 String authorName = rs.getString("authorName");
	                 Date timeSubmitted = rs.getTimestamp("time_submitted");
	                 Date timePublished = rs.getTimestamp("time_published");
	                 Article entry = new Article(title, excerpt, category, content,authorName);
	                 entry.setId(rs.getInt( "id" ));
	                 entry.setTimeSubmitted(timeSubmitted);
	                 entry.setTimePublished(timePublished);
	                 articles.add( entry );
	             }
	             
	             pstmt.close();
	    		
	    	}catch( SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return articles;
	    }
	    
	    public Article getArticle(int id) {
	    	
	    	Article entry = new Article();
	    	try {
	    	String sql = "SELECT a.id, title, excerpt, content, time_Submitted, time_published, c.name FROM articles2 AS a, categories AS c WHERE a.category_id = c.id AND a.id = ?";
	    	PreparedStatement pstmt = connection.prepareStatement(sql);
	    	pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
	    	
			rs.next();
			entry.setTitle(rs.getString( "title" ));
            entry.setExcerpt(rs.getString( "excerpt" ));
            entry.setContent(rs.getString("content"));
            entry.setCategory(rs.getString("name"));
            entry.setId(id);
            
            pstmt.close();
           
	    	}
	    	 catch( SQLException e )
	         {
	             e.printStackTrace();
	         }
	    	 return entry;

	        
	    }
	    
	    public void editArticle(int id, String title, String content, String category, String excerpt) {
	    	try {
	    		String sql = "SELECT id FROM categories WHERE name = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setString(1, category);
	    		ResultSet rs = pstmt.executeQuery();
				rs.next();
				int categoryID = rs.getInt(1);
				pstmt.close();
				
				String sql2 = "UPDATE articles2 SET title = ?, excerpt = ?, content = ?, category_id = ? WHERE id = ?";
				PreparedStatement pstmt1 = connection.prepareStatement(sql2);
				pstmt1.setString(1, title);
				pstmt1.setString(2, excerpt);
				pstmt1.setString(3, content);
				pstmt1.setInt(4, categoryID);
				pstmt1.setInt(5, id);
				
				pstmt1.executeUpdate();
				pstmt1.close();
				
	    		
	    		
	    	}catch( SQLException e) {
	    		e.printStackTrace();
	    	}
	    	
	    }
	    
	    public List<String> getCategories(){
	    	List<String> categories = new ArrayList<>();
	    	
	    	try {
	    		String sql = "SELECT name FROM categories";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		ResultSet rs = pstmt.executeQuery();
	    		
	    		while(rs.next()) {
	    			categories.add(rs.getString(1));
	    			
	    		}
	    		
	    		pstmt.close();
	    	}
	    	catch( SQLException e) {
	    		 e.printStackTrace();
	    	}
	    	
	    	return categories;
	    }
	    
	    public void addArticle(String category, String title, String excerpt, String content, String authorName) {
	    	try {
	    		String sql = "SELECT id FROM categories WHERE name = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setString(1, category);
	    		ResultSet rs = pstmt.executeQuery();
				rs.next();
				int categoryID = rs.getInt(1);
				pstmt.close();
				
				String sql1 = "INSERT INTO articles2 (title, excerpt, content, authorName, category_id) VALUES (?,?,?,?,?)";
				PreparedStatement pstmt1 = connection.prepareStatement(sql1);
				pstmt1.setString(1, title);
				pstmt1.setString(2, excerpt);
				pstmt1.setString(3, content);
				pstmt1.setString(4, authorName);
				pstmt1.setInt(5, categoryID);
				
				pstmt1.executeUpdate();
				pstmt1.close();
				
				
				
				
	    		
	    	}catch( SQLException e) {
	    		 e.printStackTrace();
	    	}
	    }
	    
	    public User logIn(String userName, String password) {
	    	User loggedIn = new User();
	    	try {
	    		String sql = "SELECT userName, fullName, role FROM users2 WHERE userName = ? AND password = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setString(1, userName);
	    		pstmt.setString(2, password);
	    		ResultSet rs = pstmt.executeQuery();
	    		while(rs.next()) {
	    			loggedIn.setUserName(rs.getString(1));
	    			loggedIn.setFullName(rs.getString(2));
	    			loggedIn.setRole(rs.getString(3));
	    			}
	    		pstmt.close();
	    	}catch(SQLException e ) {
	    		return null;
	    	}
	    	
	    	return loggedIn;
	    }
	    public int createUser(String userName, String password, String fullName, String role) {
	    	int id = 0;
	    	try {
	    		String sql2 = "SELECT userName FROM users2 WHERE userName = ?";
	    		PreparedStatement pstmt2 = connection.prepareStatement(sql2);
	    		pstmt2.setString(1, userName);
	    		ResultSet rs = pstmt2.executeQuery();
	    		if(rs.next()) {
	    			pstmt2.close();
	    			return -1;
	    			}
	    		
	    		
	    		else {
	    			String sql = "INSERT INTO users2 (userName, password, fullName, role) VALUES (?,?,?,?)";
	    			PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    			pstmt.setString(1, userName);
	    			pstmt.setString(2, password);
	    			pstmt.setString(3, fullName);
	    			pstmt.setString(4, role);
	    			pstmt.executeUpdate();
	    			
	    			ResultSet rs1 = pstmt.getGeneratedKeys();
		            if( rs1.next() ) id = rs1.getInt( 1 );
		            pstmt.close();
	    		}
	    		
	    	}catch( SQLException e) {
	    		e.printStackTrace();
	    		return -2;
	    	}
	    	
	    	return id;
	    }
	    public void publishArticle(int id) {
	    	try {
	    		String sql = "UPDATE articles2 SET time_published = NOW() WHERE id = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setInt(1, id);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		
	    		
	    	}catch( SQLException e) {
	    		 e.printStackTrace();
	    	}
	    }
	    
	    public void submitArticle(int id) {
	    	try {
	    		String sql = "UPDATE articles2 SET time_submitted = NOW() WHERE id = ?";
	    		PreparedStatement pstmt = connection.prepareStatement(sql);
	    		pstmt.setInt(1, id);
	    		pstmt.executeUpdate();
	    		pstmt.close();
	    		
	    		
	    	}catch( SQLException e) {
	    		 e.printStackTrace();
	    	}
	    }
}
