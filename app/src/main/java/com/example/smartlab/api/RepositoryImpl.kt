package com.example.smartlab.api

import android.os.Build
import coil.network.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

import androidx.annotation.RequiresExtension;
class RepositoryImpl(
    private val api: Api
) : Repository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun sendCodeEmail(email: String): Flow<Result<String>> {
        return flow{
            val request = try{
                api.sendCodeEmail(email)
            }
            catch (e: IOException) {
                e.printStackTrace()
                emit( Result.Error(message = "Don't send code"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Don't send code"))
                return@flow
            }
            emit(Result.Success(request))
        }
    }
    @RequiresExtension(
        extension = Build.VERSION_CODES.S,
        version = 7
    )
    override suspend fun signInCode(code: String, email: String): Flow<Result<String>> {
        return flow {
            try {
                api.signInCode(code, email)
            } catch (e: java.io.IOException) {
                e.printStackTrace()
                emit(
                    Result.Error(message = "Don't get code")
                )
                return@flow
            } catch (e: retrofit2.HttpException) {
                e.printStackTrace()
                emit(
                    Result.Error(message = "Don't get code")
                )
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(
                    Result.Error(message = "Don't send code")
                )
                return@flow
            }

            emit(
                Result.Success("Get token")
            )
        }
    }
}
