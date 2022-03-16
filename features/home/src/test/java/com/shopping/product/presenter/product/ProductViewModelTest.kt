package com.shopping.product.presenter.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shopping.product.dataset.ProductDataset.FAKE_PRODUCTS
import com.shopping.product.domain.usecase.GetProductListUseCase
import com.shopping.product.utils.MainCoroutineRule
import com.shopping.product.utils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK
    private lateinit var getProductListUseCase: GetProductListUseCase

    private lateinit var productViewModel: ProductViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        productViewModel = ProductViewModel(getProductListUseCase)
    }

    @Test
    fun `get product list`() =

        mainCoroutineRule.runBlockingTest {
            val data = GetProductListUseCase.Result.Success(FAKE_PRODUCTS)
            coEvery { getProductListUseCase.execute() } returns data
            productViewModel.getProducts()
            Assert.assertEquals(productViewModel.productList.getOrAwaitValue(), data.data)
        }
}