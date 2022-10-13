package com.example.MakeupProducts.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.MakeupProducts.model.DataUsed
import com.example.MakeupProducts.repository.DataRepo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
//observing livedata here
class MakeUpViewModel @Inject constructor(private val dataRepo: DataRepo): ViewModel() {

    val responseData : LiveData<List<DataUsed>> =dataRepo.getPost1()

    .catch {  ERROR ->
            Log.d("tag", " Error : ${ERROR.message}")
        }.asLiveData()

}




