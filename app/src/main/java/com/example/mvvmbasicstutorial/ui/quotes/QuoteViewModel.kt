package com.example.mvvmbasicstutorial.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmbasicstutorial.data.Quote
import com.example.mvvmbasicstutorial.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel(){
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}