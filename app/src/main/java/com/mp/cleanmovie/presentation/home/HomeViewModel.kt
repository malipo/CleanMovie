package com.mp.cleanmovie.presentation.home

import androidx.lifecycle.ViewModel
import com.mp.cleanmovie.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val homeRepositoryImp: HomeRepository,
) :
    ViewModel()
{


}
