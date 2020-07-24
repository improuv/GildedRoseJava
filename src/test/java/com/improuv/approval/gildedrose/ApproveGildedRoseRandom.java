package com.improuv.approval.gildedrose;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.approvaltests.Approvals;
import org.junit.Before;
import org.junit.Test;

import com.improuv.gildedrose.GildedRose;
import com.improuv.gildedrose.Item;

public class ApproveGildedRoseRandom {

    private static final int NUMBER_OF_INPUTS = 20000;
    private static final int MIN_SELLIN = -5;
    private static final int MAX_SELLIN = 20;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 80;
    private Random random;
	private String[] names = {
			"Aged Brie",
			"Backstage passes to a TAFKAL80ETC concert",
			"Sulfuras, Hand of Ragnaros", 
			"+5 Dexterity Vest",
			"Conjured Mana Cake",
			"Elixir of the Mongoose"
			};

    @Before
    public void initialize() {
        random = new Random(202020);
    }

    // @Test
    public void approve() {
        Item[] items = generateItems();
        GildedRose.with(items).updateQuality();
        Approvals.verifyAll("items", items);
    }

    private Item[] generateItems() {
    	return IntStream.range(0,NUMBER_OF_INPUTS)
    			.mapToObj(i -> new Item(nextName(), nextSellIn(), nextItemQuality()))
    			.collect(Collectors.toList())
    			.toArray(new Item[0]);
    }

    private int nextItemQuality() {
        return MIN_QUALITY + random.nextInt(MAX_QUALITY - MIN_QUALITY);
    }

    private int nextSellIn() {
        return MIN_SELLIN + random.nextInt(MAX_SELLIN - MIN_SELLIN);
    }

    private String nextName() {
        return names[random.nextInt(names.length)];
    }
}
