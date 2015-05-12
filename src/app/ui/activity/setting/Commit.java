package app.ui.activity.setting;


import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

public class Commit extends BmobObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;	
	
	private User author;
	
	private BmobRelation comment;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public BmobRelation getComment() {
		return comment;
	}
	public void setComment(BmobRelation comment) {
		this.comment = comment;
	}
}
