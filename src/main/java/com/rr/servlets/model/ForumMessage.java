package com.rr.servlets.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForumMessage {

    @Getter @Setter
    private String message;
    @Getter
    private ForumUser messageAuthor;
}
