package yte.intern.springapplication.common.response;


public record LoginMessageResponse(
        ResponseType responseType,
        String message,
        String user
) {


}
