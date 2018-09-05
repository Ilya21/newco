package com.andreitop.newco.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;


public class TripDto implements Serializable {

    private static final long serialVersionUID = 5914366185889783660L;

    @Min(0)
    private Long id;
    @NotNull
    @Size(min = 2, max = 50)
    private String origin;
    @NotNull
    private String destination;
    @NotNull
    @Min(0)
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto tripDto = (TripDto) o;
        return Objects.equals(id, tripDto.id) &&
                Objects.equals(origin, tripDto.origin) &&
                Objects.equals(destination, tripDto.destination) &&
                Objects.equals(price, tripDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, price);
    }
}
