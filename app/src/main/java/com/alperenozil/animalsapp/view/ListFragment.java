package com.alperenozil.animalsapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alperenozil.animalsapp.R;
import com.alperenozil.animalsapp.model.AnimalModel;
import com.alperenozil.animalsapp.viewmodel.ListViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {
    @BindView(R.id.animalRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.listError)
    TextView listError;
    @BindView(R.id.animalList)
    RecyclerView animalList;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private ListViewModel viewModel;
    private AnimalListAdapter listAdapter=new AnimalListAdapter();

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel=ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.animals.observe(this, list -> {
            if (list!=null) {
                animalList.setVisibility(View.VISIBLE);
                listAdapter.updateAnimalList(list);
            }
        });
        viewModel.loading.observe(this, loading -> {
            progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
            if (loading) {
                listError.setVisibility(View.GONE);
                animalList.setVisibility(View.GONE);
            }
        });
        viewModel.loadError.observe(this, error -> {
            listError.setVisibility(error ? View.VISIBLE : View.GONE);
        });
        viewModel.refresh();
        if (animalList!=null) {
            animalList.setLayoutManager(new GridLayoutManager(getContext(),2));
            animalList.setAdapter(listAdapter);
        }
        swipeRefreshLayout.setOnRefreshListener(() -> {
            animalList.setVisibility(View.GONE);
            listError.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            viewModel.refresh();
            swipeRefreshLayout.setRefreshing(false);
        });
    }
}