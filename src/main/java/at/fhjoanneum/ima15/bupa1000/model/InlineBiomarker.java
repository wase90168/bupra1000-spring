package at.fhjoanneum.ima15.bupa1000.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineBiomarker", types = {Biomarker.class})
interface InlineBiomarker
{
    Long getId();

    String getName();

    String getBiomarker();

    String getDescription();

    Category getCategory();


}
