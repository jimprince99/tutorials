package org.jimprince99.mockito2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;

import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class TestSubscriberWithSpy {

	/*
	 * examples of verify
	 * in this example nothing is stubbed. The
	 * original code is still used.
	 */
	@Test
	public void testSpy() {

		/* setup */

		// create a spy of the AdminSubscriber class
		AdminSubscriber adminSubscriberSpy = Mockito.spy(AdminSubscriber.class);

		// Instantiate subscriber with our mock
		Subscriber subscriber = new Subscriber(adminSubscriberSpy);

		/* execution */
		subscriber.setName("test1");

		/* validation */

		/* teardown */

	}
	
	/*
	 * examples of verify
	 * in this example nothing is stubbed. The
	 * original code is still used.
	 */
	@Test
	public void testSpyWithStub() {

		/* setup */

		// create a spy of the AdminSubscriber class
		AdminSubscriber adminSubscriberSpy = Mockito.spy(AdminSubscriber.class);

		// Instantiate subscriber with our spy
		Subscriber subscriber = new Subscriber(adminSubscriberSpy);

		// override the getName method
		Mockito.when(adminSubscriberSpy.getName()).thenReturn("test1");

		/* execution */
		String name = subscriber.getName();

		/* validation */
		assertEquals("test1", name);
		
		// and the standard methods are still available
		assertEquals(0, subscriber.getId());

		/* teardown */

	}
	
	   /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }
    
}
