package vts.utils;

public class VehicleStridesBean {

	private String primaryKey;
	private boolean liveTracking;
	private long startDate;
	private long endDate;
	private String latitudeDir;
	private String longitudeDir;
	private double startLatitude;
	private double startlongitude;

	private double latitude;
	private double longitude;
	private String imeiNumber;
	private String vehicleRegNo;
	private double distanceSinceStrideON;
	private long travelledTime;
	private float internalBatteryVoltage;
	private String organizationId;
	private float canPidCounters;

	private int strideId;

	private String status;
	private double fuelConsumed;
	private float mainInputVoltage;
	private float maxRpm;
	private int minspeed;
	private int maxspeed;
	private float MaxEngineLoad;
	private int avgSpeed;

	private long pulseValue;

	private int noOfCanPackets;
	private int noOfGSMPackets;
	private int noOfGpsPackets;

	private long startMsPulse;

	private long endMsPulse;

	private byte ignition;

	private int nohStartOffSet;

	private int alhStartOffset;

	private int dbhStartOffset;

	private int nohEndOffSet;

	private int alhEndOffset;

	private int dbhEndOffset;

	private boolean strideReceivedFlag;

	private double gpsServerDistance;

	private double correctedGpsDistance;

	private double distanceInCan;

	private double excessDistance;

	private double costOfStride;
	private float mileage;

	private String bucketName;
	private boolean inS3;
	private float mainInputVoltagePercentage;
	private float internalBatteryPercentage;
	private String driverPeronId;
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public boolean isLiveTracking() {
		return liveTracking;
	}
	public void setLiveTracking(boolean liveTracking) {
		this.liveTracking = liveTracking;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public String getLatitudeDir() {
		return latitudeDir;
	}
	public void setLatitudeDir(String latitudeDir) {
		this.latitudeDir = latitudeDir;
	}
	public String getLongitudeDir() {
		return longitudeDir;
	}
	public void setLongitudeDir(String longitudeDir) {
		this.longitudeDir = longitudeDir;
	}
	public double getStartLatitude() {
		return startLatitude;
	}
	public void setStartLatitude(double startLatitude) {
		this.startLatitude = startLatitude;
	}
	public double getStartlongitude() {
		return startlongitude;
	}
	public void setStartlongitude(double startlongitude) {
		this.startlongitude = startlongitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public double getDistanceSinceStrideON() {
		return distanceSinceStrideON;
	}
	public void setDistanceSinceStrideON(double distanceSinceStrideON) {
		this.distanceSinceStrideON = distanceSinceStrideON;
	}
	public long getTravelledTime() {
		return travelledTime;
	}
	public void setTravelledTime(long travelledTime) {
		this.travelledTime = travelledTime;
	}
	public float getInternalBatteryVoltage() {
		return internalBatteryVoltage;
	}
	public void setInternalBatteryVoltage(float internalBatteryVoltage) {
		this.internalBatteryVoltage = internalBatteryVoltage;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public float getCanPidCounters() {
		return canPidCounters;
	}
	public void setCanPidCounters(float canPidCounters) {
		this.canPidCounters = canPidCounters;
	}
	public int getStrideId() {
		return strideId;
	}
	public void setStrideId(int strideId) {
		this.strideId = strideId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getFuelConsumed() {
		return fuelConsumed;
	}
	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}
	public float getMainInputVoltage() {
		return mainInputVoltage;
	}
	public void setMainInputVoltage(float mainInputVoltage) {
		this.mainInputVoltage = mainInputVoltage;
	}
	public float getMaxRpm() {
		return maxRpm;
	}
	public void setMaxRpm(float maxRpm) {
		this.maxRpm = maxRpm;
	}
	public int getMinspeed() {
		return minspeed;
	}
	public void setMinspeed(int minspeed) {
		this.minspeed = minspeed;
	}
	public int getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}
	public float getMaxEngineLoad() {
		return MaxEngineLoad;
	}
	public void setMaxEngineLoad(float maxEngineLoad) {
		MaxEngineLoad = maxEngineLoad;
	}
	public int getAvgSpeed() {
		return avgSpeed;
	}
	public void setAvgSpeed(int avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
	public long getPulseValue() {
		return pulseValue;
	}
	public void setPulseValue(long pulseValue) {
		this.pulseValue = pulseValue;
	}
	public int getNoOfCanPackets() {
		return noOfCanPackets;
	}
	public void setNoOfCanPackets(int noOfCanPackets) {
		this.noOfCanPackets = noOfCanPackets;
	}
	public int getNoOfGSMPackets() {
		return noOfGSMPackets;
	}
	public void setNoOfGSMPackets(int noOfGSMPackets) {
		this.noOfGSMPackets = noOfGSMPackets;
	}
	public int getNoOfGpsPackets() {
		return noOfGpsPackets;
	}
	public void setNoOfGpsPackets(int noOfGpsPackets) {
		this.noOfGpsPackets = noOfGpsPackets;
	}
	public long getStartMsPulse() {
		return startMsPulse;
	}
	public void setStartMsPulse(long startMsPulse) {
		this.startMsPulse = startMsPulse;
	}
	public long getEndMsPulse() {
		return endMsPulse;
	}
	public void setEndMsPulse(long endMsPulse) {
		this.endMsPulse = endMsPulse;
	}
	public byte getIgnition() {
		return ignition;
	}
	public void setIgnition(byte ignition) {
		this.ignition = ignition;
	}
	public int getNohStartOffSet() {
		return nohStartOffSet;
	}
	public void setNohStartOffSet(int nohStartOffSet) {
		this.nohStartOffSet = nohStartOffSet;
	}
	public int getAlhStartOffset() {
		return alhStartOffset;
	}
	public void setAlhStartOffset(int alhStartOffset) {
		this.alhStartOffset = alhStartOffset;
	}
	public int getDbhStartOffset() {
		return dbhStartOffset;
	}
	public void setDbhStartOffset(int dbhStartOffset) {
		this.dbhStartOffset = dbhStartOffset;
	}
	public int getNohEndOffSet() {
		return nohEndOffSet;
	}
	public void setNohEndOffSet(int nohEndOffSet) {
		this.nohEndOffSet = nohEndOffSet;
	}
	public int getAlhEndOffset() {
		return alhEndOffset;
	}
	public void setAlhEndOffset(int alhEndOffset) {
		this.alhEndOffset = alhEndOffset;
	}
	public int getDbhEndOffset() {
		return dbhEndOffset;
	}
	public void setDbhEndOffset(int dbhEndOffset) {
		this.dbhEndOffset = dbhEndOffset;
	}
	public boolean isStrideReceivedFlag() {
		return strideReceivedFlag;
	}
	public void setStrideReceivedFlag(boolean strideReceivedFlag) {
		this.strideReceivedFlag = strideReceivedFlag;
	}
	public double getGpsServerDistance() {
		return gpsServerDistance;
	}
	public void setGpsServerDistance(double gpsServerDistance) {
		this.gpsServerDistance = gpsServerDistance;
	}
	public double getCorrectedGpsDistance() {
		return correctedGpsDistance;
	}
	public void setCorrectedGpsDistance(double correctedGpsDistance) {
		this.correctedGpsDistance = correctedGpsDistance;
	}
	public double getDistanceInCan() {
		return distanceInCan;
	}
	public void setDistanceInCan(double distanceInCan) {
		this.distanceInCan = distanceInCan;
	}
	public double getExcessDistance() {
		return excessDistance;
	}
	public void setExcessDistance(double excessDistance) {
		this.excessDistance = excessDistance;
	}
	public double getCostOfStride() {
		return costOfStride;
	}
	public void setCostOfStride(double costOfStride) {
		this.costOfStride = costOfStride;
	}
	public float getMileage() {
		return mileage;
	}
	public void setMileage(float mileage) {
		this.mileage = mileage;
	}
	public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	public boolean isInS3() {
		return inS3;
	}
	public void setInS3(boolean inS3) {
		this.inS3 = inS3;
	}
	public float getMainInputVoltagePercentage() {
		return mainInputVoltagePercentage;
	}
	public void setMainInputVoltagePercentage(float mainInputVoltagePercentage) {
		this.mainInputVoltagePercentage = mainInputVoltagePercentage;
	}
	public float getInternalBatteryPercentage() {
		return internalBatteryPercentage;
	}
	public void setInternalBatteryPercentage(float internalBatteryPercentage) {
		this.internalBatteryPercentage = internalBatteryPercentage;
	}
	public String getDriverPeronId() {
		return driverPeronId;
	}
	public void setDriverPeronId(String driverPeronId) {
		this.driverPeronId = driverPeronId;
	}

	
}
