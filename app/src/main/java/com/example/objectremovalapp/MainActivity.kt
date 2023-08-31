package com.example.objectremovalapp
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.media.ThumbnailUtils
//import androidx.navigation.Navigation.findNavController
//import androidx.navigation.fragment.findNavController
//import androidx.fragment.app.Fragment
//import androidx.navigation.NavController
//import androidx.navigation.Navigation
//import androidx.navigation.ui.NavigationUI



class MainActivity : AppCompatActivity() {

    lateinit var filepath : Uri

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.selectbutton)
            .setOnClickListener {
                startFileChooser()
            }

        findViewById<Button>(R.id.playbutton)
            .setOnClickListener {
                startVideoPlayback()
            }

        findViewById<Button>(R.id.pausebutton)
            .setOnClickListener {
                PauseVideoPlayback()
            }

        findViewById<Button>(R.id.removebutton)
            .setOnClickListener {
                val intent= Intent(this, result_screen::class.java)
                startActivity(intent)
            }
    }

    private fun startFileChooser(){
        var i= Intent()
        i.setType("video/*")
        i.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(i, "Choose File"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==111 && resultCode== Activity.RESULT_OK && data != null){
            filepath= data.data!!
            videoView = findViewById<VideoView>(R.id.videoView)
            videoView.setVideoURI(filepath)
            videoView.seekTo(3000)
            videoView.pause()

        }
    }

    private fun startVideoPlayback() {
//        if (videoView == null){
//
//        }
        if (!videoView.isPlaying){
            videoView.start()
        }
    }
    private fun PauseVideoPlayback(){
        if (videoView.isPlaying){
            videoView.pause()
        }
    }


}