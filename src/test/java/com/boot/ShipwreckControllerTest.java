package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@SuppressWarnings("deprecation")
public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);

		Shipwreck wreck = sc.get(1L);
		verify(shipwreckRepository).findOne(1L);

		// Hamcrest assertion.
		assertThat(wreck.getId(), is(1L));

		// JUnit assertion.
		// assertEquals(1L, wreck.getId().longValue());
	}

}
