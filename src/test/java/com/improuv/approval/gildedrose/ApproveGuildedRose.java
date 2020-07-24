package com.improuv.approval.gildedrose;

import org.approvaltests.Approvals;
import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;

public class ApproveGuildedRose {

    private static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    //@Test 
    public void approve()
    {
        final Item[] items = new Item[] {
                new Item("Item", 100, 1),
                new Item("Item", 0, 10),
                new Item("Item", 1000, MIN_QUALITY),
                new Item("Item", 14, MAX_QUALITY),
                new Item("Item", 0, MIN_QUALITY),
                new Item(SULFURAS_NAME, 5, 80),
                new Item(SULFURAS_NAME, -1, 80),
                new Item(AGED_BRIE_NAME, 5, 15),
                new Item(AGED_BRIE_NAME, 0, 15),
                new Item(AGED_BRIE_NAME, 5, MAX_QUALITY),
                new Item(AGED_BRIE_NAME, 0, MAX_QUALITY),
                new Item(BACKSTAGE_PASS_NAME, 11, 30),
                new Item(BACKSTAGE_PASS_NAME, 10, 30),
                new Item(BACKSTAGE_PASS_NAME, 6, 30),
                new Item(BACKSTAGE_PASS_NAME, 5, 30),
                new Item(BACKSTAGE_PASS_NAME, 0, 30),
                new Item(BACKSTAGE_PASS_NAME, 5, 50),
                new Item(BACKSTAGE_PASS_NAME, 5, 49),
                new Item(BACKSTAGE_PASS_NAME, -1, 10),

        };
        final GildedRose gildedRose = GildedRose.with(items);
        gildedRose.updateQuality();
        Approvals.verifyAll("", items);
    }
}
