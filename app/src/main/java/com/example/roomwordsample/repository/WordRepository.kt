package com.example.roomwordsample.repository

import com.example.roomwordsample.dao.WordDao
import com.example.roomwordsample.model.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}