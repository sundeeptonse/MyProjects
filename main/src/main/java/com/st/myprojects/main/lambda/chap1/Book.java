/**
 * 
 */
package com.st.myprojects.main.lambda.chap1;

import java.time.Year;
import java.util.Arrays;
import java.util.List;



/**
 * @author sundeeptonse
 *
 */
public class Book {
	String title;
	List<String> authors;
	// Page Counts of Multi volume books
	int[] pageCounts;
	Topic topic;
	Year pubDate;
	double height;

	/**
	 * @param title
	 * @param authors
	 * @param pageCounts
	 * @param topic
	 * @param pubDate
	 * @param height
	 */
	public Book(String title, List<String> authors, int[] pageCounts,
			Year pubDate, double height, Topic topic) {
		super();
		this.title = title;
		this.authors = authors;
		this.pageCounts = pageCounts;
		this.topic = topic;
		this.pubDate = pubDate;
		this.height = height;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the authors
	 */
	public List<String> getAuthors() {
		return authors;
	}

	/**
	 * @return the pageCounts
	 */
	public int[] getPageCounts() {
		return pageCounts;
	}

	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * @return the pubDate
	 */
	public Year getPubDate() {
		return pubDate;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + authors
				+ ", pageCounts=" + Arrays.toString(pageCounts)
				+ ", topic=" + topic + ", pubDate=" + pubDate + ", height="
				+ height + "]";
	}

}
