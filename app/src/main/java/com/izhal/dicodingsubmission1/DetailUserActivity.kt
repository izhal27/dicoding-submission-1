package com.izhal.dicodingsubmission1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {
  companion object {
    const val EXTRA_BUNDLE = "extra_bundle"
    const val EXTRA_USER = "extra_user"
  }

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail_user)

    val bundle = intent.getBundleExtra(EXTRA_BUNDLE)
    val user = bundle?.getParcelable<User>(EXTRA_USER)

    if (user != null) {
      img_photo.setImageResource(user.avatar)
      txt_name.text = user.name
      txt_username.text = "@${user.username}"
      txt_location.text = user.location
      txt_repository.text = user.repository
      txt_company.text = user.company
      txt_followers.text = user.followers
      txt_following.text = user.following

      val actionbar = supportActionBar
      actionbar?.title = user.name
      actionbar?.setDisplayHomeAsUpEnabled(true)
    }
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }
}