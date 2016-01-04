package bean;

import java.util.ArrayList;

/**
 * 椤电璇︽儏椤垫暟鎹�
 * 
 * @author Kevin
 * 
 */
public class TabData {

	public int retcode;

	public TabDetail data;

	public class TabDetail {
		public String title;
		public String more;
		public ArrayList<TabNewsData> news;
		public ArrayList<TopNewsData> topnews;

		@Override
		public String toString() {
			return "TabDetail [title=" + title + ", news=" + news
					+ ", topnews=" + topnews + "]";
		}
	}

	/**
	 * 鏂伴椈鍒楄〃瀵硅薄
	 * 
	 * @author Kevin
	 * 
	 */
	public class TabNewsData {
		public String id;
		public String listimage;
		public String pubdate;
		public String title;
		public String type;
		public String url;

		@Override
		public String toString() {
			return "TabNewsData [title=" + title + "]";
		}
	}

	/**
	 * 澶存潯鏂伴椈
	 * 
	 * @author Kevin
	 * 
	 */
	public class TopNewsData {
		public String id;
		public String topimage;
		public String pubdate;
		public String title;
		public String type;
		public String url;

		@Override
		public String toString() {
			return "TopNewsData [title=" + title + "]";
		}
	}

	@Override
	public String toString() {
		return "TabData [data=" + data + "]";
	}

}
