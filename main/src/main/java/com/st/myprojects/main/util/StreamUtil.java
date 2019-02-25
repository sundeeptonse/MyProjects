package com.st.myprojects.main.util;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by stonse on 5/18/17.
 * Common Stream Utils
 *
 */
public class StreamUtil {

	//Based on a collection size, decides if a stream needs to be in parallel
	private static int defaultCollectionSizeForParallelStream = 1000;


	/*
	* Returns the Correct Stream parallel or not based on defaultSizeForParallelThreads
	*
	* @param Collection<T> collection  		The Collection which needs to be turned into a Stream
	* @return Stream<T>  					Returns the parallel or sequential Stream
	* */
	public static <T> Stream<T> getStream(Collection<T> collection){
		Objects.requireNonNull(collection);
		return getStream(collection, defaultCollectionSizeForParallelStream);
	}


	/*
	* Returns the Correct Stream parallel or sequential based on the flag
	*
	* @param Collection<T> collection  		The Collection which needs to be turned into a Stream
	* @param boolean parallel
	* @return Stream<T>  					Returns the parallel or sequential Stream
	* */
	public static <T> Stream<T> getStream(Collection<T> collection, boolean parallel) {
		Objects.requireNonNull(collection);
		return parallel ? collection.parallelStream() : collection.stream();
	}

	/*
	* Returns the Correct Stream parallel or not based on minSizeForParallel
	* @param Collection<T> collection  		The Collection which needs to be turned into a Stream
	* @param int minSizeForParallel			Min Size for which it needs to be in parallel
	* @return Stream<T>  					Returns the parallel or sequential Stream
	* */
	public static <T> Stream<T> getStream(Collection<T> collection, int minSizeForParallel){
		Objects.requireNonNull(collection);
		return collection.size() > minSizeForParallel ? collection.parallelStream() : collection.stream();
	}


	/*
	* Given a iterable class, returns the default Stream
	* @param Iterable<T> iterable  		The Collection which needs to be turned into a Stream
	* @param boolean isParallel			Return parallel or not
	* @return Stream<T>  				Returns the parallel or sequential Stream
	* */
	public static <T> Stream<T> getDefaultStream(Iterable<T> iterable, boolean isParallel) {
		return StreamSupport.stream(iterable.spliterator(), isParallel);
	}


}
