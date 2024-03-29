package Lab02;

public class AimsProjects {
    public static void main(String[] args) {
        cart anOrder = new cart();
		DigitalVideosDics dvd1 = new DigitalVideosDics("Five Nights At Freddy's", "Horror", "Emma Tammi", 110, 11.45f);
		anOrder.addDigitalVideosDics(dvd1);
		
		DigitalVideosDics dvd2 = new  DigitalVideosDics("Past Lives", "Romatic", "Celine Song", 106, 14.22f);
		anOrder.addDigitalVideosDics(dvd2);
		DigitalVideosDics dvd3 = new  DigitalVideosDics("The Creator", "Action", "Gareth Edwards", 133, 15.23f);
		anOrder.addDigitalVideosDics(dvd3);

		DigitalVideosDics dvd4 = new  DigitalVideosDics("The Lion King",
		"Animation", "Roger Allers", 87, 19.95f );
		DigitalVideosDics dvd5 = new  DigitalVideosDics("Star Wars",
		"Science Fiction", "George Lucas", 87, 24.95f );
		DigitalVideosDics dvd6 = new  DigitalVideosDics("Aladin",
		"Animation", 18.99f );
		anOrder.addDigitalVideosDics(dvd4);
        anOrder.addDigitalVideosDics(dvd5);
        anOrder.addDigitalVideosDics(dvd6);
        anOrder.removeDigitalVideosDics(dvd6);
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
    }
}

