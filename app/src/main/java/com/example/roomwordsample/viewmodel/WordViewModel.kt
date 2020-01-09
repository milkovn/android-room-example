package com.example.roomwordsample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomwordsample.model.Word
import com.example.roomwordsample.repository.WordRepository
import com.example.roomwordsample.room.WordRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository

    val allWords: LiveData<List<Word>>

    init {
        val wordDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}
