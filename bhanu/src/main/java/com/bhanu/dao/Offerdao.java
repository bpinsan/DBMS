package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Offer;

public interface Offerdao {

	@Autowired
	public void SaveOrUpdate(Offer offer);
	public List<Offer> getOffers();
	public List<Offer> GetAllOffer();
	public Offer GetOffer(int offer_id);
	public void UpdateOffer(Offer offer);
	public Boolean isEnabled(int offerId);
	public void deleteOffer(int offerId);
	public void applyOffer(String userId,int offerId);
	public void switchStatus(int offerId);
}
