package udea.purchasingapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Validated

public class Bill   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("createdDate")
  private String createdDate = null;

  @JsonProperty("user")
  private User user = null;

  @JsonProperty("order")
  private List<ItemOrder> order = new ArrayList<ItemOrder>();

  public Bill id(String id) {
    this.id = id;
    return this;
  }

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

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Bill user(User user) {
    this.user = user;
    return this;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Bill order(List<ItemOrder> order) {
    this.order = order;
    return this;
  }

  public Bill addOrderItem(ItemOrder orderItem) {
    this.order.add(orderItem);
    return this;
  }

  public List<ItemOrder> getOrder() {
    return order;
  }

  public void setOrder(List<ItemOrder> order) {
    this.order = order;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bill bill = (Bill) o;
    return Objects.equals(this.id, bill.id) &&
        Objects.equals(this.createdDate, bill.createdDate) &&
        Objects.equals(this.user, bill.user) &&
        Objects.equals(this.order, bill.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createdDate, user, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bill {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

