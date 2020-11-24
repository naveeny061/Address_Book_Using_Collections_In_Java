package com.addressBook;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressMethods {
	ArrayList<Address> addressBook = new ArrayList<Address>();

	void Add() {
		Address address = new Address();
		addressBook.add(address);
	}

	void Show() {
		Iterator itr = addressBook.iterator();
		while (itr.hasNext()) {
			Address address = (Address) itr.next();
			System.out.println("Name- " + address.getFirst_Name() + " " + address.getLast_Name());
			System.out.println("Address- " + address.getAddress());
			System.out.println("City- " + address.getCity());
			System.out.println("State- " + address.getState());
			System.out.println("Zip- " + address.getZip());
			System.out.println("Phone Number- " + address.getPhone_Number());
			System.out.println("Email - " + address.getEmail());
		}
	}
}
