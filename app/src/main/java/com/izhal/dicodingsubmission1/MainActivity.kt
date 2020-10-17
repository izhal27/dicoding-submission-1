package com.izhal.dicodingsubmission1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  private lateinit var adapter: UserAdapter
  private lateinit var dataName: Array<String>
  private lateinit var dataUsername: Array<String>
  private lateinit var dataLocation: Array<String>
  private lateinit var dataRepository: Array<String>
  private lateinit var dataCompany: Array<String>
  private lateinit var dataFollowers: Array<String>
  private lateinit var dataFollowing: Array<String>
  private lateinit var dataAvatar: TypedArray
  private var users = arrayListOf<User>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    adapter = UserAdapter(this)
    lv_users.adapter = adapter
    lv_users.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
      val bundle = Bundle()
      bundle.putParcelable(DetailUserActivity.EXTRA_USER, users[position])
      val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
      intent.putExtra(DetailUserActivity.EXTRA_BUNDLE, bundle)
      startActivity(intent)
    }

    init()
    addUser()
  }

  private fun init() {
    dataName = resources.getStringArray(R.array.name)
    dataUsername = resources.getStringArray(R.array.username)
    dataLocation = resources.getStringArray(R.array.location)
    dataRepository = resources.getStringArray(R.array.repository)
    dataCompany = resources.getStringArray(R.array.company)
    dataFollowers = resources.getStringArray(R.array.followers)
    dataFollowing = resources.getStringArray(R.array.following)
    dataAvatar = resources.obtainTypedArray(R.array.avatar)
  }

  private fun addUser() {
    for (i in dataName.indices) {
      val user = User(
        dataName[i],
        dataUsername[i],
        dataLocation[i],
        dataRepository[i],
        dataCompany[i],
        dataFollowers[i],
        dataFollowing[i],
        dataAvatar.getResourceId(i, -1)
      )

      users.add(user)
    }

    adapter.users = users
  }
}