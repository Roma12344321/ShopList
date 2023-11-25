package com.example.shoplist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun delete(shopItem: ShopItem)
    suspend fun edit(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int):ShopItem
    fun getShopList():LiveData<List<ShopItem>>
}