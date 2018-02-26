package edu.cnm.deepdive.fragmentparams;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParameterizedFragment extends Fragment {

  // These are the keys that will be used to put and get argument values for instances of this fragment class.
  public static final String TEXT_ARG_KEY = "replaceable_text";
  public static final String COLOR_ARG_KEY = "replaceable_color";

  private String replaceableText;
  private int replaceableColor;

  public ParameterizedFragment() {
    // Required empty public constructor
  }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = getArguments();
    if (bundle == null) {
      bundle = new Bundle();
    }
    // Retrieve argument values (or default values) from the bundle.
    replaceableText = bundle.getString(TEXT_ARG_KEY, "You didn't tell me anything!");
    replaceableColor = bundle.getInt(COLOR_ARG_KEY, Color.CYAN);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_parameterized, container, false);
    view.setBackgroundColor(replaceableColor);
    // Set the values in the fragment layout from the arguments retrieved in onCreate().
    TextView tv = view.findViewById(R.id.replaceable_text);
    tv.setText(replaceableText);
    return view;
  }

}
