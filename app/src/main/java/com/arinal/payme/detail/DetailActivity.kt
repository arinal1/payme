package com.arinal.payme.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arinal.payme.Data
import com.arinal.payme.R
import kotlinx.android.synthetic.main.activity_detail.*
import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initData()
    }

    private fun initData(){
        val data = intent.getSerializableExtra("data") as Data
        val imageDialog = ImageDialog(this, data.qr)
        imgQr.setImageResource(data.qr)
        txService.text = data.serviceName
        txName.text = data.name
        txAccount.text = data.account
        btnCopy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(label.toString(), data.account)
            clipboard.primaryClip = clip
            showToast("Text berhasil disalin")
        }
        btnOpenApp.setOnClickListener {
            val launchIntent = packageManager.getLaunchIntentForPackage(data.appName)
            if (launchIntent != null) startActivity(launchIntent)
            else showToast("Aplikasi ${data.serviceName} tidak terinstall")
        }
        back.setOnClickListener { finish() }
        imgQr.setOnClickListener { imageDialog.show() }
    }

    private fun showToast(text: String){Toast.makeText(this, text, Toast.LENGTH_LONG).show()}
}
