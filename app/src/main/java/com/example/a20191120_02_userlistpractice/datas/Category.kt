package com.example.a20191120_02_userlistpractice.datas

import org.json.JSONObject

class Category {

    var id=0
    var title = ""
    var color = ""

    companion object{

        fun getCategoryFromJson(cateJson: JSONObject): Category{

            var categoryObject = Category()

            categoryObject.id = cateJson.getInt("id")
            categoryObject.title= cateJson.getString("title")
            categoryObject.color=cateJson.getString("color")



            return categoryObject
        }
    }


}