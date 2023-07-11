package cl.awakelabs.ejercicio_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.awakelabs.ejercicio_3.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private String paramNombre;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("Nombre");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentFirstBinding.inflate(getLayoutInflater(),container,false);
       binding.btnStart.setOnClickListener(view -> {
           String name = binding.editTextName.getText().toString();
           Bundle bundle = new Bundle();
           bundle.putString("nombre",name);
           Navigation.findNavController(getView()).navigate(R.id.action_firstFragment_to_secondFragment,bundle);
       });

       return binding.getRoot();
    }
}