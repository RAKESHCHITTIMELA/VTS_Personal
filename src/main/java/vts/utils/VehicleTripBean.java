package vts.utils;

public class VehicleTripBean {
	private String _id;
	private String tripName;
	private String tripStatus;
	private String imeiNumber;
	private long tripStartDate;
	private long tripEndDate;
	private String driverSlNo;
	private double distanceTravel;
	private double fuelConsumed;
	private float timeDuration;
	private float millage;
	private String tripType;
	private double startLatitude;
	private double startLongitude;
	private double endLatitude;
	private double endLongitude;
	private float dieselPrice;
	private float petrolPrice;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getTripStatus() {
		return tripStatus;
	}

	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}

	public String getImeiNumber() {
		return imeiNumber;
	}

	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	public long getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(long tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public long getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(long tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public String getDriverSlNo() {
		return driverSlNo;
	}

	public void setDriverSlNo(String driverSlNo) {
		this.driverSlNo = driverSlNo;
	}

	public double getDistanceTravel() {
		return distanceTravel;
	}

	public void setDistanceTravel(double distanceTravel) {
		this.distanceTravel = distanceTravel;
	}

	public double getFuelConsumed() {
		return fuelConsumed;
	}

	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	public float getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(float timeDuration) {
		this.timeDuration = timeDuration;
	}

	public float getMillage() {
		return millage;
	}

	public void setMillage(float millage) {
		this.millage = millage;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public double getStartLatitude() {
		return startLatitude;
	}

	public void setStartLatitude(double startLatitude) {
		this.startLatitude = startLatitude;
	}

	public double getStartLongitude() {
		return startLongitude;
	}

	public void setStartLongitude(double startLongitude) {
		this.startLongitude = startLongitude;
	}

	public double getEndLatitude() {
		return endLatitude;
	}

	public void setEndLatitude(double endLatitude) {
		this.endLatitude = endLatitude;
	}

	public double getEndLongitude() {
		return endLongitude;
	}

	public void setEndLongitude(double endLongitude) {
		this.endLongitude = endLongitude;
	}

	public float getDieselPrice() {
		return dieselPrice;
	}

	public void setDieselPrice(float dieselPrice) {
		this.dieselPrice = dieselPrice;
	}

	public float getPetrolPrice() {
		return petrolPrice;
	}

	public void setPetrolPrice(float petrolPrice) {
		this.petrolPrice = petrolPrice;
	}

}