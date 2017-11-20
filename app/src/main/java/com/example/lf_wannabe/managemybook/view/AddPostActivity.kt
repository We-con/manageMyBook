package com.example.lf_wannabe.managemybook.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.lf_wannabe.managemybook.BaseActivity
import com.example.lf_wannabe.managemybook.R
import com.example.lf_wannabe.managemybook.commons.imagePicker.PickerBuilder
import com.example.lf_wannabe.managemybook.commons.imagePicker.PickerManager
import com.yalantis.ucrop.UCrop
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_add_post.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.File
import java.io.FileOutputStream

/**
 * Created by lf_wannabe on 12/11/2017.
 */
class AddPostActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        initToolbar()
        initWheelView()

        addPostImgCamera.setOnClickListener {
            PickerBuilder(this, PickerBuilder.SELECT_FROM_CAMERA)
                    .setOnImageReceivedListener(
                        object: PickerManager.onImageReceivedListener{
                            override fun onImageReceived(imageUri: Uri) {
                                applyImage(imageUri)
                            }
                        })
                    .start()

        }

        addPostImgGalary.setOnClickListener {
            PickerBuilder(this, PickerBuilder.SELECT_FROM_GALLERY)
                    .setOnImageReceivedListener(
                        object: PickerManager.onImageReceivedListener{
                            override fun onImageReceived(imageUri: Uri) {
                                applyImage(imageUri)
                            }
                        })
                    .start()
        }
    }


    fun initWheelView(){
        var list: ArrayList<String> = ArrayList()
        // ㅎㅎ;
        Observable.range(1, 1000)
                .map { i -> i.toString() }
                .subscribe{ i -> list.add(i)}

        addPostWheelView.items = list
        addPostWheelView.setAdditionCenterMark(".p")
    }

    override fun initToolbar() {
        setTitle("포스트 입력")
        setNavi()
        setConfirmAction {
            saveBitmapToFileCache(getBitmapOfView(testSave))
        }
    }

    private fun applyImage(imageUri: Uri){
        testSave.setImageURI(imageUri)
        testSave.visibility = View.VISIBLE
        addPostBtnContainer.visibility = View.GONE

    }

    private fun getBitmapOfView(view: View): Bitmap {
        view.destroyDrawingCache()
        view.buildDrawingCache()
        var orig = view.drawingCache
        var config: Bitmap.Config? = null

        orig?.let {
            config = it.config
        }.let {
            config = Bitmap.Config.ARGB_8888
        }
        var b = orig.copy(config, false)
        view.destroyDrawingCache()

        return b
    }

    private fun getAlbumStorageDir(context: Context, albumName: String): File {
        // Get the directory for the app's private pictures directory.
        val file = File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), albumName)
        if (!file.mkdirs()) {
            Log.e("MIM_POST_ADD_ACTIVITY", "Directory not created")
        }
        return file
    }

    private fun saveBitmapToFileCache(bitmap: Bitmap){
//        var imagePathStr = "${Environment.getExternalStorageDirectory()}" +
//                "/${Environment.DIRECTORY_DCIM}/${getString(R.string.app_name)}"
//
//        var path = File(imagePathStr)
//        if (!path.exists()) path.mkdir()

        var path = getAlbumStorageDir(applicationContext, getString(R.string.app_name))
        var finalPhotoName = "TEST_SAVE.jpg"

        var fileCacheItem = File(path, finalPhotoName)
        var fos: FileOutputStream? = null

        try {
            fos = FileOutputStream(fileCacheItem)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fileCacheItem.createNewFile()
            fos.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK){
            Log.d("MIM", resultCode.toString())
            finish()
            return
        }

        when(requestCode){
            PickerManager.REQUEST_CODE_SELECT_IMAGE -> {
                data?. let {
                    PickerBuilder.pickerInstance.mProcessingPhotoUri = data.data
                    Log.d("MIM", data.data.toString())
                }

//                PickerBuilder.pickerInstance.handleCropResult()
                PickerBuilder.pickerInstance.startCropActivity()
            }

            UCrop.REQUEST_CROP -> {
                PickerBuilder.pickerInstance.handleCropResult()
            }
        }
    }
}