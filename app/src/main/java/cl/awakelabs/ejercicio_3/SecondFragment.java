package cl.awakelabs.ejercicio_3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.awakelabs.ejercicio_3.databinding.FragmentSecondBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentSecondBinding binding;
    private final int radioGroup = -1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
            mParam1 = getArguments().getString("nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater());
        binding.textName.setText("Hola, "+ mParam1);

        binding.btnAsk.setOnClickListener(view -> {
            if (binding.radGroup.getCheckedRadioButtonId() == binding.radBtn4.getId()) {
                Bundle correct = new Bundle();
                correct.putString("La Respuesta", "Correcta");
                correct.putString("nombre",mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_secondFragment_to_thirdFragment);
            } else if(binding.radGroup.getCheckedRadioButtonId() == -1){
                Toast.makeText(getContext(), "Debes seleccionar una respuesta", Toast.LENGTH_SHORT).show();
            }else {
                Bundle wrong = new Bundle();
                wrong.putString("Respuesta","Incorrecta");
                wrong.putString("nombre",mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_secondFragment_to_thirdFragment);
            }
        });
        return binding.getRoot();
    }


}