package yte.intern.springapplication.common.response;

public record UserMessageResponse(
        ResponseType responseType,
        String message,
        String password
){
}
