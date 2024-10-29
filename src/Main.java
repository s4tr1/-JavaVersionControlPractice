import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Construct
     */
    private static final int ADD_CONTACT = 1;
    private static final int VIEW_CONTACTS = 2;
    private static final int DELETE_CONTACT = 3;
    private static final int EXIT = 4;

    /**
     * Array of contacts    that
     */
    private ArrayList<Kontak> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /**
         * Construct    contacts
         */
        Main app = new Main();
        app.run();
    }

    public void run() {
        int option = 0;
        while (option != EXIT) {
            displayMenu();
            option = getOption();
            handleOption(option);
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("=== Menu Daftar Kontak ===");
        System.out.println("1. Tambah Kontak");
        System.out.println("2. Lihat Semua Kontak");
        System.out.println("3. Hapus Kontak");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
    }

    private int getOption() {
        return scanner.nextInt();
    }

    private void handleOption(int option) {
        scanner.nextLine(); // clear newline
        switch (option) {
            case ADD_CONTACT:
                addContact();
                break;
            case VIEW_CONTACTS:
                viewAllContacts();
                break;
            case DELETE_CONTACT:
                deleteContact();
                break;
            case EXIT:
                System.out.println("Keluar...");
                break;
            default:
                System.out.println("Opsi tidak valid!");
        }
    }

    /**
     * @method menambahkan contact
     */
    private void addContact() {
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan nomor telepon: ");
        String phoneNumber = scanner.nextLine();
        contacts.add(new Kontak(name, phoneNumber));
        System.out.println("Kontak berhasil ditambahkan!");
    }

    private void viewAllContacts() {
        System.out.println("Daftar Kontak:");
        if (contacts.isEmpty()) {
            System.out.println("Tidak ada kontak yang tersimpan.");
        } else {
            for (Kontak contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    /**
     * Method delete contact
     */
    private void deleteContact() {
        System.out.print("Masukkan nama kontak yang ingin dihapus: ");
        String nameToRemove = scanner.nextLine();
        boolean removed = contacts.removeIf(contact -> contact.name.equals(nameToRemove));
        if (removed) {
            System.out.println("Kontak berhasil dihapus.");
        } else {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}