package com.st.myprojects.main.patterns.builder;

import com.st.myprojects.main.patterns.STObject;

public class NutritionFacts extends STObject {

	public static void main(String[] args) {
		new NutritionFacts.Builder(240, 8).calories(250).fat(10).build()
				.print();
		
		
	}

	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
	}

	public static abstract class BuilderA<T> {
		public abstract T build();
	}

	
	public static class Builder extends BuilderA<NutritionFacts> {
		// Required Parameters
		private int servingSize;
		private int servings;

		// Optional Parameters
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			this.calories = val;
			return this;
		}

		public Builder fat(int val) {
			this.fat = val;
			return this;
		}

		public Builder sodium(int val) {
			this.sodium = val;
			return this;
		}

		@Override
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

}
