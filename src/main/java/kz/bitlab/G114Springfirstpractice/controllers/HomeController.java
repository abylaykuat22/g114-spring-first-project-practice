package kz.bitlab.G114Springfirstpractice.controllers;

import java.util.List;
import kz.bitlab.G114Springfirstpractice.db.DBManager;
import kz.bitlab.G114Springfirstpractice.enums.ItemStatus;
import kz.bitlab.G114Springfirstpractice.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("zattar", DBManager.getItems());
    return "home";
  }

  @GetMapping("details/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    var countries = List.of("CHINA", "USA", "Finland", "Japan", "Korea", "France", "Italy");

    model.addAttribute("statuses", ItemStatus.values());
    model.addAttribute("countries", countries);
    model.addAttribute("item", DBManager.getItemById(id));
    return "details";
  }

  @PostMapping("add-item")
  public String addItem(Item item) {
    DBManager.addItem(item);
    return "redirect:/";
  }

  @PostMapping("edit-item/{id}")
  public static String editItem(@PathVariable Long id, Item item) {
    DBManager.editItem(id, item);
    return "redirect:/details/" + id;
  }

  @PostMapping("delete-item/{id}")
  public static String deleteItem(@PathVariable Long id) {
    DBManager.deleteItemById(id);
    return "redirect:/";
  }
}
