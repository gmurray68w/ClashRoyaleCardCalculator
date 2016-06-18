package com.murraystudios.graham.clashroyalecardcalculator.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CardItem> ITEMS = new ArrayList<CardItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CardItem> ITEM_MAP = new HashMap<String, CardItem>();

    private static final int COUNT = 15;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCardItem(i));
        }
    }

    private static void addItem(CardItem card) {
        ITEMS.add(card);
        ITEM_MAP.put(card.id, card);
    }

    private static CardItem createCardItem(int position) {
        return new CardItem(String.valueOf(position), "Card" + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("CARD QUOTE GOES HERE ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nCARD INFO HERE");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CardItem {
        public final String id;
        public final String content;
        public final String details;

        public CardItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
