package com.example.shoplist.domain

import javax.inject.Inject

class GetShopItem @Inject constructor(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId: Int):ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}