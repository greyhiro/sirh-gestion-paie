package dev.paie.web.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormaterDate {

	public String formaterDate(LocalDate date) {

		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	public String formaterDateTime(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH 'h' mm:ss "));
	}

}
