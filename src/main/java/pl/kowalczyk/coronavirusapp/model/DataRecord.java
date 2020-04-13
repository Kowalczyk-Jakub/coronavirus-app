package pl.kowalczyk.coronavirusapp.model;

public class DataRecord {

    private String State;
    private String Region;
    private int Infected;

    public DataRecord(String state, String region, int infected) {
        State = state;
        Region = region;
        Infected = infected;
    }

    public DataRecord() {
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public int getInfected() {
        return Infected;
    }

    public void setInfected(int infected) {
        Infected = infected;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "State='" + State + '\'' +
                ", Region='" + Region + '\'' +
                ", Infected=" + Infected +
                '}';
    }
}
