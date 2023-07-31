package ezen.shoppingmall.domain.comment.dto;

public class Comment {
	
	private int boardKey;
	private String content;
	private String cRdate;
	
	public Comment() {}

	public Comment(int boardKey, String content, String cRdate) {
		this.boardKey = boardKey;
		this.content = content;
		this.cRdate = cRdate;
	}

	public int getBoardKey() {
		return boardKey;
	}

	public void setBoardKey(int boardKey) {
		this.boardKey = boardKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getcRdate() {
		return cRdate;
	}

	public void setcRdate(String cRdate) {
		this.cRdate = cRdate;
	}

	@Override
	public String toString() {
		return "Comment [boardKey=" + boardKey + ", content=" + content + ", cRdate=" + cRdate + "]";
	}
	
	

}
