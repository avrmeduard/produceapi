package com.book.produceapi.model.updatebook;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * addBookRsp
 * <p>
 * response after inserting a new book structure into DB.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookId",
        "responseDescription"
})
public class UpdateBookResponse {

    /**
     * The book id that has been created.
     *
     */
    @JsonProperty("bookId")
    @JsonPropertyDescription(" The id of the new created customer.")
    private Integer bookId;
    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    @JsonPropertyDescription(" Description of the status.")
    private String responseDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The id of the new created customer.
     *
     */
    @JsonProperty("bookId")
    public Integer getBookId() {
        return bookId;
    }

    /**
     * The id of the new created customer.
     *
     */
    @JsonProperty("bookId")
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

