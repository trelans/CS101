public class Order {

   private static int count = 0;

   private int ID ;
   private Food orderedFood;
   private double portion;
   private double totalPrice;
   private boolean isCheckedOut;

   public Order ( double portion, String name, double price) {

       this.ID = count;
       orderedFood = new Food( name , price);
       this.portion = portion;
       this.totalPrice = 0;
       isCheckedOut = false;


       addOrder();
   }

    public Order (double portion,  Food orderedFood) {
        this.ID = count;
        this.orderedFood = orderedFood;
        this.portion = portion;
        this.totalPrice = 0;
        isCheckedOut = false;

        addOrder();
    }

    public static int getCount() {
        return count;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public void setCheckedOut(boolean b) {
        isCheckedOut =  b;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Food getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(Food orderedFood) {
        this.orderedFood = orderedFood;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



   public void addOrder() {
       count++;
   }
   public boolean equals(Order order) {
       if (this.ID == order.getID()) {
           return true;
       }
       return false;
   }

   public void checkout() {
      isCheckedOut = true;
       this.totalPrice = portion * orderedFood.getPrice();

   }
   public void increasePortion(int extraPortion) {

       portion = portion + extraPortion;
   }

   public String toString() {
        String result = "";

        if (! isCheckedOut) {
            result =  " >> Warning: This order is incomplete. \n ";
            }
          result = result  + "Details for Order " + ID + "\n\t" +
              orderedFood.getName() + "(x " + portion + ")\n" +
                "\tTOTAL = " + totalPrice + "\n";

            return result;
        }
   }

