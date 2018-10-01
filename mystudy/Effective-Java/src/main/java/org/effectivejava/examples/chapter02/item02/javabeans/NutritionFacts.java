// JavaBeans Pattern - allows inconsistency, mandates mutability - Pages 12-13
package org.effectivejava.examples.chapter02.item02.javabeans;

public class NutritionFacts {
    // Parameters initialized to default values (if any)
    private int servingSize = -1; // (mL) required
    private int servings = -1; // (per container) required
    private int calories = 0; // optional
    private int fat = 0; // (g) optional
    private int sodium = 0; //(mg) optional
    private int carbohydrate = 0; //(g) optional

    public NutritionFacts() {
    }

    // Setters
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
