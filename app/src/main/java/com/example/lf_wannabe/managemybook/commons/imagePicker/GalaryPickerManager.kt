package com.example.lf_wannabe.managemybook.commons.imagePicker

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore

/**
 * Created by lf_wannabe on 20/11/2017.
 */
class GalaryPickerManager(ac: Activity): PickerManager(ac){
    override fun sendToExternalApp() {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")

        ac.startActivityForResult(Intent.createChooser(intent, "선택해주세요"),
                REQUEST_CODE_SELECT_IMAGE)
    }
}