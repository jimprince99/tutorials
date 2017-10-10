package org.jimprince99.mockito2;

/*
 * a super class for all the subscriber ops
 */
public class AdminSubscriber {

	String name = null;
	int id = 0;
	
	// getters and setters
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
}
