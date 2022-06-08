public class User {
   private static int count = 0;
   private int ID;
   private String name;
   private int age;
   private String orders;
   private int numberOfOrders;
   private String eatenFoods;
   Food favoriteFood;  

    public User(String name, int age ) {
        ID = count;
        this.name = name;
        this.age = age;
        orders = "";
        numberOfOrders = 0;
        eatenFoods = "";
        addUser();
    }

    // Accessors and Mutators

    public static int getCount() {
        return count;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteFood(Food food) {
        this.favoriteFood = food;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getEatenFoods() {
        return eatenFoods;
    }
    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setEatenFoods(String eatenFoods) {
        this.eatenFoods = eatenFoods;
    }

    // Other methods

    public void addUser() {
        count++;

    }
    public boolean equals(User user) {
        if (this.getAge() == user.getAge() &&
                this.getID() == user.getID() &&
                this.getName().equals(user.getName()) )
                return true;

        return false;
    }
    public boolean didEat(Food food) {
      return  eatenFoods.contains(food.getName());
    }

    String pickOrderByIndex(int index) {
        String newOrdersString = "x," + orders;
      String[] ordersArray  = newOrdersString.split(",");
      if (index > 0 ) {
          return ordersArray[index];
      }
      else {
          return "Invalid order index";
      }


    }

    public void addNewOrder (Order order) {
        System.out.println("\nAdding a new order of " + order.getOrderedFood().getName() + " to " + name + "...\n" +
        favoriteFood.getName() + " is " + name +"'s  favorite food!\n" ) ;

        if(order.getOrderedFood().equals(favoriteFood)) {
            int randomNumb = (int) (Math.random() * 8) + 1;
          
            if(randomNumb < 5 ) {
                order.getOrderedFood().setPrice(0);
                order.checkout();
                System.out.println( name + " win the order for free! " );

            }
            else {
                System.out.println( name + " lost the chance." );
            }
            order.setCheckedOut(true);
        }
         

        numberOfOrders++;
        if (orders.equals(""))
             orders = order.getID() + "";
        else
             orders = orders + "-" + order.getID();

        if (!didEat(order.getOrderedFood()) ) {
            // add
            if (eatenFoods.equals(""))
                eatenFoods = order.getOrderedFood().getName() + "";
            else
                eatenFoods = eatenFoods + "-" + order.getOrderedFood().getName() ;
        }

    }

   public String toString() {
        String result = "";
        result = "User ID: " + ID + ", User Name: " + name + ", Age:" + age;
        return result;
    }

}
