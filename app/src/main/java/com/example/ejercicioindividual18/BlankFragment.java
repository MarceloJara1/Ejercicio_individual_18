package com.example.ejercicioindividual18;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicioindividual18.databinding.FragmentBlankBinding;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment implements MyAdapter.OnItemClickListener {

    private FragmentBlankBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlankBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        //Datos de ejemplo
        List<ImageItem> imageItems = new ArrayList<>();
        imageItems.add(new ImageItem("https://static.wikia.nocookie.net/sherlockholmes/images/e/eb/Sherlock_cuarta_temporada.jpg/revision/latest?cb=20170111174244&path-prefix=es", "William Sherlock Scott Holmes es el protagonista principal de la serie Sherlock.","Sherlock Holmes"));
        imageItems.add(new ImageItem("https://static.wikia.nocookie.net/sherlockholmes/images/7/70/John_Watson_Freeman_cuarta_temporada.jpg/revision/latest?cb=20170111174556&path-prefix=es", "El doctor John Hamish Watson es un antiguo médico del ejército, mejor amigo y ayudante de Sherlock Holmes.", "John Watson"));
        imageItems.add(new ImageItem("https://static.wikia.nocookie.net/sherlockholmes/images/4/47/Jim_Moriarty.jpg/revision/latest/scale-to-width-down/333?cb=20140110185928&path-prefix=es", "James Moriarty (1976-2012), se trata del único criminal consultor del mundo.", "Jim Moriarty"));
        imageItems.add(new ImageItem("https://static.wikia.nocookie.net/sherlockholmes/images/5/56/Mycroft_Sherlock.jpg/revision/latest?cb=20140110184815&path-prefix=es", "Mycroft Holmes es el hermano mayor de Sherlock Holmes.", "Mycroft Holmes"));
        imageItems.add(new ImageItem("https://static.wikia.nocookie.net/sherlockholmes/images/e/e5/Lestrade_Sherlock.jpg/revision/latest/scale-to-width-down/350?cb=20140110183947&path-prefix=es", "Greg Lestrade es un detective inspector que trabaja en New Scotland Yard. Suele necesitar la ayuda de Sherlock Holmes para resolver algunos de sus casos.", "Greg Lestrade"));


        //Configurar el RecyclerView con el adaptador
        MyAdapter adapter = new MyAdapter(requireContext(), imageItems);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);

        //navegar al segundo fragmento
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ImageItem item) {
                //Obtener el navController
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView);

                //Crear el bundle con los datos a pasar al segundo fragmento
                Bundle bundle = new Bundle();
                bundle.putString("image_url", item.getImageUrl());
                bundle.putString("description",item.getDescription());

                //Realizar la navegacion al segundo fragmento
                navController.navigate(R.id.action_blankFragment_to_blankFragment2, bundle);

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(ImageItem item) {

    }
}