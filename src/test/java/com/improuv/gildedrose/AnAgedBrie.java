package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class AnAgedBrie {

    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final int OLD_QUALITY = 15;
    private static final int MAX_QUALITY = 50;
    private final Item agedBrie = new Item(AGED_BRIE_NAME, 5, OLD_QUALITY);

    private void setTestData(int sellin, int quality) {
        agedBrie.setSellIn(sellin);
        agedBrie.setQuality(quality);
    }

    @Test
    public void shouldIncreaseInQualityWhileAging() {
        setTestData(5, OLD_QUALITY);
        GildedRose.with(agedBrie).updateQuality();
        assertThat(agedBrie.quality, is(OLD_QUALITY + 1));
    }

    @Test
    public void shouldDoubleItsQualityIncreaseWhenOverdue() {
        setTestData(0, OLD_QUALITY);
        GildedRose.with(agedBrie).updateQuality();
        assertThat(agedBrie.quality, is(OLD_QUALITY + 2));
    }

    @Test
    public void qualityCannotExceedMaximumQuality() {
        setTestData(5, MAX_QUALITY);
        GildedRose.with(agedBrie).updateQuality();
        assertThat(agedBrie.quality, is(not(greaterThan(MAX_QUALITY))));
    }

    @Test
    public void qualityCannotExceedMaximumQualityWhenOverdue() {
        setTestData(0, MAX_QUALITY);
        GildedRose.with(agedBrie).updateQuality();
        assertThat(agedBrie.quality, is(not(greaterThan(MAX_QUALITY))));
    }
}
