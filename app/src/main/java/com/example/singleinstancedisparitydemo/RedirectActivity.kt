package com.example.singleinstancedisparitydemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class RedirectActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceBundle: Bundle?) {
    super.onCreate(savedInstanceBundle)

    // while this does not appear to be achieving much, handling the redirect in this way
    // ensures that we can remove the browser tab from the back stack. See the documentation
    // on AuthorizationManagementActivity for more details.
    startActivity(
      SecondActivity.createResponseHandlingIntent(
        this, intent.data
      )
    )
    finish()
  }
}
