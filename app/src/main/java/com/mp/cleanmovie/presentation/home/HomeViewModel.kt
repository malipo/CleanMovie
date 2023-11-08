package com.mp.cleanmovie.presentation.home

import androidx.lifecycle.ViewModel
import com.mp.cleanmovie.movieList.domain.repository.MovieListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val movieListRepositoryImp: MovieListRepository,
) :
    ViewModel()
{


}
