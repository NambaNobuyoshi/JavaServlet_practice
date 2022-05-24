package practice02;

/**メモの中身を持つオブジェクト DTO
 * @author nanba
 * */
public class Memo {
	
	/*メモのID*/
	private int id;
	/*メモのタイトル*/
	private String title;
	/*メモの中身*/
	private String content;
	
	/*getter およびsetter*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
