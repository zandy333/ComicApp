package com.example.comicapp

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val MINIMUM_PAGE_NUMBER: Int = 1 // Insert your minimum / lowest page number here
    private val MAXIMUM_PAGE_NUMBER: Int = 4 // Insert your maximum / highest page number here
    // assuming all the pages are numbered in the correct order

    private var currentPage: Int = MINIMUM_PAGE_NUMBER

    private lateinit var imgVw: ImageView
    private lateinit var prevButtonTop: Button
    private lateinit var nextButtonTop: Button
    private lateinit var prevButtonBottom: Button
    private lateinit var nextButtonBottom: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgVw = findViewById<ImageView>(R.id.img_vw)
        prevButtonTop = findViewById<Button>(R.id.prev_button_top)
        nextButtonTop = findViewById<Button>(R.id.next_button_top)
        prevButtonBottom = findViewById<Button>(R.id.prev_button_bottom)
        nextButtonBottom = findViewById<Button>(R.id.next_button_bottom)

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

    private fun goToPreviousPage() {
        var currentPageMinusOne = currentPage - 1
        var imgId = resources.getIdentifier(applicationContext.packageName+":drawable/pg$currentPageMinusOne", "drawable", packageName)
        imgVw.setImageBitmap(BitmapFactory.decodeResource(resources, imgId))
        currentPage -= 1
    }

    private fun goToNextPage() {
        var currentPagePlusOne = currentPage + 1
        var imgId = resources.getIdentifier(applicationContext.packageName+":drawable/pg$currentPagePlusOne", "drawable", packageName)
        imgVw.setImageBitmap(BitmapFactory.decodeResource(resources, imgId))
        currentPage += 1
    }
}