package com.example.shoplist.domain

data class ShopItem(
    val name:String,
    val count:Int,
    val enable:Boolean,
    var id:Int = UNDEF_ID
){
    companion object{
        const val UNDEF_ID = 0
    }
}