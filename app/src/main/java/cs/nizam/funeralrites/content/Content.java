package cs.nizam.funeralrites.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Item> ITEMS = new ArrayList<Item>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Item> ITEM_MAP = new HashMap<String, Item>();

    private static final int COUNT = 8;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Item createItem(int position) {
        String title, detail;
        switch (position) {
            case 1:
                title = "Marana vivaram kettal";
                detail = "file:///android_asset/dua_while_listen_about.html";
                break;
            case 2:
                title = "Maricha udane";
                detail = "file:///android_asset/right_after_death.html";
                break;
            case 3:
                title = "Mayyith kulippikkal";
                detail = "file:///android_asset/bath.html";
                break;
            case 4:
                title = "Kafan cheyyal";
                detail = "file:///android_asset/clothing.html";
                break;
            case 5:
                title = "Mayyith niskaaram";
                detail = "file:///android_asset/namaz.html";
                break;
            case 6:
                title = "Kabaradakkam";
                detail = "file:///android_asset/burrial.html";
                break;
            case 7:
                title = "Kabaradakkumbol";
                detail = "file:///android_asset/while_burry.html";
                break;
            case 8:
                title = "Kabar ziyaarath";
                detail = "file:///android_asset/visiting.html";
                break;
            default:
                title = "Test";
                detail = "test";
        }
        return new Item(String.valueOf(position), title, detail);
    }

    private static String makeDetails(String detail) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(detail);
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Item {
        public final String id;
        public final String content;
        public final String details;

        public Item(String id, String content, String details) {
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
