package vts.utils;

public class NotificationsData {

	long dateTime,distance;
	double latitude, longitude;
	String latitudeDirection, longitudeDirection;
	boolean seenStatus, dummyAlert;
	int speed, scale, pulseFlag,strideid, alhOffset,rollOverFlag,currentStrideFlag;
	String id, typeOfAlert, vehicleRegNo, alertType,organizationId,imeiNumber,alertmessage,sourceIp,driverPeronId,sourceMobileNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeOfAlert() {
		return typeOfAlert;
	}
	public void setTypeOfAlert(String typeOfAlert) {
		this.typeOfAlert = typeOfAlert;
	}
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}
	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}
	public String getAlertmessage() {
		return alertmessage;
	}
	public void setAlertmessage(String alertmessage) {
		this.alertmessage = alertmessage;
	}
	public String getSourceIp() {
		return sourceIp;
	}
	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}
	public String getDriverPeronId() {
		return driverPeronId;
	}
	public void setDriverPeronId(String driverPeronId) {
		this.driverPeronId = driverPeronId;
	}
	public String getSourceMobileNumber() {
		return sourceMobileNumber;
	}
	public void setSourceMobileNumber(String sourceMobileNumber) {
		this.sourceMobileNumber = sourceMobileNumber;
	}
	public long getDateTime() {
		return dateTime;
	}
	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
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
	public String getLatitudeDirection() {
		return latitudeDirection;
	}
	public void setLatitudeDirection(String latitudeDirection) {
		this.latitudeDirection = latitudeDirection;
	}
	public String getLongitudeDirection() {
		return longitudeDirection;
	}
	public void setLongitudeDirection(String longitudeDirection) {
		this.longitudeDirection = longitudeDirection;
	}
	public boolean isSeenStatus() {
		return seenStatus;
	}
	public void setSeenStatus(boolean seenStatus) {
		this.seenStatus = seenStatus;
	}
	public boolean isDummyAlert() {
		return dummyAlert;
	}
	public void setDummyAlert(boolean dummyAlert) {
		this.dummyAlert = dummyAlert;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public int getPulseFlag() {
		return pulseFlag;
	}
	public void setPulseFlag(int pulseFlag) {
		this.pulseFlag = pulseFlag;
	}
	public int getStrideid() {
		return strideid;
	}
	public void setStrideid(int strideid) {
		this.strideid = strideid;
	}
	public int getAlhOffset() {
		return alhOffset;
	}
	public void setAlhOffset(int alhOffset) {
		this.alhOffset = alhOffset;
	}
	public int getRollOverFlag() {
		return rollOverFlag;
	}
	public void setRollOverFlag(int rollOverFlag) {
		this.rollOverFlag = rollOverFlag;
	}
	public int getCurrentStrideFlag() {
		return currentStrideFlag;
	}
	public void setCurrentStrideFlag(int currentStrideFlag) {
		this.currentStrideFlag = currentStrideFlag;
	}
	
	@Override
	public String toString() {
		return "NotificationsData [dateTime=" + dateTime + ", distance=" + distance + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", latitudeDirection=" + latitudeDirection + ", longitudeDirection="
				+ longitudeDirection + ", seenStatus=" + seenStatus + ", dummyAlert=" + dummyAlert + ", speed=" + speed
				+ ", scale=" + scale + ", pulseFlag=" + pulseFlag + ", strideid=" + strideid + ", alhOffset="
				+ alhOffset + ", rollOverFlag=" + rollOverFlag + ", currentStrideFlag=" + currentStrideFlag + ", id="
				+ id + ", typeOfAlert=" + typeOfAlert + ", vehicleRegNo=" + vehicleRegNo + ", alertType=" + alertType
				+ ", organizationId=" + organizationId + ", imeiNumber=" + imeiNumber + ", alertmessage=" + alertmessage
				+ ", sourceIp=" + sourceIp + ", driverPeronId=" + driverPeronId + ", sourceMobileNumber="
				+ sourceMobileNumber + "]";
	}
	
	
	
}
