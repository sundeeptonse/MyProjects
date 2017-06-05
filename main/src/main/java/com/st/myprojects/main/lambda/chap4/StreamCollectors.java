/**
 * 
 */
package com.st.myprojects.main.lambda.chap4;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.counting;

import java.time.Year;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.st.myprojects.main.lambda.chap1.Book;
import com.st.myprojects.main.lambda.chap1.Topic;
import com.st.myprojects.main.lambda.chap3.StreamAnatomy;

/*-
 * @author sundeeptonse
 * 
 * Using Collectors:
 * 		1) Stand-Alone Predefined Collectors
 * 			a) To Accumulate to Framework - Supplied Containers
 * 					 	toSet()		Collector<T, ?, Set<T>> 
 * 					 	toMap()		Collector<T, ?, Map<K,U>> 
 * 						joining()	Collector<CharSequence, ? , String>
 * 			b) To Accumulate to Custom Collections
 * 						toCollection(Supplier<C> collectionFactory)	Collector<T, ?, C> 
 * 			c) To Accumulate Elements into a classification map
 * 						groupingBy(Function<T,K>)	Collector<T,?, Map<K, List<T>>
 * 						partitioningBy(Predicate<T>) Collector<T,?, Map<Boolean, List<T>>
 * 
 * 		2) Composing Collectors
 * 						groupingBy(Function<T,K> classifier,
 Collector<T, A, D> downstream)	Collector<T, ?, Map<K, D>>
 * 						--> Allows to pass a downstream Collector to it, instead of get Value as List
 * 						--> The downstream collect receives and has to handle the entire stream element
 * 
 * 						mapping(Function<? super T, ? extends U> mapper,
 *                              Collector<? super U, A, R> downstream) Collector<T, ?, R> 
 *                              
 *		3) Chaining Pipelines
 *
 *
 * 
 */
public class StreamCollectors {
	private static List<Book> lib = StreamAnatomy.getLibrary();

	public static void main(String... args) {
		StandAloneCollectors.callAll();
		CollectorsExamples.composingCollectors();
		CollectorsExamples.chainingPipelines();
	}

	static class CollectorsExamples {
		private static void chainingPipelines() {

			// to get most Popular Topic
			Stream<Map.Entry<Topic, Long>> entries = lib.stream()
					.collect(groupingBy(Book::getTopic, counting())).entrySet()
					.stream();

			// Use the Stream of Entry Set to compare using ..
			// comparingByValue/Key
			Optional<Topic> mostPopularTopic = entries.max(
					Map.Entry.comparingByValue()).map(Map.Entry::getKey);

			// Summarizing
			Optional<Topic> mostPopularTopic2 = lib.stream()
					.collect(groupingBy(Book::getTopic, counting())).entrySet()
					.stream().max(Map.Entry.comparingByValue())
					.map(Map.Entry::getKey);

			// Problems like Sorted we need to collect the entire contetnts
			// before proceeding.
			// Similar to the entrySet + Stream
			// Benefits lost ?

			// What if there are multiple topics
			// We should get a Optional<Set<Topic>>

			Optional<Set<Topic>> mostPopularTopics = lib
					.stream()
					.collect(groupingBy(Book::getTopic, counting()))
					.entrySet()
					.stream()
					.collect(
							groupingBy(Map.Entry::getValue,
									mapping(Map.Entry::getKey, toSet())))									
					.entrySet().stream().max(Map.Entry.comparingByKey())
					.map(Map.Entry::getValue);

		}

		private static void composingCollectors() {

			Map<Topic, List<Book>> booksByTopic = lib.stream().collect(
					groupingBy(Book::getTopic));

			// This is equiv to
			Map<Topic, List<Book>> booksByTopic2 = lib.stream().collect(
					groupingBy(Book::getTopic, Collectors.toList()));

			// Get Book Counts by Topic --> Using Counting
			Map<Topic, Long> countsOfTopics = lib.stream().collect(
					groupingBy(Book::getTopic, Collectors.counting()));
			System.out.println("countsOfTopics:" + countsOfTopics);

			// Get Each Topic, with with greater number of Authors -> Using
			// maxBy

			Map<Topic, Optional<Book>> mostAuthorsByTopic = lib.stream()
					.collect(
							groupingBy(Book::getTopic, Collectors
									.maxBy(Comparator.comparing(b -> ((Book) b)
											.getAuthors().size()))));

			// Total numberof Volumes based on the pageCount Length --> use
			// Summing
			Map<Topic, Integer> volumeByTopic = lib.stream()
					.collect(
							groupingBy(Book::getTopic,
									Collectors.summingInt(b -> ((Book) b)
											.getPageCounts().length)));
			System.out.println("volumeByTopic:" + volumeByTopic);

			// Average Height By Topic
			Map<Topic, Double> topicHeight = lib.stream().collect(
					groupingBy(Book::getTopic, Collectors
							.averagingDouble(b -> ((Book) b).getHeight())));

			System.out.println("topicHeight:" + topicHeight);

			// Summary Stats
			Map<Topic, IntSummaryStatistics> volumeStats = lib.stream()
					.collect(
							groupingBy(Book::getTopic, Collectors
									.summarizingInt(b -> ((Book) b)
											.getPageCounts().length)));

			System.out.println("volumeStats:" + volumeStats);

			// Map of Collectors to String
			// Concat Titles by Topic
			Map<Topic, String> concatenatedTitlesByTopic = lib.stream()
					.collect(
							groupingBy(Book::getTopic,
									mapping(Book::getTitle, joining(";"))));
			System.out.println("concatenatedTitlesByTopic:"
					+ concatenatedTitlesByTopic);

		}
	}

	static class StandAloneCollectors {
		public static void callAll() {
			accumulateToClassificationMap();
			accumulateToCustomCollections();
			accumulateToFramework();
		}

		private static void accumulateToClassificationMap() {
			Map<Topic, List<Book>> booksByTopic = lib.stream().collect(
					groupingBy(Book::getTopic));
			Map<Boolean, List<Book>> fictionOrNonFiction = lib
					.stream()
					.collect(partitioningBy(b -> b.getTopic() == Topic.FICTION));
		}

		private static void accumulateToCustomCollections() {
			// Map, Sorted by Date --> Put into a TreeMap
			Map<String, Year> titleToPubdate3 = lib.stream().collect(
					Collectors.toMap(Book::getTitle, Book::getPubDate,
							BinaryOperator.maxBy(Comparator.naturalOrder()),
							TreeMap::new));

			// Using toCollection
			Set<String> sortedTitles = lib.stream().map(Book::getTitle)
					.collect(toCollection(TreeSet::new));

			BlockingQueue<Book> queueInPubDateOrder = lib.stream()
					.sorted(Comparator.comparing(Book::getPubDate))
					.collect(toCollection(LinkedBlockingQueue::new));

		}

		private static void accumulateToFramework() {

			// To Accumulate to Framework - Supplied Containers
			List<String> listOfTitles = lib.stream().map(Book::getTitle)
					.collect(toList());
			System.out.println("listOfTitles:" + listOfTitles);

			// Joining
			String concatentedTitles = lib.stream().map(Book::getTitle)
					.collect(joining("::"));
			System.out.println("Titles:" + concatentedTitles);

			// List<String>, each containing concatenated authors

			List<String> authorsForBooks = lib
					.stream()
					.map(b -> b.getAuthors().stream()
							.collect(joining(",", b.getTitle() + ":", "")))
					.collect(toList());

			System.out.println("authorsForBooks:" + authorsForBooks);
		}

	}

}
