/**
 * 
 */
package com.st.myprojects.main.datatypes.generics.javagenericsbook.chap2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundeeptonse
 *
 */
public class AnyList extends ArrayList<List<?>>{
	/**
	 * Not Allowed
	 * */
	//public class AnyList extends ArrayList<?>
	//public class AnyList extends List<?>

}


class AnyList2<T> extends ArrayList<T>{


}


class AnyList3<T extends Number> extends ArrayList<T>{


}
