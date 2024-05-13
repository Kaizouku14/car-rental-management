package Components.chart.models;

public class ModelData {

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ModelData(String month, double value) {
        this.month = month;
        this.value = value;
    }

    public ModelData() {
    }

    private String month;
    private double value;
}