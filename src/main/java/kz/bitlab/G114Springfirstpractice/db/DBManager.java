package kz.bitlab.G114Springfirstpractice.db;

import static kz.bitlab.G114Springfirstpractice.enums.ItemStatus.DELIVERED;
import static kz.bitlab.G114Springfirstpractice.enums.ItemStatus.IN_SHOP;
import static kz.bitlab.G114Springfirstpractice.enums.ItemStatus.IN_STOCK;
import static kz.bitlab.G114Springfirstpractice.enums.ItemStatus.AT_THE_COURIER;
import static kz.bitlab.G114Springfirstpractice.enums.ItemStatus.IN_TRANSIT;


import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import kz.bitlab.G114Springfirstpractice.models.Item;
import lombok.Getter;

public class DBManager {

  @Getter
  private static List<Item> items = new ArrayList<>();

  private static Long id = 6L;

  static {
    items.add(new Item(1L, "IPhone 14 PRO MAX", "256 gb", 500000, 10, "USA", DELIVERED));
    items.add(new Item(2L, "Matarolla Startak", "256 mb", 40000, 5, "USA", IN_SHOP));
    items.add(new Item(3L, "Nokia 3310 256", "128 mb", 20000, 0, "Finland", IN_STOCK));
    items.add(new Item(4L, "Patford", "16mb", 10000, 51, "China", IN_TRANSIT));
    items.add(new Item(5L, "Sony Ericson", "64mb", 40000, 0, "Japan", AT_THE_COURIER));
//    items.add(buildItem(1L, "IPhone 14 PRO MAX","256 gb", 50000));
  }

  public static Item getItemById(Long id) {
    return items.stream().filter(item -> Objects.equals(item.getId(), id))
        .findFirst()
        .orElse(null);
  }

  public static void addItem(Item item) {
    item.setId(id);
    id++;
    items.add(item);
  }

  public static void editItem(Long id, Item updatedItem) {
    Item item = getItemById(id);
    if (item == null) {
      return;
    }
    item.setName(updatedItem.getName());
    item.setDescription(updatedItem.getDescription());
    item.setPrice(updatedItem.getPrice());
  }

  public static void deleteItemById(Long id) {
    items.removeIf(item -> Objects.equals(item.getId(), id));
  }

  private static Item buildItem(Long id, String name, String description, double price) {
    return Item.builder()
        .id(id)
        .name(name)
        .description(description)
        .price(price)
        .build();
  }
}
