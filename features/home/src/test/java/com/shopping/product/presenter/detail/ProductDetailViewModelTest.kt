package com.shopping.product.presenter.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.shopping.product.dataset.ProductDataset.FAKE_PRODUCT
import com.shopping.product.domain.usecase.GetProductDetailUseCase
import com.shopping.product.utils.MainCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductDetailViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var getProductDetailUseCase: GetProductDetailUseCase

    private lateinit var productDetailViewModel: ProductDetailViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        productDetailViewModel = ProductDetailViewModel(getProductDetailUseCase)
    }

    @Test
    fun `get product detail- Turbine`() =
        runTest {

            val response = GetProductDetailUseCase.Result.Success(FAKE_PRODUCT)
            coEvery { getProductDetailUseCase("1") } returns response

            productDetailViewModel.product.test {
                productDetailViewModel.getProductDetail("1")
                Assert.assertEquals(awaitItem(), response.data)
                cancelAndConsumeRemainingEvents()
            }
        }
}