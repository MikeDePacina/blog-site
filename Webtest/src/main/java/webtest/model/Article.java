package webtest.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.ZoneId;
public class Article {
	private int id;
	private String title;
	private String excerpt;
	private String category;
	private Date timeSubmitted;
	private boolean isPublished;
	private Date timePublished;
	private String content;
	private String authorName;
	
	
	public Article() {
	
		
	}
	 public Article(String title, String excerpt, String category, String content, String authorName) {
		this.title = title;
		this.excerpt = excerpt;
		this.category = category;
		this.setPublished(false);
		this.timeSubmitted = null;
		this.timePublished = null;
		this.setContent(content);
		this.id = id;
		this.authorName = authorName;
		
	}
	
	 public int getId() {
		 return id;
	 }
	
	public Date getTimeSubmitted() {
		return timeSubmitted;
	}
	public void setTimeSubmitted(Date timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isPublished() {
		return isPublished;
	}


	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
		if(isPublished == true) {
			LocalDateTime dateTime = LocalDateTime.now();
		    Instant i = dateTime.atZone(ZoneId.systemDefault()).toInstant();
		    setTimePublished(Date.from(i));
		} 
	}


	public Date getTimePublished() {
		return timePublished;
	}


	public void setTimePublished(Date timePublished) {
		this.timePublished = timePublished;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(int id) {
		this.id = id;
		
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
}
