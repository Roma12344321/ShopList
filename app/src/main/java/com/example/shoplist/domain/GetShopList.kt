package com.example.shoplist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetShopList @Inject constructor(private val shopListRepository: ShopListRepository) {
    fun getShopList():LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }
}