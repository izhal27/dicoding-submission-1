package com.izhal.dicodingsubmission1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
  val name: String,
  val username: String,
  val location: String,
  val repository: String,
  val company: String,
  val followers: String,
  val following: String,
  val avatar: Int
) : Parcelable