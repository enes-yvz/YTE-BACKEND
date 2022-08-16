package yte.intern.springapplication.common.response;


import yte.intern.springapplication.authentication.user.entity.User;

public record LoginMessageResponse(
        ResponseType responseType,
        String message,
        String user
) {


}
