package udea.billing.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Bill
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-12-02T16:02:27.886Z")

public class Bill   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("createdDate")
  private String createdDate = null;

  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("order")
  @Valid
  private List<ItemOrder> order = new ArrayList<ItemOrder>();

  public Bill id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Bill createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Get createdDate
   * @return createdDate
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Bill customer(Customer customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Bill order(List<ItemOrder> order) {
    this.order = order;
    return this;
  }

  public Bill addOrderItem(ItemOrder orderItem) {
    this.order.add(orderItem);
    return this;
  }

   /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<ItemOrder> getOrder() {
    return order;
  }

  public void setOrder(List<ItemOrder> order) {
    this.order = order;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bill bill = (Bill) o;
    return Objects.equals(this.id, bill.id) &&
        Objects.equals(this.createdDate, bill.createdDate) &&
        Objects.equals(this.customer, bill.customer) &&
        Objects.equals(this.order, bill.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdDate, customer, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bill {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

