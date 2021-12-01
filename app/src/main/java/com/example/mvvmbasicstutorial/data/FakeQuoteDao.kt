package com.example.mvvmbasicstutorial.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        // refresh of the quotes that will trigger the live data
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}