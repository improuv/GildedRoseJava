package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;


public class AnAgedBrie {

	Item daGschdingadeKaas;
	int oldQuality = 15;

	@Before
	public void setUp() {
		daGschdingadeKaas = new Item("Aged Brie", 0, oldQuality);
	}

	@Test
	public void shouldIncreaseInQualityWhileAging() {
		daGschdingadeKaas.sellIn = 15;
		GildedRose store = GildedRose.with(daGschdingadeKaas);
		store.updateQuality();

		assertThat(daGschdingadeKaas.quality, is(oldQuality + 1));
	}

	@Test
	public void shouldDoubleItsQualityIncreaseWhenOverdue() {
		daGschdingadeKaas.sellIn = -5;
		GildedRose store = GildedRose.with(daGschdingadeKaas);
		store.updateQuality();

		assertThat(daGschdingadeKaas.quality, is(oldQuality + 2));
	}

	@Test
	public void qualityCannotExceedMaximumQuality() {
		daGschdingadeKaas.quality = 50;
		GildedRose store = GildedRose.with(daGschdingadeKaas);
		store.updateQuality();
		assertThat(daGschdingadeKaas.quality, is(not(greaterThan(50))));
	}
}
