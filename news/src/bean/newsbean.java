package bean;

import java.util.ArrayList;

public class newsbean {

	//�ֶ����ֱ���ͷ��������ص��ֶ���һ��, ����gson����
	public	int retcode;
	public	ArrayList<slidingnews> data;

	public int getRetcode() {
		return retcode;
	}

	public void setRetcode(int retcode) {
		this.retcode = retcode;
	}

	public ArrayList<slidingnews> getData() {
		return data;
	}

	public void setData(ArrayList<slidingnews> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "newsbean [slidingnews=" + data + "]";
	}

	public class slidingnews {

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public ArrayList<tabnews> getChildren() {
			return children;
		}

		public void setChildren(ArrayList<tabnews> children) {
			this.children = children;
		}

		public	String id;
		public	String title;
		public	int type;
		public	String url;
		public	ArrayList<tabnews> children;

		@Override
		public String toString() {
			return "slidingnews [title=" + title + ", tabnews=" + children + "]";
		}

	}

	public class tabnews {

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public	String id;
		public	String title;
		public	int type;
		public	String url;

		@Override
		public String toString() {
			return "tabnews [title=" + title + "]";
		}

	}

}
