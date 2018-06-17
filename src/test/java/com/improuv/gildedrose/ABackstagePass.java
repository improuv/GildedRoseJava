package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;


public class ABackstagePass {

	@Test
	public void with11DaysShouldIncreaseQualityByOne() {
		// Arrange
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30);
		GildedRose store = GildedRose.with(backstagePass);
		// Act
		store.updateQuality();
		// Assert
		assertThat(backstagePass.quality, is(31));
	}

	@Test
	public void with10DaysShouldIncreaseQualityByTwo() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(32));
	}

	@Test
	public void with6DaysShouldIncreaseQualityByTwo() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 30);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(32));
	}

	@Test
	public void with5DaysShouldIncreaseQualityByThree() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(33));
	}

	@Test
	public void shouldHaveZeroQualityWhenTheConcertIsOver() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(GildedRoseTest.MIN_QUALITY));
	}

	@Test
	public void qualityCannotExceedMaximumQuality() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(not(greaterThan(50))));
	}

	@Test
	public void qualityCannotExceedMinimumQuality() {
		Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, -50);
		GildedRose store = GildedRose.with(backstagePass);
		store.updateQuality();
		assertThat(backstagePass.quality, is(lessThan(0)));
	}
}
