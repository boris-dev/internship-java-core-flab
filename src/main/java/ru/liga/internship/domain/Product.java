package ru.liga.internship.domain;

import java.math.BigDecimal;

public class Product {
  private String name;
  private BigDecimal price;
  private String description;

  public Product(String name, BigDecimal price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
