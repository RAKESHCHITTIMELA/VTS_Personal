package vts.utils;

import java.util.List;

public class UserLoginBean {

	private UserData userData;
	private KycData kycData;
	private List<VehicleDeviceOrganizationBean> vehicleDeviceOrganizationBean;
	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	public KycData getKycData() {
		return kycData;
	}
	public void setKycData(KycData kycData) {
		this.kycData = kycData;
	}
	public List<VehicleDeviceOrganizationBean> getVehicleDeviceOrganizationBean() {
		return vehicleDeviceOrganizationBean;
	}
	public void setVehicleDeviceOrganizationBean(List<VehicleDeviceOrganizationBean> vehicleDeviceOrganizationBean) {
		this.vehicleDeviceOrganizationBean = vehicleDeviceOrganizationBean;
	}

	



}
