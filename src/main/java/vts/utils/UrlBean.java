package vts.utils;

public class UrlBean {

	private String batchId;
	private String url;
	private double devicePort;
	private double servicesPort;
	private double registerPort;
	private double startDate;
	private double endDate;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getDevicePort() {
		return devicePort;
	}

	public void setDevicePort(double devicePort) {
		this.devicePort = devicePort;
	}

	public double getServicesPort() {
		return servicesPort;
	}

	public void setServicesPort(double servicesPort) {
		this.servicesPort = servicesPort;
	}

	public double getRegisterPort() {
		return registerPort;
	}

	public void setRegisterPort(double registerPort) {
		this.registerPort = registerPort;
	}

	public double getStartDate() {
		return startDate;
	}

	public void setStartDate(double startDate) {
		this.startDate = startDate;
	}

	public double getEndDate() {
		return endDate;
	}

	public void setEndDate(double endDate) {
		this.endDate = endDate;
	}

}
