package com.example.mvvmbasicstutorial.utilities

import com.example.mvvmbasicstutorial.data.FakeDatabase
import com.example.mvvmbasicstutorial.data.QuoteRepository
import com.example.mvvmbasicstutorial.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun providerQuotesViewModelFactory() : QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}