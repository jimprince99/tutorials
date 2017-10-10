package org.jimprince99.mockito2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

public class TestSubscriberWithMock {

	/*
	 * examples of verify
	 */
	@Test
	public void testSetName() {

		/* setup */

		// create a mock of the AdminSubscriber class
		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);

		// Instantiate subscriber with our mock
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		/* execution */
		subscriber.setName("test1");

		/* validation */

		// verify that the mock's setName method was called
		Mockito.verify(adminSubscriberMock).setName("test1");

		// verify that the method was called with a string that starts with "te"
		Mockito.verify(adminSubscriberMock).setName(Mockito.startsWith("te"));

		// verify that the string ends with t1
		Mockito.verify(adminSubscriberMock).setName(Mockito.endsWith("t1"));

		// verify that the string was test1
		Mockito.verify(adminSubscriberMock).setName(Mockito.eq("test1"));

		// verify that the mock's setName method was called atLeast once
		Mockito.verify(adminSubscriberMock, atLeast(1)).setName("test1");

		// verify that the mock's setName method was called atMost once
		Mockito.verify(adminSubscriberMock, atMost(1)).setName("test1");

		// verify that the mock's setName method was called exactly once
		Mockito.verify(adminSubscriberMock, times(1)).setName("test1");

		// verify that the mock's getName method was not caled
		Mockito.verify(adminSubscriberMock, times(0)).getName();

		/* teardown */

	}

	@Test
	public void testGetName() {

		/* setup */
		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		Mockito.when(adminSubscriberMock.getName()).thenReturn("test1");

		/* execution */
		String result = subscriber.getName();

		/* validation */
		assertEquals("test1", result);

		Mockito.verify(adminSubscriberMock).getName();
		Mockito.verify(adminSubscriberMock, atLeast(1)).getName();
		Mockito.verify(adminSubscriberMock, atMost(1)).getName();
		Mockito.verify(adminSubscriberMock, times(1)).getName();
		Mockito.verify(adminSubscriberMock, times(0)).setName("test1");

		/* teardown */

	}

	/*
	 * example argument matchers
	 */
	@Test
	public void testArgumentMatcher() {

		/* setup */

		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		/* execution */
		subscriber.setName("test1");

		/* validation */

		// verify that the setName method was passed any String value
		Mockito.verify(adminSubscriberMock).setName(Mockito.anyString());

		// verify that the method was passed a String object
		Mockito.verify(adminSubscriberMock).setName(Mockito.isA(String.class));

		// verify that the method was passed any String object
		Mockito.verify(adminSubscriberMock).setName(Mockito.<String>any());

		/* teardown */

	}

	/*
	 * example argument capture
	 */
	@Test
	public void testArgumentCaptor() {

		/* setup */

		// define a captor for Strings
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		/* execution */
		subscriber.setName("test1");

		/* validation */

		// verify that setName was called, capture the parameter
		Mockito.verify(adminSubscriberMock).setName(arg.capture());

		// verify that the argument passed was test1
		assertEquals("test1", arg.getValue());

		/* teardown */

	}

	/*
	 * example exceptions
	 */
	@Test
	public void testExceptions() {

		/* setup */
		boolean exceptionOccured = false;

		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		try {
			Mockito.when(adminSubscriberMock.getId()).thenThrow(new RuntimeException());
		} catch (Exception e1) {
			fail("This should not fail");
		}

		/* execution */
		try {
			subscriber.getId();
		} catch (Exception e) {

			// expect to receive this exception
			exceptionOccured = true;
		}

		/* validation */
		assertTrue(exceptionOccured);

		/* teardown */

	}

	/*
	 * example thenAnswer
	 */
	@Test
	public void testThenAnswer() {

		Answer<Integer> answer = new Answer<Integer>() {
			int id = 0;

			@Override
			public Integer answer(InvocationOnMock arg0) throws Throwable {
				return ++id;
			}

		};
		/* setup */
		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		Mockito.when(adminSubscriberMock.getId()).thenAnswer(answer);

		/* execution */
		assertEquals(1, subscriber.getId());
		assertEquals(2, subscriber.getId());
		assertEquals(3, subscriber.getId());
		
		/* validation */

		/* teardown */

	}

	/*
	 * example callRealMethod
	 */
	@Test
	public void testCallRealMethod() {
		/* setup */

		// create a mock of the AdminSubscriber class
		AdminSubscriber adminSubscriberMock = Mockito.mock(AdminSubscriber.class);

		// Instantiate subscriber with our mock
		Subscriber subscriber = new Subscriber(adminSubscriberMock);

		Mockito.when(adminSubscriberMock.getName()).thenCallRealMethod();

		/* execution */

		// real method should be called
		String name = subscriber.getName();

		/* validation */
		assertNull(name);

		/* teardown */

	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
