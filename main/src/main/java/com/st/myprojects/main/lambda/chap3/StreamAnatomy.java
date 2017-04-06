/**
 * 
 */
package com.st.myprojects.main.lambda.chap3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*-
 * @author sundeeptonse
 * 
 * 1.Starting Pipeline
 * 		Collection<T>.stream() 								| Stream<T>
 * 		Collection<T>.parallelStream() 						| Stream<T>
 * 		
 * 		Stream<T>.empty() 									| Stream<T>
 * 		Stream<T>.of(T) 									| Stream<T>
 * 		Stream<T>.of(T...) 									| Stream<T>
 * 
 * 2.Transforming Pipeline
 * 		a.Filtering
 * 			Stream<T>.filter(Predicate<T>)					| Stream<T>
 * 		b.Mapping
 * 			One to One
 * 				Stream<T>.map(Function<T,R>)  				| Stream<R>
 * 				Stream<T>.mapToInt(ToIntFunction<T>)  		| IntStream
 *				Stream<T>.mapToLong(ToLongFunction<T>)  	| LongStream
 *				Stream<T>.mapToDouble(ToDoubleFunction<T>)  | DoubleStream
 *
 * 			One to Many
 * 				Stream<T>.flatMap(Function<T,Stream<R>>)	| Stream<R>
 * 		c.Debugging
 * 				Stream<T>.peek								| Stream<T>
 * 		d.Sorting and De-duplicating
 * 				Stream<T>.sorted							| Stream<T>
 * 				Stream<T>.sorted(Comparator<T>)				| Stream<T>
 * 				distinct									| Stream<T>
 * 		e.Truncating
 * 				Stream<T>.skip(long)						| Stream<T>
 * 				Stream<T>.limit(long)						| Stream<T>
 * 		
 * 3.Ending Operations
 * 		These are eager vs above lazy
 * 		--> Starts the evaluation of the stream elements
 * 
 * 		a. Search Operations
 * 			i> First Group
 * 				Stream<T>.allMatch(Predicate<T>)			| boolean
 * 					allMatch on an empty stream will return true
 * 				Stream<T>.anyMatch(Predicate<T>)			| boolean
 * 				Stream<T>.noneMatch(Predicate<T>)			| boolean
 * 			ii> Second Group
 * 				Stream<T>.findFirst()						| Optional<T>
 * 				Stream<T>.findAny()							| Optional<T>
 * 
 * 		
 * 		b. Reductions --> count,max, collections
 * 				Variants of Stream<T>.reduce
 * 				IntStream.sum()								| int
 * 				IntStream.min()								| OptionalInt
 * 				IntStream.max()								| OptionalInt
 * 				IntStream.count()							| long
 * 				average()									| OptionalDouble
 * 				summaryStatistics							| IntSummaryStatistics
 * 				
 * 				Collecting Stream Elements:
 * 				Stream<T>.collect(Collector<T,A,R>)			| R
 * 
 * 				Collectors:
 * 				toSet()										| Collector<T,?, Set<T>>
 * 				toList()									| Collector<T,?, List<T>>
 * 				toMap<Fucntion<T,K>, Function<T, U>>		| Collector<T, ?, Map<K,U>>
 * 				toMap<Function<T,K>, Function<T, U>, BinaryOperator<U>> | Collector<T, ?, Map<K,U>>
 * 				
 * 			
 * 		c. Side-effecting operations 
 * 			Stream<T>.forEach(Consumer<T>)	void
 * 			-> not thread Safe, and used for parallel
 * 			Stream<T>.forEachOrdered(Consumer<T>)	void		
 * 
 * 
 * 		Class Optional
 * 			Optional<T>.get 								| T
 * 				--> UnSafe Avoid
 * 			ifPresent(Consumer<T>)							| void
 * 			isPresent()										| boolean
 * 			orElse(T)										| T
 * 			orElseGet(Supplier<T>)							| T
 * 
 * 		
 * 
 *
 */
public class StreamAnatomy {

	public static void main(String... args) {
		List<Book> library = getLibrary();
		System.out.println("Lib:" + library);

		pipelineTransformation(library);
		// Ending Operations
		pipelineEnding(library);
	}

	public static void pipelineEnding(List<Book> library) {
		System.out.println("---------pipelineEnding---------");

		boolean withinShelfHeight = library.stream()
				.filter(b -> b.getTopic() == Topic.HISTORY)
				.allMatch(b -> b.getHeight() < 19);

		Optional<Book> anyBook = library.stream()
				.filter(b -> b.getAuthors().contains("Tolkeing")).findAny();
		System.out.println(anyBook + ":" + anyBook.isPresent());

		try {
			Optional<BufferedReader> br = Optional
					.ofNullable(new BufferedReader(new FileReader(
							"Mastering.txt")));
			Optional<String> line = br.get().lines()
					.filter(s -> s.contains("test")).findFirst();
		} catch (FileNotFoundException e) {
		}

		IntSummaryStatistics stats = library.stream()
				.mapToInt(b -> IntStream.of(b.getPageCounts()).sum())
				.summaryStatistics();
		System.out.println("stats:" + stats);

		Map<String, Year> titleToPubdate = library.stream().collect(
				Collectors.toMap(Book::getTitle, Book::getPubDate));
		System.out.println("titleToPubdate" + titleToPubdate);

		// What if there are duplicate Titles.-> use the overload

		Map<String, Year> titleToPubdate2 = library.stream().collect(
				Collectors.toMap(Book::getTitle, Book::getPubDate,
						BinaryOperator.minBy(Comparator.naturalOrder())));

		// Or --> Takes BinaryOperator<U>, in this case is PubDate
		Map<String, Year> titleToPubdate3 = library.stream().collect(
				Collectors.toMap(Book::getTitle, Book::getPubDate,
						(x, y) -> x.isAfter(y) ? x : y));

		int totalPageCount = library.stream()
				.mapToInt(b -> IntStream.of(b.getPageCounts()).sum()).sum();
		System.out.println("TotalPageCount:" + totalPageCount);
		
		int totalPageCount2 = library.stream()
				.flatMapToInt(b -> IntStream.of(b.getPageCounts())).sum();
		System.out.println("totalPageCount2:" + totalPageCount);

	}

	public static void pipelineTransformation(List<Book> library) {

		System.out.println("---------pipelineTransformation---------");

		// Get Only computing books --> Peek gets called only on some ending
		// Operation
		Stream<Book> computingBooks = library.stream()
				.filter(b -> b.getTopic() == Topic.COMPUTING)
				.peek(System.out::println);

		System.out.println("ComputingBooks:" + computingBooks.count());

		// A Stream of Book Titles
		Stream<String> bookTitles = library.stream().map(b -> b.getTitle())
				.peek(System.out::println);
		System.out.println("BookTitles:" + bookTitles.count());

		// Sorted Stream of Authors, in order of desc book title with duplicate
		// removed
		// One to Many
		Stream<String> authors = library.stream()
				.sorted(Comparator.comparing(Book::getTitle).reversed())
				.flatMap(b -> b.getAuthors().stream()).distinct()
				.peek(System.out::println);

		System.out.println("authors:" + authors.count());

		// Stream yeilding the first 100 book in alphabetical order of title
		Stream<Book> readingList = library.stream()
				.sorted(Comparator.comparing(Book::getTitle)).limit(2)
				.peek(System.out::println);
		System.out.println("readingList:" + readingList.count());

		// A Stream with the rest
		Stream<Book> readingListRest = library.stream()
				.sorted(Comparator.comparing(Book::getTitle)).skip(2)
				.peek(System.out::println);
		System.out.println("readingListRest:" + readingListRest.count());

		// Earliest Published Book
		Optional<Book> oldest = library.stream().min(
				Comparator.comparing(Book::getPubDate));
		System.out.println("oldest:" + oldest);

		// Set of Titles of the books
		Set<String> titleSet = library.stream().map(Book::getTitle)
				.collect(Collectors.toSet());
		System.out.println("Set of Titles:" + titleSet);

		// To get total Number of Authors
		int sum = library.stream().mapToInt(b -> b.getAuthors().size()).sum();
		System.out.println("Sum:" + sum);

		// or
		// Convert to Flat Map of Authors
		long sum2 = library.stream().flatMap(b -> b.getAuthors().stream())
				.count();
		System.out.println("sum2:" + sum2);

		// Sum of all Page Counts
		long pageCountSum = library.stream()
				.flatMapToInt(b -> IntStream.of(b.getPageCounts())).sum();
		System.out.println("pageCountSum:" + pageCountSum);

		// Sorting
		// Natural Ordering - Reversed
		Stream<String> strings = library.stream().map(Book::getTitle)
				.sorted(Comparator.reverseOrder()).peek(System.out::println);
		System.out.println("strings:" + strings.count());

		Stream<Book> book = library.stream()
				.sorted(Comparator.comparing(Book::getTitle).reversed())
				.peek(System.out::println);
		System.out.println("book:" + book.count());

		// Using not natural Ordering - you can another comparator for that key,
		// i.e String::length
		// Or List::size
		Stream<Book> bookMultiple = library
				.stream()
				.sorted(Comparator.comparing(Book::getTitle,
						Comparator.comparing(String::length)).reversed())
				.peek(System.out::println);
		System.out.println("bookMultiple:" + bookMultiple.count());

		// Sort by Year, followed by Title length
		Stream<Book> bookMultiple2 = library.stream()
				.sorted(Comparator.comparing(Book::getTitle))
				.sorted(Comparator.comparing(Book::getPubDate))
				.peek(System.out::println);
		System.out.println("bookMultiple2:" + bookMultiple2.count());

	}

	public static List<Book> getLibrary() {
		List<Book> lib = new ArrayList<>();
		Book book = new Book("Fundamentals of Chinese FingerNail Image",
				Arrays.asList("Li", "Fu", "Li"), new int[] { 256 },
				Year.of(2014), 25.2, Topic.FICTION);
		lib.add(book);
		Book book2 = new Book("Compliers", Arrays.asList("Aho", "Lam", "Sethi",
				"Ullman"), new int[] { 1009 }, Year.of(2006), 23.6,
				Topic.COMPUTING);
		lib.add(book2);
		Book book3 = new Book("Voss", Arrays.asList("Practic White"),
				new int[] { 478 }, Year.of(1957), 19.8, Topic.FICTION);
		lib.add(book3);
		Book book4 = new Book("Lord of the Rings", Arrays.asList("Tolkeing"),
				new int[] { 531, 416, 624 }, Year.of(1955), 23.0, Topic.FICTION);
		lib.add(book4);
		Book book5 = new Book("ABC", Arrays.asList("Tolkeing"),
				new int[] { 478 }, Year.of(1955), 19.8, Topic.FICTION);
		lib.add(book5);
		return lib;
	}
}

enum Topic {
	HISTORY, PROGRAMMING, FICTION, MEDICINE, COMPUTING;
}

class Book {
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
				+ ", pageCounts=" + Arrays.toString(pageCounts) + ", topic="
				+ topic + ", pubDate=" + pubDate + ", height=" + height + "]";
	}

}
