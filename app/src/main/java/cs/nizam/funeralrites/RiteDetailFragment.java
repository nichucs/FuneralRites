package cs.nizam.funeralrites;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import cs.nizam.funeralrites.content.Content;

/**
 * A fragment representing a single Rite detail screen.
 * This fragment is either contained in a {@link RiteListActivity}
 * in two-pane mode (on tablets) or a {@link RiteDetailActivity}
 * on handsets.
 */
public class RiteDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    private static final String ENCODING_AUTO_DETECTED = "auto-detector";

    /**
     * The dummy content this fragment is presenting.
     */
    private Content.Item mItem;
    private WebView mWebView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RiteDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CookieSyncManager.createInstance(getContext());

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(getResources().getString(mItem.content));
//                appBarLayout.setExpandedTitleTypeface(Typeface.createFromAsset(activity.getAssets(), "karthika.ttf"));
//                appBarLayout.setCollapsedTitleTypeface(Typeface.createFromAsset(activity.getAssets(), "karthika.ttf"));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rite_detail, container, false);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            mWebView = (WebView) rootView.findViewById(R.id.rite_detail);
            mWebView.setWebChromeClient(new WebChromeClient());
            /*final WebSettings s = mWebView.getSettings();
            s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            s.setUseWideViewPort(true);
            s.setSavePassword(false);
            s.setSaveFormData(false);
            s.setBlockNetworkLoads(true);
            s.setDefaultTextEncodingName(ENCODING_AUTO_DETECTED);
            s.setJavaScriptEnabled(false);*/
            mWebView.loadUrl(mItem.details);
        }

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    public void onStop() {
        super.onStop();
        CookieSyncManager.getInstance().stopSync();
        this.mWebView.stopLoading();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mWebView.destroy();
    }
}
