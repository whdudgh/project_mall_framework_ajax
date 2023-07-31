package ezen.shoppingmall.domain.board.dto;

public class Board {
	
	private int boardKey;
	private int custKey;
	private int pKey;
	private String title;
	private String bRdate;
	private String content;
	private int rate;
	
	public Board() {}

	public Board(int boardKey, int custKey, int pKey, String title, String bRdate, String content, int rate) {
		this.boardKey = boardKey;
		this.custKey = custKey;
		this.pKey = pKey;
		this.title = title;
		this.bRdate = bRdate;
		this.content = content;
		this.rate = rate;
	}

	public int getBoardKey() {
		return boardKey;
	}

	public void setBoardKey(int boardKey) {
		this.boardKey = boardKey;
	}

	public int getCustKey() {
		return custKey;
	}

	public void setCustKey(int custKey) {
		this.custKey = custKey;
	}

	public int getpKey() {
		return pKey;
	}

	public void setpKey(int pKey) {
		this.pKey = pKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getbRdate() {
		return bRdate;
	}

	public void setbRdate(String bRdate) {
		this.bRdate = bRdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Board [boardKey=" + boardKey + ", custKey=" + custKey + ", pKey=" + pKey + ", title=" + title
				+ ", bRdate=" + bRdate + ", content=" + content + ", rate=" + rate + "]";
	}

	

	
}
