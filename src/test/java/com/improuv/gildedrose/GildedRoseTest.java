package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;



public class GildedRoseTest {
	static final int MIN_QUALITY = 0;

	static final int MAX_QUALITY = 50;


	Item oldBoots;
	int bootSellIn = 100;
	int bootQuality = 1;

	Item overdueMustardYoghurt;
	int overdueMustardYoghurtQuality = 10;

	@Before
	public void setUp() {

		oldBoots = new Item("Boot", bootSellIn, bootQuality);
		overdueMustardYoghurt = new Item("Mustard-Yoghurt", 0, overdueMustardYoghurtQuality);
	}

	@Test
	public void testTheTruth() {
		assertThat(true, is(not(not(true))));
	}

	@Test
	public void atEndOfTheDayItemQualityShouldBeDecreasedByOne() {
		GildedRose store = GildedRose.with(oldBoots);
		store.updateQuality();

		assertThat(oldBoots.quality, is(bootQuality - 1));
	}

	@Test
	public void atEndOfTheDayItemSellInShouldBeDecreasedByOne() {
		GildedRose store = GildedRose.with(oldBoots);
		store.updateQuality();

		assertThat(oldBoots.sellIn, is(bootSellIn - 1));
	}

	@Test
	public void atEndOfTheDayItemQualityShouldBeDecreasedByTwoWhenSellInDateHasPassed() {
		GildedRose store = GildedRose.with(overdueMustardYoghurt);
		store.updateQuality();

		assertThat(overdueMustardYoghurt.quality, is(overdueMustardYoghurtQuality - 2));
	}

	@Test
	public void qualityCanNeverBeDecreasedBelowMinimumQuality() {
		Item deOideLederhosn = new Item("Lederhose", 1000, MIN_QUALITY);
		GildedRose store = GildedRose.with(deOideLederhosn);
		store.updateQuality();

		assertThat(deOideLederhosn.quality, is(greaterThanOrEqualTo(MIN_QUALITY)));
	}

	@Test
	public void qualityCannotExceedMaximumQuality() {
		Item goldenSunWatch = new Item("Golden Pocket Sun Watch", 14, MAX_QUALITY);
		GildedRose store = GildedRose.with(goldenSunWatch);
		store.updateQuality();
		assertThat(goldenSunWatch.quality, is(not(greaterThan(MAX_QUALITY))));
	}

}
