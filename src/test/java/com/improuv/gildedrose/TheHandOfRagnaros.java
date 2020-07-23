package com.improuv.gildedrose;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class TheHandOfRagnaros {

    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    final Item sulfura = new Item(SULFURAS_NAME, 5, 80);

    private void setTestData(int sellin) {
        sulfura.setSellIn(sellin);
    }
    @Test
    public void shouldNotDecreaseInQuality() {
        setTestData(5);
        GildedRose.with(sulfura).updateQuality();
        assertThat(sulfura.quality, is(greaterThanOrEqualTo(80)));
    }

    @Test
    public void shouldNotDecreaseInQualityWithNegativeSellIn() {
        setTestData(-1);
        GildedRose.with(sulfura).updateQuality();
        assertThat(sulfura.quality, is(greaterThanOrEqualTo(80)));
    }

    @Test
    public void shouldNotGetOlder() {
        setTestData(10);
        GildedRose.with(sulfura).updateQuality();
        assertThat(sulfura.sellIn, is(10));
    }

}
