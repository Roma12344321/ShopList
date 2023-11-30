package com.example.shoplist.domain

import javax.inject.Inject

class DeleteShopItem @Inject constructor(private val shopListRepository: ShopListRepository) {
    suspend fun delete(shopItem: ShopItem){
        shopListRepository.delete(shopItem)
    }
}