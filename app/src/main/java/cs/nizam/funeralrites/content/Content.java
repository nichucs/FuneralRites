package cs.nizam.funeralrites.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs.nizam.funeralrites.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
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

    private static final int COUNT = 12;

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
        int title;
        String detail;
        switch (position) {
            case 1:
                title = R.string.aamugham;
                detail = "file:///android_asset/intro.html";
                break;
            case 2:
                title = R.string.manarasmarana;
                detail = "file:///android_asset/be_ready.html";
                break;
            case 3:
                title = R.string.marana_vivaram_kettal;
                detail = "file:///android_asset/dua_while_listen_about.html";
                break;
            case 4:
                title = R.string.maricha_udane;
                detail = "file:///android_asset/right_after_death.html";
                break;
            case 5:
                title = R.string.mayyith_kulippikkal;
                detail = "file:///android_asset/bath.html";
                break;
            case 6:
                title = R.string.kafan_cheyyal;
                detail = "file:///android_asset/clothing.html";
                break;
            case 7:
                title = R.string.niskaaram;
                detail = "file:///android_asset/namaz.html";
                break;
            case 8:
                title = R.string.janaza;
                detail = "file:///android_asset/janaza.html";
                break;
            case 9:
                title = R.string.kabaradakkam;
                detail = "file:///android_asset/burrial.html";
                break;
            case 10:
                title = R.string.kabaradakkumbol;
                detail = "file:///android_asset/while_burry.html";
                break;
            case 11:
                title = R.string.ziyarath;
                detail = "file:///android_asset/visiting.html";
                break;
            case 12:
                title = R.string.anantharam;
                detail = "file:///android_asset/after_all.html";
                break;
            default:
                title = R.string.app_name;
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
        public final int content;
        public final String details;

        public Item(String id, int content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

    }
}
