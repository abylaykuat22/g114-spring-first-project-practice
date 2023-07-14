package kz.bitlab.G114Springfirstpractice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
  private Long id;
  private String name;
  private String description;
  private double price;
}
