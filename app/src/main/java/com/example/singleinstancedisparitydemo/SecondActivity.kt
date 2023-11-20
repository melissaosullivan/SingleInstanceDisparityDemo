package com.example.singleinstancedisparitydemo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.example.singleinstancedisparitydemo.databinding.SecondActivityBinding
import com.google.android.material.snackbar.Snackbar


class SecondActivity : AppCompatActivity() {

  private lateinit var binding: SecondActivityBinding

  companion object {
    fun createResponseHandlingIntent(context: Context, responseUri: Uri?): Intent? {
      val intent = createBaseIntent(context)
      intent.data = responseUri
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
      return intent
    }

    private fun createBaseIntent(context: Context): Intent {
      return Intent(context, SecondActivity::class.java)
    }
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = SecondActivityBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    binding.fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
    }

    binding.launchCustomTabButton.setOnClickListener { view ->
      val url = "https://suave-clear-pan.glitch.me/"
      /*val intent = CustomTabsIntent.Builder()
        .build()
      intent.launchUrl(this@SecondActivity, Uri.parse(url))*/
      startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
  }
}
