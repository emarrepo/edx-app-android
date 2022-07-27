package org.edx.mobile.inapppurchases

// Todo Remove when course product mapping is complete
object ProductManager {
    private val skuManager = mapOf(
        "course-v1:edX+DemoX+Demo_Course" to "cv.xlera.mobile.pega.integrationtest",
        "course-v1:edx+Test101+course" to "cv.xlera.mobile.pega.test_product2",
        "course-v1:DemoX+PERF101+course" to "cv.xlera.mobile.pega.test_product1",
        "course-v1:test2+2+2" to "cv.xlera.mobile.pega.test_product3",
        "course-v1:test3+test3+3" to "cv.xlera.mobile.pega.test_product4",
        "course-v1:test5+5+5" to "cv.xlera.mobile.pega.test_product"
    )

    fun getProductByCourseId(courseId: String) = skuManager[courseId]
}
