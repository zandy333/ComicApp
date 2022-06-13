package com.example.comicapp

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val PACKAGE_NAME: String = applicationContext.packageName

        val MINIMUM_PAGE_NUMBER: Int = 1 // Insert your minimum / lowest page number here
        val MAXIMUM_PAGE_NUMBER: Int = 4 // Insert your maximum / highest page number here
        // assuming all the pages are numbered in the correct order

        var currentPage: Int = MINIMUM_PAGE_NUMBER

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imgVw: ImageView = findViewById<ImageView>(R.id.img_vw)
        var prevButtonTop: Button = findViewById<Button>(R.id.prev_button_top)
        var nextButtonTop: Button = findViewById<Button>(R.id.next_button_top)
        var prevButtonBottom: Button = findViewById<Button>(R.id.prev_button_bottom)
        var nextButtonBottom: Button = findViewById<Button>(R.id.next_button_bottom)

        fun goToPreviousPage() {
            var currentPageMinusOne = currentPage - 1
            var imgId = resources.getIdentifier("$PACKAGE_NAME:drawable/pg$currentPageMinusOne", null, null)
            imgVw.setImageBitmap(BitmapFactory.decodeResource(resources, imgId))
            currentPage -= 1
        }

        fun goToNextPage() {
            var currentPagePlusOne = currentPage + 1
            var imgId = resources.getIdentifier("$PACKAGE_NAME:drawable/pg$currentPagePlusOne", null, null)
            imgVw.setImageBitmap(BitmapFactory.decodeResource(resources, imgId))
            currentPage += 1
        }

        prevButtonTop.setOnClickListener {
            if (currentPage > MINIMUM_PAGE_NUMBER ) {
                goToPreviousPage()
            }
        }

        nextButtonTop.setOnClickListener {
            if (currentPage < MAXIMUM_PAGE_NUMBER ) {
                goToNextPage()
            }
        }

        prevButtonBottom.setOnClickListener {
            if (currentPage > MINIMUM_PAGE_NUMBER ) {
                goToPreviousPage()
            }
        }

        nextButtonBottom.setOnClickListener {
            if (currentPage < MAXIMUM_PAGE_NUMBER ) {
                goToNextPage()
            }
        }
    }
}