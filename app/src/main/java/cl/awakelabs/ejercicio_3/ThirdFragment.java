package cl.awakelabs.ejercicio_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import cl.awakelabs.ejercicio_3.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "resultado";


    // TODO: Rename and change types of parameters
    private String nomParam;
    private String resParam;
    private FragmentThirdBinding binding;
    public ThirdFragment() {
        // Required empty public constructor
    }
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nomParam = getArguments().getString(ARG_PARAM1);
            resParam = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentThirdBinding.inflate(getLayoutInflater(), container, false);

        binding.textResp.setText("Correcto"+ nomParam);

        binding.btnBack.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", nomParam);
            Navigation.findNavController(getView()).navigate(R.id.action_thirdFragment_to_secondFragment);
        });
        return binding.getRoot();
    }

}