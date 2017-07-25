package com.rr.servlets.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ForumUser {

    @Getter @Setter
    private String userName;
    @Getter @Setter
    private String userPassword;
}
