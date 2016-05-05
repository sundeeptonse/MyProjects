package com.st.myprojects.main.datatypes.generics;

import java.util.ArrayList;
import java.util.List;

public class CustomExtendsB<T extends List<String>> extends ArrayList<T>{
	//If you want to use the same bounded Parameter as During Obj Creation
	List<? extends T> value;
	
	//Can't use this.
	//List<Y> value2;
	
	//Can use this, but y?
	public <Y> Y getV(Y test){
		return test;
	}
}

// --> Doesn't work
class  CustomExtendsB2<T extends List<T>>{
	
}


//Works
class  CustomExtendsB3<T extends List<String>>{
	
}

//Works, but better to bound it
class  CustomExtendsB4<T extends List<?>>{
	
}

//Works, 
class  CustomExtendsB5<T extends List<? extends Number>>{
	
}

//Works, 
class  CustomExtendsB6<T extends List<? super Number>>{
	
}


//Works, 
class  CustomExtendsB7<T extends List<List<List<? super Number>>>>{
	
}
