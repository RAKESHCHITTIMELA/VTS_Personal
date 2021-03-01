package vts.utils;

import java.util.List;

public class UserVehicleDataBean {

	private String vehicleId;
	private String vehicleNumber;
	private String carImage;
	private float odoMeterReading;
	private long vehiclePurchaseDate;
	private long vehicleManufactureDate;
	private List<String> fuelType;
	private String vehicleColor;
	private String insuranceNumber;
	private long insuranceExpiryDate;
	private String insuranceCompanyName;
	private String insuranceImage;
	private String insurancePremium;
	private String vehicleModelId;
	private String status;
	private String imeiNumber;
	private String manufacturer;
	private String brand;
	private String variant;
	private String state;
	private String engineNumber;
	private String chasisNumber;
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	public float getOdoMeterReading() {
		return odoMeterReading;
	}
	public void setOdoMeterReading(float odoMeterReading) {
		this.odoMeterReading = odoMeterReading;
	}
	public long getVehiclePurchaseDate() {
		return vehiclePurchaseDate;
	}
	public void setVehiclePurchaseDate(long vehiclePurchaseDate) {
		this.vehiclePurchaseDate = vehiclePurchaseDate;
	}
	public long getVehicleManufactureDate() {
		return vehicleManufactureDate;
	}
	public void setVehicleManufactureDate(long vehicleManufactureDate) {
		this.vehicleManufactureDate = vehicleManufactureDate;
	}
	public List<String> getFuelType() {
		return fuelType;
	}
	public void setFuelType(List<String> fuelType) {
		this.fuelType = fuelType;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public long getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}
	public void setInsuranceExpiryDate(long insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getInsuranceImage() {
		return insuranceImage;
	}
	public void setInsuranceImage(String insuranceImage) {
		this.insuranceImage = insuranceImage;
	}
	public String getInsurancePremium() {
		return insurancePremium;
	}
	public void setInsurancePremium(String insurancePremium) {
		this.insurancePremium = insurancePremium;
	}
	public String getVehicleModelId() {
		return vehicleModelId;
	}
	public void setVehicleModelId(String vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImeiNumber() {
		return imeiNumber;
	}
	public void setImeiNumber(String imeiNumber) {
		this.imeiNumber = imeiNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public String getChasisNumber() {
		return chasisNumber;
	}
	public void setChasisNumber(String chasisNumber) {
		this.chasisNumber = chasisNumber;
	}
	@Override
	public String toString() {
		return "UserVehicleDataBean [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", carImage="
				+ carImage + ", odoMeterReading=" + odoMeterReading + ", vehiclePurchaseDate=" + vehiclePurchaseDate
				+ ", vehicleManufactureDate=" + vehicleManufactureDate + ", fuelType=" + fuelType + ", vehicleColor="
				+ vehicleColor + ", insuranceNumber=" + insuranceNumber + ", insuranceExpiryDate=" + insuranceExpiryDate
				+ ", insuranceCompanyName=" + insuranceCompanyName + ", insuranceImage=" + insuranceImage
				+ ", insurancePremium=" + insurancePremium + ", vehicleModelId=" + vehicleModelId + ", status=" + status
				+ ", imeiNumber=" + imeiNumber + ", manufacturer=" + manufacturer + ", brand=" + brand + ", variant="
				+ variant + ", state=" + state + ", engineNumber=" + engineNumber + ", chasisNumber=" + chasisNumber
				+ "]";
	}

	
}
