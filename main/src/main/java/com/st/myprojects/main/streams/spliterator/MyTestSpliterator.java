package com.st.myprojects.main.streams.spliterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by stonse on 6/5/17.
 */
public class MyTestSpliterator implements Iterable {

	@Override
	public Spliterator spliterator() {
		return new Spliterator() {
			@Override
			public boolean tryAdvance(Consumer action) {
				return false;
			}

			@Override
			public Spliterator trySplit() {
				return null;
			}

			@Override
			public long estimateSize() {
				return 0;
			}

			@Override
			public int characteristics() {
				return 0;
			}
		};
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Object next() {
				return null;
			}
		};
	}
}
