package com.example.mvvmrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import com.example.mvvmrecylerview.adapters.RecyclerAdapter;
import com.example.mvvmrecylerview.databinding.ActivityMainBinding;
import com.example.mvvmrecylerview.models.User;
import com.example.mvvmrecylerview.viewmodels.MainActivityViewModel;



//************************************************************
public class MainActivity extends AppCompatActivity
//************************************************************
{

    ActivityMainBinding mBinding;
    private RecyclerAdapter mAdapter;
    private MainActivityViewModel mMainActivityViewModel;
    //************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    //************************************************************
    {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mMainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();

        mMainActivityViewModel.getList().observe(this, users -> mAdapter.notifyDataSetChanged());

        mMainActivityViewModel.getIsUpdating().observe(this, aBoolean -> {
            if (aBoolean){
                mBinding.progressbar.setVisibility(View.VISIBLE);
            }

            else
            {
                mBinding.progressbar.setVisibility(View.GONE);
                mBinding.rvList.smoothScrollToPosition(mMainActivityViewModel.getList().getValue().size()-1);

            }
        });
        initRecyclerView();

        mBinding.fab.setOnClickListener(view -> mMainActivityViewModel.addNewValue(new User(
                "Basit Ali Hashmi"
                ,"https://www.testim.io/wp-content/uploads/2019/11/Testim-What-is-a-Test-Environment_-A-Guide-to-Managing-Your-Testing-A.png")));
    }


    //************************************************************
    private void initRecyclerView()
    //************************************************************
    {
        mAdapter = new RecyclerAdapter(mMainActivityViewModel.getList().getValue(), this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mBinding.rvList.setLayoutManager(linearLayoutManager);
        mBinding.rvList.setAdapter(mAdapter);
    }
}