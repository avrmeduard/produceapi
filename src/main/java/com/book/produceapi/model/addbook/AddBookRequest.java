package com.book.produceapi.model.addbook;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * addBookReq
 * <p>
 * Add a new Book.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "book"
})
public class AddBookRequest {

    /**
     * Book to be added
     *
     */
    @JsonProperty("book")
    @JsonPropertyDescription(" Book that needs to be added")
    @Valid
    private AddBook book;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Book to be added
     *
     */
    @JsonProperty("book")
    public AddBook getBook() {
        return book;
    }

    /**
     * Book to be added
     *
     */
    @JsonProperty("book")
    public void setBook(AddBook book) {
        this.book = book;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "AddCustomerRequest{" +
                "book=" + book +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
