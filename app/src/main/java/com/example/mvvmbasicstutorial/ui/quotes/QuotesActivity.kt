package com.example.mvvmbasicstutorial.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasicstutorial.data.Quote
import com.example.mvvmbasicstutorial.databinding.ActivityQuotesBinding
import com.example.mvvmbasicstutorial.utilities.InjectorUtils
import java.lang.StringBuilder

// This is the View
class QuotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeUi(binding)
    }

    private fun initializeUi(binding: ActivityQuotesBinding) {
        val factory = InjectorUtils.providerQuotesViewModelFactory()
        // Deprecated
//        val viewModel = ViewModelProviders.of(this, factory).get(QuoteViewModel::class.java)
        val viewModel = ViewModelProvider(this, factory).get(QuoteViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote -> stringBuilder.append("$quote\n\n") }
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(binding.editTextQuote.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}