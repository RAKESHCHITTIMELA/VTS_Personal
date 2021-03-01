package vts.utils;

public class ReportsData {

	String id;
	String imeiNumber;
    long startTime;
    long endTime;
    double fuelConsumed;
    int drivenTime;
     float fuelCostOnDay;
    double costOfDrive;
    float maxRpm;
    float minspeed;
    float maxspeed;
    float maxEngineLoad;
    double distanceTravelled;
    float mileage;
    String vehcileNumber;
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public double getFuelConsumed() {
		return fuelConsumed;
	}
	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}
	public int getDrivenTime() {
		return drivenTime;
	}
	public void setDrivenTime(int drivenTime) {
		this.drivenTime = drivenTime;
	}
	public float getFuelCostOnDay() {
		return fuelCostOnDay;
	}
	public void setFuelCostOnDay(float fuelCostOnDay) {
		this.fuelCostOnDay = fuelCostOnDay;
	}
	public double getCostOfDrive() {
		return costOfDrive;
	}
	public void setCostOfDrive(double costOfDrive) {
		this.costOfDrive = costOfDrive;
	}
	public float getMaxRpm() {
		return maxRpm;
	}
	public void setMaxRpm(float maxRpm) {
		this.maxRpm = maxRpm;
	}
	public float getMinspeed() {
		return minspeed;
	}
	public void setMinspeed(float minspeed) {
		this.minspeed = minspeed;
	}
	public float getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(float maxspeed) {
		this.maxspeed = maxspeed;
	}
	public float getMaxEngineLoad() {
		return maxEngineLoad;
	}
	public void setMaxEngineLoad(float maxEngineLoad) {
		this.maxEngineLoad = maxEngineLoad;
	}
	public double getDistanceTravelled() {
		return distanceTravelled;
	}
	public void setDistanceTravelled(double distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getVehcileNumber() {
		return vehcileNumber;
	}
	public void setVehcileNumber(String vehcileNumber) {
		this.vehcileNumber = vehcileNumber;
	}
	
	@Override
	public String toString() {
		return "ReportsData [id=" + id + ", imeiNumber=" + imeiNumber + ", startTime=" + startTime + ", endTime="
				+ endTime + ", fuelConsumed=" + fuelConsumed + ", drivenTime=" + drivenTime + ", fuelCostOnDay="
				+ fuelCostOnDay + ", costOfDrive=" + costOfDrive + ", maxRpm=" + maxRpm + ", minspeed=" + minspeed
				+ ", maxspeed=" + maxspeed + ", maxEngineLoad=" + maxEngineLoad + ", distanceTravelled="
				+ distanceTravelled + ", mileage=" + mileage + ", vehcileNumber=" + vehcileNumber + "]";
	}
}
