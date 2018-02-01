package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;



@Projection(name = "inlineComment", types = { Comment.class})
interface InlineComment {

    Long getId();

    String getComment();







}