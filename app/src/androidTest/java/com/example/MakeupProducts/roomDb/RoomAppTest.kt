package com.example.MakeupProducts.roomDb

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.MakeupProducts.model.DataUsed
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@SmallTest
class RoomAppTest{


        private lateinit var database:RoomApp
        private lateinit var dao: RoomDao
        @Before
        fun setup(){
            database= Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext<Context>() ,
                RoomApp::class.java
            ).allowMainThreadQueries().build()
            dao= database.deo()!!
        }
        @After
        @Throws(IOException::class)
        fun teardown(){
            database.close()
        }
        @Test
        fun insertMeme()= runBlocking {
            val makeupItem1= DataUsed(7,"Maybeline","Mascara","https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz" )
            val makeupItem2=DataUsed(8,"Maybeline","Mascara","https://d3t32hsnjxo7q6.cloudfront.net/i/d4f7d82b4858c622bb3c1cef07b9d850_ra,w158,h184_pa,w158,h184.png","Why You'll Love It\\n\\nLightweight pigments blend easily and wear evenly\\nProvides a natural, fade-proof bronzed color that leaves skin the way it was meant to be...fresh, breathing and natural" )
            val listItems:List<DataUsed> = mutableListOf(makeupItem1,makeupItem2)
            dao.insertRetroData(listItems)
            val getMemeItems=dao. getALL()
            val byName=dao. getALL()
            assert(byName.size == getMemeItems.size)
        }
        @Test
        fun getAllMemes()= runBlocking {
            val makeupItem1= DataUsed(7,"Maybeline","Mascara","https://d3t32hsnjxo7q6.cloudfront.net/i/991799d3e70b8856686979f8ff6dcfe0_ra,w158,h184_pa,w158,h184.png","Maybelline Face Studio Master Hi-Light Light Boosting bronzer formula has an expert \\nbalance of shade + shimmer illuminator for natural glow. Skin goes \\nsoft-lit with zero glitz" )
            val makeupItem2=DataUsed(8,"Maybeline","Mascara","https://d3t32hsnjxo7q6.cloudfront.net/i/d4f7d82b4858c622bb3c1cef07b9d850_ra,w158,h184_pa,w158,h184.png","Why You'll Love It\\n\\nLightweight pigments blend easily and wear evenly\\nProvides a natural, fade-proof bronzed color that leaves skin the way it was meant to be...fresh, breathing and natural" )
            val listItems:List<DataUsed> = mutableListOf(makeupItem1,makeupItem2)
            dao.insertRetroData(listItems)
            val totalItems=dao.getALL()
            assert(totalItems.isNotEmpty())
        }

}