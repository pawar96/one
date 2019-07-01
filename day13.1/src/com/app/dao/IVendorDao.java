package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	Vendor validateUser(String email,String pass);
	List<Vendor> listVendors();
	String deleteVendorDetails(Vendor v);
	String updateVendorDetails(Vendor v);
	String registerVendor(Vendor v);
	Vendor getVendorDetails(int vid);
}
