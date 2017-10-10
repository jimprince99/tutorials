package org.jimprince99.mockito2;

/*
 * a set of limited ops on a Subscriber
 */
public class Subscriber {

	private final AdminSubscriber adminSubscriber;

	Subscriber (AdminSubscriber adminSubscriber) {
		this.adminSubscriber = adminSubscriber;
	}
	
	public void setName(String subscriberName) {
		adminSubscriber.setName(subscriberName);
	}
	
	public String getName() {
		return adminSubscriber.getName();
	}
	
	public void setId(int id) {
		adminSubscriber.setId(id);
	}
	
	public int getId() {
		return adminSubscriber.getId();
	}
}
