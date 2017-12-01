package com.wecon.lf_wannabe.walkonnovel.view

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import com.wecon.lf_wannabe.walkonnovel.BaseActivity
import com.wecon.lf_wannabe.walkonnovel.R
import com.wecon.lf_wannabe.walkonnovel.commons.imagePicker.PickerBuilder
import com.wecon.lf_wannabe.walkonnovel.commons.imagePicker.PickerManager
import com.yalantis.ucrop.UCrop
import kotlinx.android.synthetic.main.activity_new_add_post.*
import java.io.File
import java.io.FileOutputStream
import android.graphics.Point
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.lantouzi.wheelview.WheelView
import com.wecon.lf_wannabe.walkonnovel.viewmodel.BookViewModel
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*

class NewPostAddActivity: BaseActivity() {
    private lateinit var bookVM: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_add_post)

        bookVM = ViewModelProviders.of(this).get(BookViewModel::class.java)
        // TODO : get Book by intent

        initToolbar()
        addPostDateText.text = SimpleDateFormat("yyyy년 MM월 dd일 / ").format(Calendar.getInstance().time)

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

        // TODO : 더 좋은 방법 없나?
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        addPostBtnContainer.layoutParams.height = width
        addPostSelectedImage.layoutParams.height = width

        addPostPageText.setOnClickListener {
            var selectedPage = 1
            var dialog = MaterialDialog.Builder(this@NewPostAddActivity)
                    .title(R.string.add_post_dialog_title)
                    .customView(R.layout.wheelview, false)
                    .positiveText(R.string.add_post_dialog_agree)
                    .negativeText(R.string.add_post_dialog_disagree)
                    .onPositive(MaterialDialog.SingleButtonCallback {
                        dialog, which ->
                        addPostPageText.text = "${selectedPage.toString()} 쪽 "
                    })
                    .show()

            dialog.customView?. let {
                it.findViewById<WheelView>(R.id.addPostWheelView).apply {
                    var list: ArrayList<String> = ArrayList()
                    Observable.range(1, 1000)
                            .map { i -> i.toString() }
                            .subscribe{ i -> list.add(i)}

                    items = list
                    setAdditionCenterMark(".p")
                    setOnWheelItemSelectedListener(object: WheelView.OnWheelItemSelectedListener {
                        override fun onWheelItemSelected(wheelView: WheelView?, position: Int) {
                            selectedPage = position+1
                        }

                        override fun onWheelItemChanged(wheelView: WheelView?, position: Int) {

                        }
                    })
                }
            }
        }



    }

    override fun initToolbar() {
        setTitle("포스트 입력")
        setNavi()
        setConfirmAction {
            makePost()
        }
    }

    private fun makePost() {
        // TODO : bing data on Post
        saveBitmapToFileCache(getBitmapOfView(addPostSelectedImage))
    }

    private fun applyImage(imageUri: Uri){
        addPostSelectedImage.setImageURI(imageUri)
        addPostSelectedImage.visibility = View.VISIBLE
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

    private fun saveBitmapToFileCache(bitmap: Bitmap): String {
        var path = getAlbumStorageDir(applicationContext, getString(R.string.app_name))
        // TODO : 날짜로 식별할 것
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

        return fileCacheItem.toURI().toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK){
            return
        }

        when(requestCode){
            PickerManager.REQUEST_CODE_SELECT_IMAGE -> {
                data?. let {
                    PickerBuilder.pickerInstance.mProcessingPhotoUri = data.data
                    Log.d("MIM", data.data.toString())
                }

                PickerBuilder.startCropActivity()
            }

            UCrop.REQUEST_CROP -> {
                PickerBuilder.apply()
            }
        }
    }
}
