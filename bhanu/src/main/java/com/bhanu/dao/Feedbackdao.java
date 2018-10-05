package com.bhanu.dao;

import java.util.List;

import com.bhanu.model.Feedback;

public interface Feedbackdao {
		
	void addFeedback(Feedback feedback);
	Feedback getFeedback(int Product_id,int Feedback_id);
	void deleteFeedback(int Product_id,int Feedback_id);
	List<Feedback> getFeedbacks(int Product_id);
}
