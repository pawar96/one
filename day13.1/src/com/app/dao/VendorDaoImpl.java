package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

import java.util.List;

import org.hibernate.*;

@Repository
public class VendorDaoImpl implements IVendorDao {
	// dependency
	@Autowired // byType
	private SessionFactory sf;

	public VendorDaoImpl() {
		System.out.println("in cnstr of " + getClass().getName());
	}

	@Override
	public Vendor validateUser(String email, String pass) {
		String jpql = "select v from Vendor v where v.email=:em and v.password=:pa";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pa", pass)
				.getSingleResult();
	}

	@Override
	public List<Vendor> listVendors() {
		String jpql = "select v from Vendor v where v.role=:role";
		return sf.getCurrentSession().
				createQuery(jpql, Vendor.class).
				setParameter("role", "vendor").getResultList();
	}

	@Override
	public String deleteVendorDetails(Vendor v) {
		//v --detached pojo ref
		sf.getCurrentSession().delete(v);
		return "Vendor details deleted for Vendor ID "+v.getId();
	}

	@Override
	public String updateVendorDetails(Vendor v) {
		// v-  detached Vendor POJO containing
		//updated vendor dtls
		//detached ---> persistent
		sf.getCurrentSession().update(v);//v --- PERSISTENT
		//hib will perform auto dirty chking (update query)
		//will be fired upon commit
		return "Vendor details updated for Vendor ID "+v.getId();
	}

	@Override
	public String registerVendor(Vendor v) {
		//v -- transient
		sf.getCurrentSession().persist(v); //persistent
		return "Vendor details insertedd for Vendor ID "+v.getId();
	}

	@Override
	public Vendor getVendorDetails(int vid) {
		return sf.getCurrentSession().get(Vendor.class, vid);
	}
	

}
