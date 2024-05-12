package Components.chart.models;

public class ModelData {

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
    
    public int getNoOfCars() {
        return no_of_cars;
    }

    public void setNoOfCars(int no_of_cars) {
        this.no_of_cars = no_of_cars;
    }

    public ModelData(String month, double profit , int no_of_cars) {
        this.month = month;
        this.profit = profit;
        this.no_of_cars = no_of_cars;
    }

    public ModelData() {
    }

    private String month;
    private double profit;
    private int no_of_cars;
}