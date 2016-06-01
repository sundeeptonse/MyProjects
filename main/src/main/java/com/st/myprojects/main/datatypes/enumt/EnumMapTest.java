/**
 * 
 */
package com.st.myprojects.main.datatypes.enumt;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*-
 * @author sundeeptonse 
 * If you want to group by Type
 *
 */
public class EnumMapTest {

	public static void main(String[] args) {

		Herb[] garden = { new Herb("Basil", Herb.Type.ANNUAL),
				new Herb("Carroway", Herb.Type.BIENNIAL),
				new Herb("Dill", Herb.Type.ANNUAL),
				new Herb("Lavendar", Herb.Type.PERENNIAL),
				new Herb("Parsley", Herb.Type.BIENNIAL),
				new Herb("Rosemary", Herb.Type.PERENNIAL) };

		// Without EnumMap
		Set<Herb>[] herbsByType2 = (Set<Herb>[]) new Set[Herb.Type.values().length];
		for (int i = 0; i < herbsByType2.length; i++) {
			herbsByType2[i] = new HashSet<Herb>();
		}

		for (Herb h : garden)
			herbsByType2[h.type.ordinal()].add(h);

		for (int i = 0; i < herbsByType2.length; i++)
			System.out.printf("%s: %s\n", Herb.Type.values()[i],
					herbsByType2[i]);

		System.out.println("-----------------------------------------");

		// With EnumMap
		// Using an EnumMap to associate data with an enum - Page 162
		Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<>(
				Herb.Type.class);
		for (Herb.Type t : Herb.Type.values())
			herbsByType.put(t, new HashSet<Herb>());
		for (Herb h : garden)
			herbsByType.get(h.type).add(h);
		System.out.println(herbsByType);
	}

}

class Herb {
	public enum Type {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	final String name;
	final Type type;

	Herb(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name;
	}

}
