package Components.chart.models;

public class TransactionModel {
    
     public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTotal_of_costumers() {
        return total_of_costumers;
    }

    public void setTotal_of_costumers(double total_of_costumers) {
        this.total_of_costumers = total_of_costumers;
    }
    
    public double getTotal_cars_borrowed(){
        return total_cars_borrowed;
    }
    
    public void setTotal_cars_borrowedouble(double total_cars_borrowed){
        this.total_cars_borrowed = total_cars_borrowed;
    }

    public TransactionModel(String month, double total_of_costumers , double total_cars_borrowed) {
        this.month = month;
        this.total_of_costumers = total_of_costumers;
        this.total_cars_borrowed = total_cars_borrowed;
    }

    public TransactionModel() {
    }

    private String month;
    private double total_of_costumers;
    private double total_cars_borrowed;
}
