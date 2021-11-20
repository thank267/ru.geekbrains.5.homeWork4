package ru.geekbrains.homework4.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private Long id;
	private String title;
	private Integer cost;
}
