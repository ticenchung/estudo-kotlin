package br.com.luiz.purchase.repository

import br.com.luiz.purchase.models.Purchase
import org.springframework.data.mongodb.repository.MongoRepository

interface PurchaseRepository : MongoRepository<Purchase, String>