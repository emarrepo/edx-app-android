package org.edx.mobile.extenstion

import org.edx.mobile.http.model.NetworkResponseCallback
import org.edx.mobile.http.model.Result
import org.edx.mobile.util.InAppPurchasesException
import org.json.JSONObject
import retrofit2.Response

fun <T> Response<T>.toResult(callback: NetworkResponseCallback<T>, apiCode: Int) {
    when (isSuccessful) {
        true -> callback.onSuccess(
            Result.Success(
                isSuccessful = isSuccessful,
                data = body(),
                code = code(),
                message = message()
            )
        )
        false -> callback.onError(
            Result.Error(
                InAppPurchasesException(
                    errorCode = apiCode,
                    httpErrorCode = code(),
                    errorMessage = getMessage(),
                )
            )
        )
    }
}

fun <T> Response<T>.getMessage(): String? {
    if (isSuccessful) return message()
    val message: String? = try {
        val errors = JSONObject(errorBody()?.string() ?: "{}")
        errors.optString("error")
    } catch (ex: Exception) {
        null
    }
    return message
}
