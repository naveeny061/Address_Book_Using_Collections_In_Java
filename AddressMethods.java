package com.addressBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressMethods {

	Set<Address> addressBook = new LinkedHashSet<Address>();

	void Add() {

		boolean flag = true;
		Address address = new Address();
		for (Address iterator : addressBook) {
			if (iterator.getFirst_Name().equalsIgnoreCase(address.getFirst_Name()))
				flag = false;
		}
		if (flag)
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
	void Show(List<Address> addressBook) {
		Iterator<Address> itr = addressBook.iterator();
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

	void Edit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name whose deatils need to change  ");
		String name = scanner.nextLine();
		System.out.println("Enter the detail you have to edit");
		while (true) {
			System.out.println("Press 1 : Address");
			System.out.println("Press 2 : City");
			System.out.println("Press 3 : State");
			System.out.println("Press 4 : Zip");
			System.out.println("Press 5 : Phone Number");
			System.out.println("Press 0 : Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the new Address Name");
				String Addresss = scanner.next();
				for (Address iterator : addressBook) {
					if (iterator.getFirst_Name().equalsIgnoreCase(name))
						iterator.setAddress(Addresss);
				}
				break;
			case 2:
				System.out.println("Enter the new City");
				String City = scanner.next();
				for (Address iterator : addressBook) {
					if (iterator.getFirst_Name().equalsIgnoreCase(name))
						iterator.setCity(City);
				}
				break;
			case 3:
				System.out.println("Enter the new State");
				String State = scanner.next();
				for (Address iterator : addressBook) {
					if (iterator.getFirst_Name().equalsIgnoreCase(name))
						iterator.setState(State);
				}
				break;
			case 4:
				System.out.println("Enter the new Zip");
				String Zip = scanner.next();
				for (Address iterator : addressBook) {
					if (iterator.getFirst_Name().equalsIgnoreCase(name))
						iterator.setZip(Zip);
				}
				break;
			case 5:
				System.out.println("Enter the new Phone Number");
				String Phone_Number = scanner.next();
				for (Address iterator : addressBook) {
					if (iterator.getFirst_Name().equalsIgnoreCase(name))
						iterator.setPhone_Number(Phone_Number);
				}
				break;
			case 0:
				return;
			default:
				System.out.println("Please Enter Correct Option");
			}
		}
	}

	void Delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Name whose data to delete");
		String name = scanner.nextLine();
		for (Address iterator : addressBook) {
			if (iterator.getFirst_Name().equalsIgnoreCase(name))
				addressBook.remove(iterator);

		}
	}

	public void sortByName() {
		
		List<String> unsortedArrayName = new ArrayList<>();
		for (Address iterator : addressBook) {
			unsortedArrayName.add(iterator.getFirst_Name());	
		}
		Stream<String> sorted = unsortedArrayName.stream().sorted();
		List<String> sortedNames = sorted.collect(Collectors.toList());
		
		List<Address> sortedAddressBook = new ArrayList<Address>();
		for(String sortedName : sortedNames) {
			for (Address iterator : addressBook) {
				if(sortedName.equals(iterator.getFirst_Name()))
					sortedAddressBook.add(iterator);
			}
		}
		
		Show(sortedAddressBook);
	}

}