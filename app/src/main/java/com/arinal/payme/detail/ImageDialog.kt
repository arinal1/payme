package com.arinal.payme.detail

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.arinal.payme.R
import kotlinx.android.synthetic.main.dialog_image.*

class ImageDialog(ctx: Context, private val img: Int): Dialog(ctx){

    init {
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_image)
        myZoomageView.setImageResource(img)
    }
}