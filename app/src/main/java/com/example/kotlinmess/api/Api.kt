package com.example.kotlinmess.api

import com.example.kotlinmess.model.LoginResponseModel
import com.example.kotlinmess.model.RegistrationResponseModel
import com.example.kotlinmess.model.VerificationResponseModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("api/v1/auth/register")
    fun getRegister(
        @Field("name") name: String?,
        @Field("phone") phone: String?,
        @Field("password") password: String?,
        @Field("email") email: String?
    ): Call<RegistrationResponseModel>


    @FormUrlEncoded
    @POST("auth/email-verification")
    fun verification(
        @Field("user_id") user_id: String?,
        @Field("verification_code") verification_code: String?
    ):Call<VerificationResponseModel>

//    @FormUrlEncoded
//    @POST("auth/resend-code")
//    Call<ResponseModel> resendCode(
//            @Field("user_id") String user_id
//    );

    //    @FormUrlEncoded
    //    @POST("auth/resend-code")
    //    Call<ResponseModel> resendCode(
    //            @Field("user_id") String user_id
    //    );
    @FormUrlEncoded
    @POST("auth/login")
    fun logIn(
        @Field("email") email: String?,
        @Field("password") password: String?
    ):Call<LoginResponseModel>

}