/**
 * 
 */
package com.st.myprojects.main.datatypes.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class EmptyCollection {

	private final List<Cheese> cheesesinStock = new ArrayList<>();
	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	public Cheese[] getCheeses() {
		return cheesesinStock.toArray(EMPTY_CHEESE_ARRAY);
	}

	public List<Cheese> getCheeseList() {
		if (cheesesinStock.isEmpty())
			return Collections.emptyList();
		else
			return new ArrayList<Cheese>(cheesesinStock);
	};

}

class Cheese {

}
