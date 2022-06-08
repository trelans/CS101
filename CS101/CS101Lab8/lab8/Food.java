public class Food {
    // Variables
    private String name;
    private String ingredients;
    private int calories;
    private String type;
    private double price;

    public Food( String name , double price) {
        this.name = name;
        this.ingredients = "";
        this.calories = 0;
        this.type = "";
        this.price = price;

    }

    // Accessors and Mutators

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Food(String name, String ingredients , int calories, String type, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.type = type;
        this.price = price;
    }

    // Other methods

    public boolean equals (Food food) {
        if (this.getName().equals(food.getName()) &&
                this.getIngredients().equals(food.getIngredients())) return true;

        return false;
    }
    public void addIngredient(String newIngredient) {
        setIngredients(
                getIngredients() + ", " + newIngredient
        );
    }
    public boolean doesContain(String ingredient) {
      return  ingredient.contains(ingredient);
    }
    public String toString() {
        String result = "";
        result = this.name + " is a " + this.type + " dish.\n" +
                "It includes " + ingredients + ".\n" +
                "Single portion contains " + calories + " calories.\n" +
                "Single serving cost = " + price ;
        return result;
    }

}
