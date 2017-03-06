/**
 * 
 */
package com.st.myprojects.main.datastructures.custom;

import java.util.Comparator;
import java.util.TreeSet;

import com.st.myprojects.main.util.CommonUtil;

/**
 * @author sundeeptonse
 *
 */
public class TreeSetFixed<E> extends TreeSet<E> {

	private static final long serialVersionUID = 1L;
	private final Comparator<? super E> comparator;
	private final int maxSize;

	public TreeSetFixed(int maxSize) {
		this(maxSize, null);
	}

	public TreeSetFixed(int maxSize, Comparator<? super E> comparator) {
		super(comparator);
		this.comparator = comparator;
		this.maxSize = maxSize;
	}

	public boolean add(E e) {

		// If size < MaxSze
		// Add to the Tree which will order it

		// If Size is >= max Size
		// Get the last value
		// Compare and check what is the last value in the list
		// If the currentValue is > the lastValue, via the comparator, then we
		// add it and remove the last one

		// System.out.println("Before:" + this.toString());
		boolean value = false;
		if (size() < maxSize) {
			value = super.add(e);
		} else {
			E lastValue = last();
			// System.out.println("lastValue:" + lastValue + ":CurrentValue:" +
			// e);
			if (CommonUtil.compare(e, lastValue, comparator) < 1) {
				value = remove(lastValue) && super.add(e);
			}
		}
		// System.out.println("After:Added:" + value + ":" + this.toString());
		return value;
	}
}
