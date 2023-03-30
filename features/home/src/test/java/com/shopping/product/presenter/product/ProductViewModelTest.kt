package com.shopping.product.presenter.product

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.shopping.product.dataset.ProductDataset.FAKE_PRODUCTS
import com.shopping.product.domain.usecase.GetProductListUseCase
import com.shopping.product.utils.MainCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
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
    fun `get product list - Turbine`() =

        runTest {

            val data = GetProductListUseCase.Result.Success(FAKE_PRODUCTS)

            coEvery { getProductListUseCase() } returns data

            // Use the Turbine library to test the flow
            productViewModel.productList.test {
                // Start the flow
                productViewModel.getProducts()

                // Assert that the emitted data matches the test data
                val searchResults = awaitItem()
                assertEquals(data.data, searchResults)
                cancelAndConsumeRemainingEvents()
            }
        }
}