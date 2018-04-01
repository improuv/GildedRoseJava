package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;



public class TheHandOfRagnaros {

	@Test
	public void shouldNotDecreaseInQuality() throws Exception {
		Item sulfura = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		GildedRose store = GildedRose.with(sulfura);
		store.updateQuality();
		assertThat(sulfura.quality, is(greaterThanOrEqualTo(80)));
	}

	@Test
	public void shouldNotGetOlder() throws Exception {
		Item sulfura = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
		GildedRose store = GildedRose.with(sulfura);
		store.updateQuality();
		assertThat(sulfura.sellIn, is(10));
	}

}
