package com.book.produceapi.model.getbook;


import com.book.produceapi.model.bookmodel.Book;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "book",
        "responseDescription"
})

public class GetBookResponse {

    /**
     * List of books
     */
    @JsonProperty("book")
    private ArrayList<Book> getBooks;

    /**
     * Description of the status.
     *
     */
    @JsonProperty("responseDescription")
    @JsonPropertyDescription(" Description of the status.")
    private String responseDescription;

    /**
     * Additional properties of the book.
     *
     */
    @JsonProperty("additionalProperties")
    @JsonPropertyDescription(" Additional properties if they where added.")
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


    /**
     * List of books
     */
    @JsonProperty("book")
    public ArrayList<Book> getGetBooks() {
        return getBooks;
    }

    /**
     * List of books
     */
    @JsonProperty("book")
    public void setGetBooks(ArrayList<Book> getBooks) {
        this.getBooks = getBooks;
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




    /**
     * Additional properties of the book.
     *
     */
    @JsonProperty("additionalProperties")
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * Additional properties of the book.
     *
     */
    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "GetBookResponse{" +
                "getBooks=" + getBooks +
                ", responseDescription='" + responseDescription + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
