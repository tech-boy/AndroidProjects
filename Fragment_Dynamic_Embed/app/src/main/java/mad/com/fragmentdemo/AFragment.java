package mad.com.fragmentdemo;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    public AFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("demo","AFragment: onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    public void changeColor(int color){
        getView().setBackgroundColor(color);  //change color of frameloayout
        // getActivity().findViewById(R.id.fragmentRoot).setBackgroundColor(color);  //change color of inner linear layout
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("demo","AFragment: onCreate");
    }

    OnFragmentTextChange mListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("demo","AFragment: onAttach");

        try{
            mListener = (OnFragmentTextChange) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "should implement OnFragmentTextChange");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().findViewById(R.id.buttonInFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText) getView().findViewById(R.id.editTextInFragment);
                mListener.onTextChanged(et.getText().toString());
            }
        });
    }

    public interface OnFragmentTextChange{
        void onTextChanged(String text);
    }
}
