package com.Oreki5.JobBoardingApplication.Models;



import lombok.Data;

@Data
public class ResponseModel<T> {

    private T data;
    private ErrorModel error;

    public ResponseModel(T data){
        this.data = data;
    }


}
